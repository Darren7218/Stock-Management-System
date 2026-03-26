# 📦 Stock-Management-System

![Java](https://img.shields.io/badge/Language-Java-ED8B00?style=flat-square&logo=openjdk)
![JavaFX](https://img.shields.io/badge/Framework-JavaFX-1572B6?style=flat-square)
![Status](https://img.shields.io/badge/Status-Completed-success?style=flat-square)
![Course](https://img.shields.io/badge/Course-Object_Oriented_Programming-blue?style=flat-square)

**Object-Oriented Programming Group Assignment** A robust Java-based application designed for managing an inventory of electronic appliances. This project showcases strong OOP principles (Inheritance, Polymorphism, Encapsulation) and provides both a Command-Line Interface (CLI) and a Graphical User Interface (GUI) built with JavaFX.

---

## ✨ Features

* **👤 User Identification:** Automatically generates a unique User ID based on the user's input name (First initial + Last name).
* **🔌 Polymorphic Product Handling:** Supports multiple product categories utilizing class inheritance:
  * **Refrigerators:** Tracks Door Design, Color, and Capacity.
  * **TVs:** Tracks Screen Type, Resolution, and Display Size.
  * **Air Conditioners:** Tracks AC Type, Energy Rating, and Cooling Capacity.
* **📦 Comprehensive Stock Operations:**
  * Register new products into the inventory.
  * Add or deduct stock quantities (with active validation).
  * Calculate overall inventory valuation.
* **⚙️ Status Management:** Includes functionalities to discontinue outdated products or reactivate returning ones.
* **🖥️ Dual Interfaces:** Choose between a lightweight, menu-driven Console Version or a fully interactive JavaFX GUI featuring table views, pop-ups, and dialog boxes.

---

## 📂 Project Structure

### 🧱 Base & Model Classes
* `Product.java`: The abstract base class defining common attributes (Item Number, Name, Quantity, Price, Status).
* `Refrigerator.java`, `TV.java`, `AirConditioner.java`: Subclasses extending `Product` with category-specific attributes.
* `UserInfo.java`: Handles user session logic and User ID generation.

### ⚙️ Application Logic
* `StockManagement.java`: The main execution class for the **Console (CLI)** implementation.
* `StockManagementGUI.java`: The main execution class for the **JavaFX (GUI)** implementation.

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher.
* *For GUI:* JavaFX SDK (required if using JDK 11 or higher, as it is no longer bundled with the standard JDK).

### Option 1: Running the Console Application
1. **Compile the files:**
   ```bash
   javac StockManagement.java Product.java Refrigerator.java TV.java AirConditioner.java UserInfo.java
2. **Run the application:**
   ```bash
   java StockManagement

### Option 2: Running the GUI Application
1. **Ensure JavaFX is configured in your library path.**

2. **Compile the files:**
   ```bash
   javac --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml StockManagementGUI.java Product.java Refrigerator.java TV.java AirConditioner.java

3. **Run the application:**
   ```bash
   java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml StockManagementGUI

## 🛠️ Usage Guide
**Console Mode:**

1. Enter your full name when prompted.

2. Follow the on-screen prompts (Y/N) to begin adding products.

3. Select the appliance type (1. Refrigerator, 2. TV, 3. AC) and fill in the required specifications.

4. Use the numeric menu to View, Add Stock, Deduct Stock, or Exit.

**GUI Mode:**

1. Enter your name in the initial popup dialog.

2. Use the Add Product button to register new inventory items via the input form.

3. Select any row in the main table to enable context actions: Add Stock, Deduct Stock, or View Details.

4. Use the Discontinue / Reactivate toggles to manage the product lifecycle status.


## 👥 Group Members
Universiti Tunku Abdul Rahman (UTAR) - Computer Science

* Chuan Ning Le

* Ooh Rui Hang

* Oon Xiang Yu

* Wilson Fook Wei Sheng
