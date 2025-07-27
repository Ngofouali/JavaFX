package com.icodi.tpjavafx.controller;

import com.icodi.tpjavafx.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ProductController {

        @FXML
        private TextField nameTextField;

        @FXML
        private TextField priceTextField;

        @FXML
        private Button addButton;

        @FXML
        private ListView<Product> productListView;

        // Liste observable pour stocker les produits.
        // Les changements dans cette liste mettront automatiquement à jour la ListView.
        private ObservableList<Product> productList;

        /**
         * Méthode appelée automatiquement après le chargement du fichier FXML.
         * Utilisée pour initialiser le contrôleur.
         */
        @FXML
        public void initialize() {
            // Initialise la liste observable
            productList = FXCollections.observableArrayList();

            // Ajoute quelques produits exemples (optionnel)
            productList.add(new Product("Ordinateur Portable", 20000));
            productList.add(new Product("Souris Sans Fil", 25500));
            productList.add(new Product("Clavier", 89000));

            // Lie la liste observable à la ListView
            productListView.setItems(productList);

            // Ahout d'écouteurs
            // productListView.getSelectionModel().selectedItemProperty().addListener(...)
        }

        /**
         * Méthode appelée lorsque le bouton "Ajouter Produit" est cliqué.
         */
        @FXML
        protected void handleAddProduct() {
            String name = nameTextField.getText().trim();
            String priceText = priceTextField.getText().trim();

            // Validation
            if (name.isEmpty()) {
                showAlert(AlertType.ERROR, "Erreur de saisie", "Le nom du produit ne peut pas être vide.");
                return;
            }

            double price;
            try {
                // Remplacement la virgule par un point pour la conversion
                price = Double.parseDouble(priceText.replace(',', '.'));
                if (price < 0) {
                    showAlert(AlertType.ERROR, "Erreur de saisie", "Le prix ne peut pas être négatif.");
                    return;
                }
            } catch (NumberFormatException e) {
                showAlert(AlertType.ERROR, "Erreur de saisie", "Veuillez entrer un prix valide (nombre).");
                return;
            }

            // Créer un nouveau produit
            Product newProduct = new Product(name, price);

            // Ajouter le produit à la liste observable (met à jour la ListView)
            productList.add(newProduct);

            // Effacer les champs du formulaire
            clearForm();
        }

        /**
         * Efface les champs du formulaire.
         */
        private void clearForm() {
            nameTextField.clear();
            priceTextField.clear();
            nameTextField.requestFocus(); // Remet le focus sur le champ nom
        }

        /**
         * Affiche une boîte de dialogue d'alerte.
         * @param alertType Le type d'alerte (ERROR, INFORMATION, WARNING)
         * @param title Le titre de la boîte de dialogue
         * @param message Le message à afficher
         */
        private void showAlert(AlertType alertType, String title, String message) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }

}
