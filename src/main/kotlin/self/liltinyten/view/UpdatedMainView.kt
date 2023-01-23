package self.liltinyten.view

import self.liltinyten.drugAPI.DrugSearch
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import tornadofx.*

class UpdatedMainView : View("Drug Search Application") {

    private var searchName: String = "Tylenol"
    private var classProperty = text(DrugSearch.getDrugClassByName(searchName))
    private var sideEffects: Text = text(DrugSearch.getDrugReactionsByName(searchName))
    private var indications: Text = text(DrugSearch.getDrugIndicationsByName(searchName))
    private var forms: Text = text(DrugSearch.getDrugDosageFormByName(searchName))




    override val root = vbox {
        this.minHeight = 600.0
        this.minWidth = 800.0
        this.maxHeight = minHeight
        this.maxWidth = minWidth
        this.background = Background(BackgroundFill(Paint.valueOf(Color.BEIGE.toString()), CornerRadii.EMPTY, Insets.EMPTY))



        var topMenu = hbox {
            this.minHeight = 60.0
            this.minWidth = 800.0
            this.alignment = Pos.CENTER
            this.spacing = 30.0
            this.background = Background(BackgroundFill(Paint.valueOf("#2B1D14"), CornerRadii.EMPTY, Insets.EMPTY))
        }

        topMenu.text("DrugSearch") {
            this.fill = Paint.valueOf(Color.BEIGE.toString())
            this.font = Font.font(32.0)
            this.textAlignment = TextAlignment.CENTER
        }

        var searchBox = topMenu.textfield {
            this.promptText = "Drug"
            this.minWidth = 375.0
            this.minHeight = 40.0

            this.font = Font.font("Times", FontWeight.NORMAL, 22.0)
            this.background = Background(BackgroundFill(Paint.valueOf(Color.WHITE.toString()), CornerRadii(30.0), Insets.EMPTY))

        }

        var searchButton = topMenu.button {
            this.minHeight = 50.0
            this.minWidth = 50.0
            text {
                this.text = "\uD83D\uDD0D"
                this.font = Font.font("Times", FontWeight.NORMAL, 24.0)
                this.fill = Paint.valueOf("#2B1D14")
            }
            this.background = Background(BackgroundFill(Paint.valueOf(Color.BEIGE.toString()), CornerRadii(30.0), Insets.EMPTY))
        }

        var drugTitle = vbox {
            this.alignment = Pos.CENTER
            this.padding = Insets(10.0)
            this.spacing = 5.0

            var drugName = text("Test") {
                this.font = Font.font("Times", FontWeight.NORMAL, 36.0)
                this.fill = Paint.valueOf("#4a2c2a")
                this.id = "drugName"
            }



            hbox {
                this.background = Background(BackgroundFill(Paint.valueOf("#2B1D14"), CornerRadii(15.0), Insets.EMPTY))
                this.maxWidth = 400.0
                this.minHeight = 10.0
            }

            var drugClass = text {
                this.font = Font.font("Times", FontWeight.NORMAL, 18.0)
                this.fill = Paint.valueOf("#2B1D14")
                bind(classProperty.textProperty())
            }

        }


        var drugInformation = hbox {
            var boxWidth = 200.0
            var boxHeight = 300.0
            this.alignment = Pos.CENTER
            this.spacing = 20.0
            this.padding = Insets(50.0)


            var effects = vbox {
                this.alignment = Pos.CENTER
                this.spacing = 10.0

                text {
                    this.text = "Side Effects"
                    this.font = Font.font("Times", FontWeight.NORMAL, 18.0)
                }
                scrollpane {
                    text {
                        this.fill = Paint.valueOf(Color.BEIGE.toString())
                        bind(sideEffects.textProperty())
                        this.font = Font.font("Times", FontWeight.NORMAL, 12.0)
                    }
                    this.minHeight = boxHeight
                    this.minWidth = boxWidth
                    this.maxHeight = minHeight
                    this.maxWidth = minWidth
                    this.style = "-fx-background: #4a2c2a;"
                }
            }


            var uses = vbox {
                this.alignment = Pos.CENTER
                this.spacing = 10.0
                text {
                    this.text = "Indications"
                    this.font = Font.font("Times", FontWeight.NORMAL, 18.0)
                }
                scrollpane {
                    text {
                        this.fill = Paint.valueOf(Color.BEIGE.toString())
                        bind(indications.textProperty())
                        this.font = Font.font("Times", FontWeight.NORMAL, 12.0)
                    }
                    this.minHeight = boxHeight
                    this.minWidth = boxWidth
                    this.maxHeight = minHeight
                    this.maxWidth = minWidth
                    this.style = "-fx-background: #4a2c2a;"
                }
            }

            var forms = vbox {
                this.alignment = Pos.CENTER
                this.spacing = 10.0
                text {
                    this.text = "Dosage Forms"
                    this.font = Font.font("Times", FontWeight.NORMAL, 18.0)
                }
                scrollpane {
                    text {
                        this.fill = Paint.valueOf(Color.BEIGE.toString())
                        bind(forms.textProperty())
                        this.font = Font.font("Times", FontWeight.NORMAL, 12.0)

                    }
                    this.minHeight = boxHeight
                    this.minWidth = boxWidth
                    this.maxHeight = minHeight
                    this.maxWidth = minWidth
                    this.style = "-fx-background: #4a2c2a;"
                }
            }
        }


        searchButton.onLeftClick {
            searchName = searchBox.text
            classProperty.text = (DrugSearch.getDrugClassByName(searchName))
            sideEffects.text = (DrugSearch.getDrugReactionsByName(searchName))
            indications.text = (DrugSearch.getDrugIndicationsByName(searchName))
            forms.text = (DrugSearch.getDrugDosageFormByName(searchName))
        }








    }
}