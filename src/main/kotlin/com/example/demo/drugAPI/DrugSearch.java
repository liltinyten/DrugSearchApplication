package com.example.demo.drugAPI;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


// SEE https://rxnav.nlm.nih.gov/ for documentation
public class DrugSearch {


    public static Map<String, Object> jsonToMap (String str)  {

        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType());
        return map;
    }


    public static boolean checkString(String string) {
        if (string.contains(" ")) {
            return true;
        } else {
            return false;
        }


    }

    public static String getDrugClassByName(String drug){
        try {

            String DRUG = drug;



            String urlString = "https://rxnav.nlm.nih.gov/REST/rxclass/class/byDrugName.json?drugName="+drug+"&relaSource=VA";

            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = (Map<String, Object>) respMap.get("rxclassDrugInfoList");
            ArrayList<Map<String, Object>> infoList = (ArrayList<Map<String, Object>>) mainMap.get("rxclassDrugInfo");

            Map<String, Object> drugInfoMap = infoList.get(0);
            Map<String, Object> drugInfo = (Map<String, Object>) drugInfoMap.get("rxclassMinConceptItem");



            return (String) drugInfo.get("className");


        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "null";
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return "null";
        }
    }

    public static String getDrugIndicationsByName(String drug){
        try {

            String DRUG = drug;



            String urlString = "https://rxnav.nlm.nih.gov/REST/rxclass/class/byDrugName.json?drugName="+drug+"&relaSource=MEDRT&relas=may_treat";





            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = (Map<String, Object>) respMap.get("rxclassDrugInfoList");
            ArrayList<Map<String, Object>> infoList = (ArrayList<Map<String, Object>>) mainMap.get("rxclassDrugInfo");


            ArrayList<String> includedInList = new ArrayList<String>();
            String indicationList = "";


            for (Map<String, Object> sub: infoList) {
                Map<String, Object> drugInfo = (Map<String, Object>) sub.get("rxclassMinConceptItem");
                String indication = (String) drugInfo.get("className");

                if (!includedInList.contains(indication)) {
                    indicationList += indication + "\n\n";
                    includedInList.add(indication);
                }
            }




            return indicationList;


        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "null";
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return "null";
        }
    }

    public static String getDrugReactionsByName(String drug){
        try {

            String DRUG = drug;



            String urlString = "https://api.fda.gov/drug/event.json?search=patient.drug.medicinalproduct:"+drug+"&count=patient.reaction.reactionmeddrapt.exact";





            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            ArrayList<Map<String, Object>> reactionMapList = (ArrayList<Map<String, Object>>) respMap.get("results");


            String reactionList = "";


            for (Map<String, Object> sub: reactionMapList) {
                String reaction = (String) sub.get("term");

                reactionList += reaction + "\n\n";
            }




            return reactionList;


        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "null";
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return "null";
        }
    }

    public static String getDrugDosageFormByName(String drug){
        try {

            String DRUG = drug;



            String urlString = "https://api.fda.gov/drug/drugsfda.json?search=products.brand_name:"+drug+"&count=products.dosage_form.exact";





            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            ArrayList<Map<String, Object>> formMapList = (ArrayList<Map<String, Object>>) respMap.get("results");


            String formList = "";


            for (Map<String, Object> sub: formMapList) {
                String reaction = (String) sub.get("term");

                formList += reaction + "\n\n";
            }




            return formList;


        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "null";
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return "null";
        }
    }




}
