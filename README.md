**Stock Management System (SMS)**

A Java-based application for managing inventory of electronic appliances. This project includes both a command-line interface (CLI) and a Graphical User Interface (GUI) built with JavaFX to handle product tracking, stock updates, and status management.


**📋 Features**

User Identification: Captures user name and auto-generates a User ID based on the input.

Product Flexibility: Supports different types of products using inheritance:

Refrigerators (with Door Design, Color, Capacity)

TVs (with Screen Type, Resolution, Display Size)

Air Conditioners (with AC Type, Energy Rating, Cooling Capacity)

Stock Operations:

Add new products to the inventory.

View product details and calculate inventory value.

Add stock (increase quantity).

Deduct stock (decrease quantity with validation).

Status Management: Helper functions to discontinue products or reactivate them.

Dual Interfaces:

Console Version: Text-based menu flow.

GUI Version: JavaFX table view with interactive buttons and dialogs.


**📂 Project Structure**
The project consists of the following Java source files:

Base & Model Classes

Product.java: The abstract base class defining common attributes (Item Number, Name, Quantity, Price, Status).

Refrigerator.java: Subclass of Product with specific attributes like door design and capacity.

TV.java: Subclass of Product with attributes like screen type and resolution.

AirConditioner.java: Subclass of Product with attributes like energy rating and cooling capacity.

UserInfo.java: Handles user input and logic for generating the User ID (First initial + Last name).

Application Logic

StockManagement.java: The main class for the Console implementation. Contains the logic for the menu-driven text interface.

StockManagementGUI.java: The main class for the JavaFX implementation. Provides a windowed interface with tables and pop-ups.


🚀 How to Run
Prerequisites

Java Development Kit (JDK) 8 or higher.

(For GUI) JavaFX SDK if using JDK 11 or higher (as it is no longer bundled with the JDK).

Option 1: Running the Console Application

Compile the files:
<BASH>
javac StockManagement.java Product.java Refrigerator.java TV.java AirConditioner.java UserInfo.java

Run the main class:
<BASH>
java StockManagement

Option 2: Running the GUI Application

Ensure JavaFX is configured in your library path.

Compile the files:

<BASH>
javac --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml StockManagementGUI.java Product.java Refrigerator.java TV.java AirConditioner.java
  
Run the GUI:
  
<BASH>
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml StockManagementGUI


**👥 Group Members**

Chuan Ning Le

Ooh Rui Hang

Oon Xiang Yu

Wilson Fook Wei Sheng


**🛠 Usage Guide**

**Console Mode**

Enter your full name when prompted.

Choose 'Y' to start adding products.

Specify the number of products you wish to enter.

Select the type of product (1. Refrigerator, 2. TV, 3. AC) and fill in the details.

Use the menu to View, Add Stock, Deduct Stock, or exit.


**GUI Mode**

Enter your name in the popup dialog.

Use the Add Product button to create new inventory items via a form.

Select a row in the table and click Add Stock or Deduct Stock to modify quantities.

Click View Details to see specific technical specifications of the selected appliance.

Use Discontinue/Reactivate to toggle the product status
