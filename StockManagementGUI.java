

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StockManagementGUI extends Application {

    private ObservableList<Product> products = FXCollections.observableArrayList();  //dynamic list that update table view automatically
    private TableView<Product> table = new TableView<>(); //create a table to display products
    private String userName;
    private String userID; //auto-generated ID

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        Label welcomeLabel = new Label("Welcome to the Stock Management System (SMS)");
        welcomeLabel.setStyle("-fx-text-fill: DARKBLUE; -fx-font-weight: BOLD; -fx-font-sizr: 16px;");
        Label dateLabel = new Label("Current Date & Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Label groupLabel = new Label("Group Members:\nChuan Ning Le\nOoh Rui Hang\nOon Xiang Yu\nWilson Fook Wei Sheng");
        groupLabel.setStyle("-fx-text-fill: BLUE");

        TextInputDialog nameDialog = new TextInputDialog(); //prompt user to input name
        nameDialog.setTitle("Enter Name");
        nameDialog.setHeaderText("Please enter your full name:");
        Optional<String> nameResult = nameDialog.showAndWait(); // wait for user input



        if (!nameResult.isPresent()) {
            showAlert("Required", "Name is required to continue.");
            System.exit(0);
        }
        userName = nameResult.get().trim();
        userID = generateUserID(userName);
        Label userLabel = new Label("User: " + userName + " (ID: " + userID + ")");
        userLabel.setStyle("-fx-text-fill: DARKRED;");

        setupTable();

        Button addBtn = new Button("Add Product");
        Button viewBtn = new Button("View Details");
        Button addStockBtn = new Button("Add Stock");
        Button deductStockBtn = new Button("Deduct Stock");
        Button toggleStatusBtn = new Button("Discontinue / Reactivate");
        Button exitBtn = new Button("Exit");
        addBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); 
        viewBtn.setStyle("-fx-background-color: #2F4F4F; -fx-text-fill: white;"); 
        addStockBtn.setStyle("-fx-background-color: #8A2BE2; -fx-text-fill: white;");
        deductStockBtn.setStyle("-fx-background-color: #8A2BE2; -fx-text-fill: white;");
        toggleStatusBtn.setStyle("-fx-background-color: #800000; -fx-text-fill: white;");
        exitBtn.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

        //setup buttons for all operations

        addBtn.setOnAction(e -> addProduct());
        viewBtn.setOnAction(e -> viewProduct());
        addStockBtn.setOnAction(e -> updateStock(true));
        deductStockBtn.setOnAction(e -> updateStock(false));
        toggleStatusBtn.setOnAction(e -> toggleStatus());
        exitBtn.setOnAction(e -> {
            showAlert("Exit", "Username: " + userName + "\nUser ID: " + userID);
            System.exit(0);
        });
        //assign action to each button

        HBox btnBox = new HBox(10, addBtn, viewBtn, addStockBtn, deductStockBtn, toggleStatusBtn, exitBtn); 
        btnBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(welcomeLabel, dateLabel, groupLabel, userLabel, table, btnBox); //add all in root(VBox)
        Scene scene = new Scene(root, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stock Management GUI");
        primaryStage.show();
    }

    private void setupTable() {
        TableColumn<Product, String> nameCol = new TableColumn<>("Product Name"); //Create columns with labels
        nameCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getProductName())); //lambda used to bind to product property

        TableColumn<Product, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getClass().getSimpleName()));

        TableColumn<Product, Integer> qtyCol = new TableColumn<>("Quantity");
        qtyCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getQuantity()).asObject());

        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getPrice()).asObject());

        table.getColumns().addAll(nameCol, typeCol, qtyCol, priceCol);
        table.setItems(products); //connects the table to the dynamic products list
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //column resize when window resize (no empty space)
    }

    private void addProduct() {
        ChoiceDialog<String> choice = new ChoiceDialog<>("Refrigerator", "Refrigerator", "TV", "AirConditioner"); //presents a dropdown for selection
        choice.setTitle("Add Product");
        choice.setHeaderText("Select product type:");
        Optional<String> result = choice.showAndWait(); //wait for user input
        if (!result.isPresent()) return;

        String type = result.get();

        Dialog<Product> dialog = new Dialog<>(); //create a form dialog that chamge depending on the product type
        dialog.setTitle("Add " + type);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        TextField name = new TextField();
        TextField itemNumber = new TextField();
        TextField qty = new TextField();
        TextField price = new TextField();

        grid.add(new Label("Name:"), 0, 0); grid.add(name, 1, 0);
        grid.add(new Label("Item Number:"), 0, 1); grid.add(itemNumber, 1, 1);
        grid.add(new Label("Quantity:"), 0, 2); grid.add(qty, 1, 2);
        grid.add(new Label("Price:"), 0, 3); grid.add(price, 1, 3);

        int row = 4;
        TextField f1 = new TextField();
        TextField f2 = new TextField();
        TextField f3 = new TextField();

        switch (type) { //display different form based on the item type 
            case "Refrigerator":
                grid.add(new Label("Door Design:"), 0, row); grid.add(f1, 1, row++);
                grid.add(new Label("Color:"), 0, row); grid.add(f2, 1, row++);
                grid.add(new Label("Capacity (L):"), 0, row); grid.add(f3, 1, row);
                break;
            case "TV":
                grid.add(new Label("Screen Type:"), 0, row); grid.add(f1, 1, row++);
                grid.add(new Label("Resolution:"), 0, row); grid.add(f2, 1, row++);
                grid.add(new Label("Display Size (inches):"), 0, row); grid.add(f3, 1, row);
                break;
            case "AirConditioner":
                grid.add(new Label("AC Type:"), 0, row); grid.add(f1, 1, row++);
                grid.add(new Label("Energy Rating:"), 0, row); grid.add(f2, 1, row++);
                grid.add(new Label("Cooling Capacity (kW):"), 0, row); grid.add(f3, 1, row);
                break;
        }

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(button -> { //create and return Product object based on input field when user clicks ok
            if (button == ButtonType.OK) {
                try {
                    int q = Integer.parseInt(qty.getText());
                    double p = Double.parseDouble(price.getText());
                    switch (type) {
                        case "Refrigerator":
                            return new Refrigerator(itemNumber.getText(), name.getText(), q, p, f1.getText(), f2.getText(), Integer.parseInt(f3.getText()));
                        case "TV":
                            return new TV(itemNumber.getText(), name.getText(), q, p, f1.getText(), f2.getText(), Double.parseDouble(f3.getText()));
                        case "AirConditioner":
                            return new AirConditioner(itemNumber.getText(), name.getText(), q, p, f1.getText(), f2.getText(), Double.parseDouble(f3.getText()));
                    }
                } catch (Exception e) {
                    showAlert("Invalid Input", "Please ensure all fields are valid.");
                }
            }
            return null;
        });

        Optional<Product> productResult = dialog.showAndWait();
        productResult.ifPresent(products::add);
    }

    private void viewProduct() {
        Product selected = table.getSelectionModel().getSelectedItem(); //get the currently selected product in table
        if (selected == null) {
            showAlert("Selection Required", "Please select a product to view.");
            return;
        }
        showAlert("Product Info", selected.toString()); //Displays the product's details
    }

    private void updateStock(boolean isAdding) { //STOCK operations
        Product selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Selection Required", "Please select a product.");
            return;
        }

        TextInputDialog qtyDialog = new TextInputDialog(); //prompt user to enter the quantity
        qtyDialog.setTitle(isAdding ? "Add Stock" : "Deduct Stock");
        qtyDialog.setHeaderText("Enter quantity:");
        Optional<String> result = qtyDialog.showAndWait(); // wait for user input
        try {
            int amount = Integer.parseInt(result.get()); //get the integer value
            if (amount < 0) throw new NumberFormatException(); //exception to prevent negative value
            if (!isAdding && amount > selected.getQuantity()) { 
                showAlert("Error", "Insufficient stock."); 
                return;
            }
            if (isAdding) selected.addStock(amount); //adds or deducts stock from the selected product
            else selected.deductStock(amount);
            table.refresh(); //refresh the amount of product
        } catch (Exception e) {
            showAlert("Invalid Input", "Please enter a valid integer.");
        }
    }

    private void toggleStatus() {
        Product selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Selection Required", "Please select a product.");
            return;
        }
        selected.setStatus(!selected.isActive()); //changes the product's status from active to discontinued or vice versa
        showAlert("Status Toggled", "Product is now " + (selected.isActive() ? "Active" : "Discontinued"));
    }

    private void showAlert(String title, String content) { //show msg popups with title and message body
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private String generateUserID(String name) {
        String[] parts = name.trim().split(" "); //remove trailing space
        return (parts.length >= 2) ? parts[0].charAt(0) + parts[parts.length - 1] : "guest"; 
        //ternary operator, if 2 words, first letter of word1 + word2, else guest
    }
}