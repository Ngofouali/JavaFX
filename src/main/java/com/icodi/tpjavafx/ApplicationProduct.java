package com.icodi.tpjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Parent;
import java.net.URL;

public class ApplicationProduct extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML
            // Utilisation de getClass().getResource() pour trouver le fichier dans les resources
            FXMLLoader loader = new FXMLLoader(getClass().getResource("product-view.fxml"));
            Parent root = loader.load();

            // Création de la scène
            Scene scene = new Scene(root);

            // Chargement et application de la feuille de style CSS
            URL cssUrl = getClass().getResource("style.css");
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            } else {
                System.err.println("Attention : Fichier styles.css non trouvé.");
            }


            // Configuration de la fenêtre principale (Stage)
            primaryStage.setTitle("Gestionnaire de Produits");
            primaryStage.setScene(scene);
            primaryStage.sizeToScene(); // Ajuste la taille de la fenêtre au contenu
            primaryStage.setMinWidth(400); // Largeur minimale
            primaryStage.setMinHeight(450); // Hauteur minimale
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de l'interface FXML :");
            e.printStackTrace();
            // Affichage d'une alerte à l'utilisateur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Chargement");
            alert.setHeaderText("Impossible de charger l'interface utilisateur.");
            alert.setContentText("L'application ne peut pas démarrer. Détails : " + e.getMessage());
            alert.showAndWait();
        } catch (Exception e) {
            System.err.println("Une erreur inattendue est survenue :");
            e.printStackTrace();
            // Alerte générique
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Inattendue");
            alert.setHeaderText("Une erreur inattendue s'est produite.");
            alert.setContentText("L'application a rencontré un problème. Détails : " + e.getMessage());
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}