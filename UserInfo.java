

import java.util.Scanner;

public class UserInfo {
    private String fullName;
    private String userID;

    public void getName(Scanner input) {
    	
        System.out.print("Enter your full name: ");
        fullName = input.nextLine();
        
    }
    
    public boolean checkName (String name) {
    	 if (fullName.contains(" ")) {
    		 return true;
    	 }
    	 
    	 else
    		 return false;
    }
    public void generateUserID() {
        if (checkName(fullName)) {
            String[] parts = fullName.split(" ");
            userID = parts[0].charAt(0) + parts[parts.length - 1];
        } 
        else {
            userID = "guest";
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserID() {
        return userID;
    }
}
