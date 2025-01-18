/**********************************************
 Workshop #02
 Course: APD545
 Last Name: Zadafiya
 First Name: Manav
 ID: 144095221
 Section: ZAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date:2024-10-06
 **********************************************/

package com.workshop.workshop02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/workshop/workshop02/view/pizza_order.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Pizza Ordering System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
