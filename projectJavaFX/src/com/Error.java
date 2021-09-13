package com;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Error {
    public static void display(){
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("ERROR !@^#!@$");
        dialog.setMinWidth(300);
        dialog.setMinHeight(90);


        Label label = new Label();
        label.setText("Podałeś złe dane!");


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);

        Scene scene=new Scene(layout);

        dialog.setScene(scene);
        dialog.showAndWait();
    }
}
