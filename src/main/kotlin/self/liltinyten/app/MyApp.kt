package self.liltinyten.app

import self.liltinyten.view.MainView
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        stage.isResizable = true
        stage.maxHeight = 900.0
        stage.maxWidth = 600.0
        stage.isAlwaysOnTop = true
        super.start(stage)
    }
}