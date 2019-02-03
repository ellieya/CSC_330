package edu.cuny.csi.csc330.examples;

import javax.swing.JLabel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class SimpleFXer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	final String message = "Hello, Java FX World!";
    	
        primaryStage.setTitle(message + " App");
        Button button = new Button();
        button.setText( message);
        
        Label label = new Label(message);
        
        label.setVisible(true);  
        
        button.setOnAction(new EventHandler<ActionEvent>() {
        	private boolean visible = label.isVisible(); 
            @Override
            public void handle(ActionEvent event) {
				if (visible) visible = false; 
				else visible = true;
				
				label.setVisible(visible);
				
				primaryStage.show();
            }
        });
        
        FlowPane root = new FlowPane();
        root.getChildren().addAll(button, label);

        primaryStage.setScene(new Scene(root, 150, 150));
        primaryStage.show();
        
    }
}