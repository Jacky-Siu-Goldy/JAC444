package w7.app;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import w7.view.AddressPane;
/**********************************************
Workshop # 7
Course: JAC444 - Winter 2023
Last Name: Siu
First Name: Jacky Chun Kit 
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-24
**********************************************/
/**
 * App1 Application
 * 
 *
 */
public class App1 extends Application{
	private AddressPane view ;
        /**
         * Design of the Scene of App1's Primary Stage	
         */
		@Override
		public void start(@SuppressWarnings("exports") Stage ps) {
			AnchorPane ap = new AnchorPane();
			ComboBox<String>  cb = new ComboBox<String>();
			ObservableList<String> list = cb.getItems();
			list.add("home address");
			list.add("work address");
			list.add("alternative address");
			
			cb.relocate(10, 10);
			cb.setPrefSize(400, 30);
			
		    view = new AddressPane();
			view.relocate(10, 50);
			ap.getChildren().addAll(view, cb);
			
			Scene scene = new Scene(ap, 420,250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ps.setTitle("App1");
			//ps.setResizable(false);
			ps.setScene(scene);
			ps.show();
		}
	
		/**
		 * The Main of App1
		 * @param args - a String[]
		 */
		public static void main(String[] args) {
			
			launch(args);
			
		}
	
	
}
