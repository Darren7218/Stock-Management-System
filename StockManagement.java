

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StockManagement {
    
 

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
        System.out.println("Welcome to the Stock Management System (SMS)");
        System.out.println("Current Date & Time: " + new Date());
        System.out.println("Group Members: \nChuan Ning Le \nOoh Rui Hang \nOon Xiang Yu \nWilson Fook Wei Sheng");

        UserInfo user = new UserInfo();
        user.getName(input);
        user.generateUserID();
        
        while(true) {
    		
    		System.out.print("Do you want to add products? (Y/N):");
        	String yn = input.next();
        	input.nextLine();
        	if(yn.equalsIgnoreCase("Y")) {
        		int num = getMaximumNumberOfProduct(input);
        		Product[] products = new Product[num];
        		for(int i = 0; i < num;i++) {
        			addProduct(products,input);
        		}
        		
        		int menuChoice;
        		do {
        			
        			menuChoice = displayMenu(input);
                    executeAppropriateMethod(menuChoice, products, input);
                    
        		}while(menuChoice!=0);
        		System.out.println("Exiting ...");
        		input.close();
    			System.out.println("Username: " + user.getFullName());
    			System.out.println("User ID: " + user.getUserID());
    			System.exit(0);
        		
        	}
        	
        	else if (yn.equalsIgnoreCase("N")) {
        		int ex = -1;
        		do {
        			try {
        				System.out.print("Enter a zero value to exit the program:");
        				ex= input.nextInt();
        				input.nextLine();
                		if(ex == 0) {
                			System.out.println("Exiting ...");
                			input.close();
                			System.out.println("Username: " + user.getFullName());
                			System.out.println("User ID: " + user.getUserID());
                			System.exit(0);
                   	 	
                		} 
        			}
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                        input.nextLine(); // Clear the invalid input
                    }
            		
            		
        		}while(ex != 0);
        		
        	}
        	
        	else {
        		System.out.println("Please enter Y or N only");
        	}
        	
        	
    	}
        
        
    }

    public static int getMaximumNumberOfProduct(Scanner input) {
    	 int value = -1;
         while (true) {
             try {
            	 
            	 
                 System.out.print("How many number of product that you want to add?:");
                 value = input.nextInt();
                 input.nextLine();
                 if (value < 0) {
                     System.out.println("Value must not be negative. Please enter a positive integer.");
                 } else {
                     return value;
                 }
             } 
             catch (InputMismatchException e) {
                 System.out.println("Invalid input. Please enter an integer.");
                 input.nextLine(); // Clear the invalid input
             }
         }
    	
    }
    
    public static int displayProductsAndSelectForUpdate(Product[] products, Scanner input) {
    	for (int i = 0; i< products.length ;i++) {
    		System.out.println("\n" + "Index value:" + i + " Name:" + products[i].getProductName());
    	}
    	while(true) {
    		try {
        		
            	System.out.print("\nSelect the index value of a product:");
            	int choice = input.nextInt();
            	input.nextLine();
            	if(choice >=0 && choice < products.length) {
            		return choice;
            	}
            	else {
            		System.out.println("The index value must be exist. Please enter a valid index value.");
            	}
        	}
        		
        	catch(InputMismatchException e) {
        		System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the invalid input
        	}
    	}
    	
        
    }
    
    public static int displayMenu(Scanner input) {
    	int value = -1;
        while (true) {
            try {
           	 
           	 	
                System.out.print("\nMenu:\n1. View products\n2. Add stock\n3. Deduct stock\n4. Discontinue product\n0. Exit\nPlease enter a menu option: ");
                value = input.nextInt();
                input.nextLine();
                if (value < 0 || value > 4) {
                    System.out.println("The option should be between 0 and 4 only. Please enter a valid option number.");
                } 
                else {
                    return value;
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the invalid input
            }
        }
        
    }
    
    public static void addStock(Product[] products) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("\nSelecting product for adding stock:");
    	int choice = displayProductsAndSelectForUpdate(products,input);
       
    	int value = -1;
        while (true) {
            try {
           	 
           	 	
                System.out.print("Quantity of product being added:");
                value = input.nextInt();
                input.nextLine();
              
                if (value < 0 ) {
                    System.out.println("The quantity of product being added should be a positive integer.");
                } 
                else {
                    products[choice].addStock(value);
                    break;
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the invalid input
            }
        }  
    }
    
    public static void deductStock(Product[] products) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("\nSelecting product for deducting stock:");
    	int choice = displayProductsAndSelectForUpdate(products,input);
       
    	int value = -1;
        while (true) {
            try {
           	 
           	 	
                System.out.print("Quantity of product being deducted:");
                value = input.nextInt();
                input.nextLine();
               
                if (value < 0 || value > products[choice].getQuantity()) {
                    System.out.println("The quantity of product being deducted should be equal or greater than 0" + "\nand cannot be greater than the current quantity of stock for that product.");
                } 
                else {
                    products[choice].deductStock(value);
                    break;
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the invalid input
            }
        }  
    }
    
    
    private static void setProductStatus(Product[] products, Scanner input) {
    	String yn;
    	System.out.println("\nSelecting product for setting status(Active/Discontinued):");
        int choice = displayProductsAndSelectForUpdate(products,input);
        
        if (products[choice].isActive()) {
        	while(true) {
        		
            	System.out.print("Do you want to discontinue this product? (Y/N) :");
            	yn = input.next();
            	
            	if(yn.equalsIgnoreCase("Y")) {
            		products[choice].setStatus(false);
            		break;
            	}
            	
            	else if (yn.equalsIgnoreCase("N")) {
            		break;
            	}
            	
            	else {
            		System.out.println("Please enter Y or N only");
            	}
        	}
        	
        }
        
        else {
        	
        	while(true) {
        		
        		System.out.print("This product is already discontinued. Do you want to set its status to active? (Y/N):");
            	yn = input.next();
            	
            	if(yn.equalsIgnoreCase("Y")) {
            		products[choice].setStatus(true);
            		break;
            	}
            	
            	else if (yn.equalsIgnoreCase("N")) {
            		break;
            	}
            	
            	else {
            		System.out.println("Please enter Y or N only");
            	}
        	}
        }
        
        
    }
    
    public static void executeAppropriateMethod(int menuChoice, Product[] products, Scanner input) {
    	switch (menuChoice) {
    		case 1: 
    			viewProducts(products);
    			break;
    		case 2:
    			addStock(products);
    			break;
    		case 3:
    			deductStock(products);
    			break;
    		case 4:
    			setProductStatus(products,input);
    			break;
    		case 0:
    			break;
    	}
    }
    
    public static void addProduct(Product[] products, Scanner input) {
        boolean valid = true;
        int value;
    	while(valid) {
    		try {
              	 
    			System.out.println("\nAdding one product:\n1. Refrigerator\n2. TV\n3. Air conditioner");
           	 
                System.out.print("Select the type of product that you want to add:");
                value = input.nextInt();
                input.nextLine();
             
                if (value < 1 || value > 3) {
                    System.out.println("Only number 1 or 2 or 3 allowed!");
                } 
                else if (value == 1){
                    addRefrigerator(products,input);
                    valid = false;
                }
                
                else if(value == 2) {
                	addTV(products,input);
                	valid = false;
                }
                
                else if (value == 3) {
                	addAirConditioner(products,input);
                	valid = false;
                }
                
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the invalid input
            }
    	}
       
    }

    

    public static void addRefrigerator(Product[] products, Scanner input) {
        
        
        System.out.print("Enter product name:");
        String name = input.nextLine();
        
        System.out.print("Enter door design:");
        String door = input.nextLine();
        
        System.out.print("Enter color:");
        String color = input.nextLine();
       
        int capacity = getValidInt("Enter capacity (Litres):",input);
        
        int quantity = getValidInt("Enter quantity available in stock:",input);
   
        double price = getValidDouble("Enter price:",input);
        
        System.out.print("Enter item number:");
        String itemNumber = input.nextLine();
        
        for(int i = 0; i < products.length; i++) {
        	if (products[i] == null) {
        		products[i] = new Refrigerator(itemNumber, name, quantity, price, door, color, capacity);
        		break;
        	}
        }
    }

    public static void addTV(Product[] products, Scanner input) {
    	
        System.out.print("Enter product name:");
        String name = input.nextLine();
       
        System.out.print("Enter screen type:");
        String screenType = input.nextLine();
        
        System.out.print("Enter resolution:");
        String resolution = input.nextLine();
        
        double displaySize = getValidDouble("Enter display size (inches):",input);
       
        int quantity = getValidInt("Enter quantity available in stock:",input);
       
        double price = getValidDouble("Enter price:",input);
        
        System.out.print("Enter item number:");
        String itemNumber = input.nextLine();
        
        for(int i = 0; i < products.length; i++) {
        	if (products[i] == null) {
        		products[i] = new TV(itemNumber, name, quantity, price, screenType, resolution, displaySize);
        		break;
        	}
        }
    }
    
    public static void addAirConditioner(Product[] products, Scanner input) {
    	
        System.out.print("Enter product name:");
        String name = input.nextLine();
       
        System.out.print("Enter air conditioner type:");
        String acType = input.nextLine();
       
        System.out.print("Enter energy rating:");
        String energyRating = input.nextLine();
       
        double coolingCapacity = getValidDouble("Enter cooling capacity (kW):",input);
        
        int quantity = getValidInt("Enter quantity available in stock:",input);
       
        double price = getValidDouble("Enter price:",input);
        
        System.out.print("Enter item number:");
        String itemNumber = input.nextLine();
        
        for(int i = 0; i < products.length; i++) {
        	if (products[i] == null) {
        		products[i] = new AirConditioner(itemNumber, name, quantity, price, acType, energyRating, coolingCapacity);
        		break;
        	}
        }
    }
    
    public static void viewProducts(Product[] products) {
    	System.out.println("\nViewing products:");
    	for (int i = 0; i< products.length ;i++) {
    		System.out.println("\nIndex value of product:" + i + "    Product Name:" + products[i].getProductName());
    	}
    	Scanner input = new Scanner(System.in);
    	while(true) {
    		try {
        		
            	System.out.print("\nSelect the index value of a product:");
            	int choice = input.nextInt();
            	input.nextLine();
            	
            	if(choice >=0 && choice <= products.length) {
            		System.out.println(products[choice].toString());
            		break;
            	}
            	else {
            		System.out.println("The index value must be exist.");
            	}
        	}
        		
        	catch(InputMismatchException e) {
        		System.out.println("Invalid input. Please enter an integer.");
                input.nextLine(); // Clear the invalid input
        	}
    	}
    }

    //additional method as tools
    private static int getValidInt(String prompt, Scanner input) {
        int value = -1;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(input.nextLine());
                if (value < 0) {
                    System.out.println("Value must not be negative.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static double getValidDouble(String prompt, Scanner input) {
        double value = -1;
        while (true) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(input.nextLine());
                if (value < 0) {
                    System.out.println("Value must not be negative.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

   
}