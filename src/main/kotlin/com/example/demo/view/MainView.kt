package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.drugAPI.DrugSearch
import com.sun.javafx.binding.ContentBinding.bind
import javafx.beans.property.SimpleListProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.ListView
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import javafx.scene.text.Text
import tornadofx.*
import java.util.*
import kotlin.collections.ArrayList

class MainView : View("Drug Search Application") {

     private var searchName: String = "Tylenol"
    private var classProperty = text(DrugSearch.getDrugClassByName(searchName))
    private var sideEffects: Text = text(DrugSearch.getDrugReactionsByName(searchName))
    private var indications: Text = text(DrugSearch.getDrugIndicationsByName(searchName))
    private var forms: Text = text(DrugSearch.getDrugDosageFormByName(searchName))




    override val root = vbox {
        hbox(10.0, Pos.CENTER) {

            val searchbox = textfield {
                this.promptText = "Drug Name"
                this.minHeight = 60.0
                this.minWidth = 400.0
                this.font = Font(25.0)


            }

            button {
                this.text = "\uD83D\uDD0D"
                this.font = Font(25.0)
                this.minHeight = 60.0
                this.minWidth = 60.0
                this.onLeftClick {
                    searchName = searchbox.text
                    classProperty.text = DrugSearch.getDrugClassByName(searchName)
                    indications.text = DrugSearch.getDrugIndicationsByName(searchName)
                    sideEffects.text = DrugSearch.getDrugReactionsByName(searchName)
                    forms.text = DrugSearch.getDrugDosageFormByName(searchName)

                }
            }

            this.background = Background(BackgroundFill(Paint.valueOf("#D4D4D4"), CornerRadii.EMPTY, Insets.EMPTY))
            this.minHeight = 100.0
            this.minWidth = 600.0
        }
        hbox(0.0, Pos.CENTER) {
            this.background = Background(BackgroundFill(Paint.valueOf("Aqua"), CornerRadii.EMPTY, Insets.EMPTY))
            this.minHeight = 800.0
            this.minWidth = 600.0


                vbox(0.0, Pos.CENTER) {

                    this.minHeight = 800.0
                    this.minWidth = 300.0
                    this.background = Background(BackgroundFill(Paint.valueOf("Red"), CornerRadii.EMPTY, Insets.EMPTY))



                    vbox(0.0, Pos.CENTER) {
                        this.minWidth = 300.0
                        this.minHeight = 400.0
                        label("Drug Class") {
                            this.font = Font.font(20.0)
                        }
                        text{
                            this.bind(classProperty.textProperty())
                        }
                    }

                    vbox(0.0, Pos.CENTER) {
                        this.minWidth = 300.0
                        this.minHeight = 400.0
                        label("Dosage Forms") {
                            this.font = Font.font(20.0)
                        }

                        scrollpane() {
                            this.minWidth = 250.0
                            this.minHeight = 300.0
                            this.maxHeight = 300.0
                            this.maxWidth = 250.0
                            this.background = Background(BackgroundFill(Paint.valueOf("Gray"), CornerRadii.EMPTY, Insets.EMPTY))
                            text {
                                this.wrappingWidth = 230.0
                                this.font = Font.font(15.0)
                                bind(forms.textProperty())
                            }
                        }
                    }





                }


                vbox(0.0, Pos.CENTER) {
                    this.minHeight = 800.0
                    this.minWidth = 300.0


                    vbox(0.0, Pos.CENTER) {
                        this.minWidth = 300.0
                        this.minHeight = 400.0
                        this.background = Background(BackgroundFill(Paint.valueOf("Blue"), CornerRadii.EMPTY, Insets.EMPTY))


                        label("Treats") {
                            this.font = Font.font(20.0)
                        }

                        scrollpane() {
                            this.minWidth = 250.0
                            this.minHeight = 300.0
                            this.maxHeight = 300.0
                            this.maxWidth = 250.0
                            this.background = Background(BackgroundFill(Paint.valueOf("Gray"), CornerRadii.EMPTY, Insets.EMPTY))
                            text {
                                this.wrappingWidth = 230.0
                                this.font = Font.font(15.0)
                                bind(indications.textProperty())
                            }
                        }
                    }

                    vbox(0.0, Pos.CENTER) {
                        this.minWidth = 300.0
                        this.minHeight = 400.0
                        this.background = Background(BackgroundFill(Paint.valueOf("Purple"), CornerRadii.EMPTY, Insets.EMPTY))

                        label("Side Effects") {
                            this.font = Font.font(20.0)
                        }

                        scrollpane() {
                            this.minWidth = 250.0
                            this.minHeight = 300.0
                            this.maxHeight = 300.0
                            this.maxWidth = 250.0
                            this.background = Background(BackgroundFill(Paint.valueOf("Gray"), CornerRadii.EMPTY, Insets.EMPTY))

                            text {
                                this.wrappingWidth = 230.0
                                this.font = Font.font(15.0)
                                bind(sideEffects.textProperty())
                            }
                        }
                    }



                }




        }
    }
}