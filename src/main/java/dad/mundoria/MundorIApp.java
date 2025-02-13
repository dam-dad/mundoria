package dad.mundoria;

import dad.mundoria.controller.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MundorIApp extends Application {
	
	private MenuController menuController = new MenuController();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Stage mundoriaStage = new Stage();
        mundoriaStage.setTitle("Karaoke");
        mundoriaStage.setScene(new Scene(menuController.getRoot()));
        mundoriaStage.show();
		
	}

}
