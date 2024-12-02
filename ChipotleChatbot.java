//Muhriz Munir and Kagan Feng
//APCSA Period 5

import java.util.Scanner;
public class ChipotleChatbot {
    //Color codes for colored text
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String ORANGE = "\033[38;5;214m";
    
   // Method to get a valid input from the user based on given options
   private static String getValidInput(Scanner scanner, String prompt, String[] validChoices) {
       System.out.println(prompt);
       String choice = scanner.nextLine().toLowerCase().trim();


       // Check for exit at any point
       if (choice.equals("exit")) {
           System.out.println(RED+"G"+RESET +GREEN+ "o" +BLUE+ "o"+YELLOW+"o"+ORANGE+"d"+CYAN+"b"+MAGENTA+"y"+RED+"e"+BLUE+"! "+YELLOW+"E"+CYAN+"n"+GREEN+"j"+BLUE+"o"+ORANGE+"y"+MAGENTA+" y"+RED+"o"+YELLOW+"u"+ORANGE+"r" +BLUE+" C"+GREEN+"h"+CYAN+"i"+RED+"p"+GREEN+"o"+BLUE+"t"+MAGENTA+"l"+CYAN+"e"+BLUE+"!"+RESET);
           return "exit";  // Exit the program
       }


       // Random response messages for invalid input
       String[] invalidResponses = {
           MAGENTA + "Oops! That doesn't seem right. Try again!",
           MAGENTA + "Hmm... I didn't quite catch that. Please choose from the options."+ RESET,
           MAGENTA + "Sorry, I didn't understand that. Please pick a valid option."+ RESET,
           MAGENTA + "Oops! It looks like that option isn't available. Please try again."+ RESET,
           MAGENTA + "That doesn't seem to be an option. Let's try that again."+ RESET,
           MAGENTA + "I didn't get that. Pick one of the available options."+ RESET,
           MAGENTA + "I didn't quite understand. Choose again from the valid options." + RESET
       };


       while (true) {
           boolean valid = false;
           for (String validChoice : validChoices) {
               if (choice.equals(validChoice)) {
                   valid = true;
                   break;
               }
           }
           if (valid) {
               return choice;
           } else {
               // Generate a random number to select a random invalid response
               int number = (int) (Math.random() * invalidResponses.length);
               System.out.println(invalidResponses[number]);  // Display the random invalid response
               System.out.print("Please choose from the valid options: ");
               choice = scanner.nextLine().toLowerCase().trim();


               // Check for exit again
               if (choice.equals("exit")) {
                   System.out.println(RED+"G" +RESET +GREEN+ "o" +BLUE+ "o"+YELLOW+"o"+ORANGE+"d"+CYAN+"b"+MAGENTA+"y"+RED+"e"+BLUE+"! "+YELLOW+"E"+CYAN+"n"+GREEN+"j"+BLUE+"o"+ORANGE+"y"+MAGENTA+" y"+RED+"o"+YELLOW+"u"+ORANGE+"r" +BLUE+" C"+GREEN+"h"+CYAN+"i"+RED+"p"+GREEN+"o"+BLUE+"t"+MAGENTA+"l"+CYAN+"e"+BLUE+"!"+RESET);
                   System.exit(0);  // Exit the program
               }
           }
       }
   }


   // Method to build a burrito
   private static void buildBurrito(Scanner scanner) {
       System.out.println("\nLet's make your burrito! Here are the options. Type the number corresponding to your selection:");


       // Ask for the type of meat (with numbered options)
       String meatChoice = getValidInput(scanner,
           CYAN + "Choose your meat:\n1. Smoked Brisket\n2. Chicken\n3. Steak\n4. Beef Barbacoa\n5. Carnitas\n6. Sofritas\n7. Veggie" + RESET,
           new String[] { "1", "2", "3", "4", "5", "6", "7" });


       // Ask for rice choice (with numbered options)
       String riceChoice = getValidInput(scanner,
           CYAN + "Choose your rice:\n1. White Rice\n2. Brown Rice\n3. None" + RESET,
           new String[] { "1", "2", "3" });


       // Ask for beans choice (with numbered options)
       String beansChoice = getValidInput(scanner,
           CYAN + "Choose your beans:\n1. Black Beans\n2. Pinto Beans\n3. None" + RESET,
           new String[] { "1", "2", "3" });


       // Map meat choice to actual name
       String meat = getMeatName(meatChoice);


       // Map rice choice to actual name
       String rice = getRiceName(riceChoice);


       // Map beans choice to actual name
       String beans = getBeansName(beansChoice);


       // Ask for toppings (user can select multiple toppings)
       System.out.println(CYAN + "Choose your toppings. You can choose multiple toppings by entering the corresponding numbers, separated by commas.");
       System.out.println(CYAN + "1. Guacamole ($2.95)");
       System.out.println(CYAN + "2. Fresh Tomato Salsa (Free)");
       System.out.println(CYAN + "3. Roasted Chili-Corn Salsa (Free)");
       System.out.println(CYAN + "4. Tomatillo-Green Chili Salsa (Free)");
       System.out.println(CYAN + "5. Tomatillo-Red Chili Salsa (Free)");
       System.out.println(CYAN + "6. Sour Cream (Free)");
       System.out.println(CYAN + "7. Fajita Veggies (Free)");
       System.out.println(CYAN + "8. Cheese (Free)");
       System.out.println(CYAN + "9. Romaine Lettuce (Free)");
       System.out.println(CYAN + "10. Queso Blanco ($1.75)" + RESET);


       String toppingInput = scanner.nextLine().toLowerCase().trim();


       // Check for exit during toppings selection
       if (toppingInput.equals("exit")) {
           System.out.println(RED+"Goodbye! Enjoy your Chipotle!");
           System.exit(0);  // Exit the program
       }


       // Parse the topping choices
       String[] toppingChoices = toppingInput.split(",");
       boolean hasGuacamole = false, hasFreshTomatoSalsa = false, hasRoastedChiliCornSalsa = false,
               hasTomatilloGreenChiliSalsa = false, hasTomatilloRedChiliSalsa = false, hasSourCream = false,
               hasFajitaVeggies = false, hasCheese = false, hasLettuce = false, hasQuesoBlanco = false;


       for (String topping : toppingChoices) {
           switch (topping.trim()) {
               case "1": hasGuacamole = true; break;
               case "2": hasFreshTomatoSalsa = true; break;
               case "3": hasRoastedChiliCornSalsa = true; break;
               case "4": hasTomatilloGreenChiliSalsa = true; break;
               case "5": hasTomatilloRedChiliSalsa = true; break;
               case "6": hasSourCream = true; break;
               case "7": hasFajitaVeggies = true; break;
               case "8": hasCheese = true; break;
               case "9": hasLettuce = true; break;
               case "10": hasQuesoBlanco = true; break;
           }
       }


       // Create the burrito object
       Food burrito = new Food(meat, rice, beans, hasGuacamole, hasFreshTomatoSalsa, hasRoastedChiliCornSalsa,
                               hasTomatilloGreenChiliSalsa, hasTomatilloRedChiliSalsa, hasSourCream, hasFajitaVeggies,
                               hasCheese, hasLettuce, hasQuesoBlanco);


       // Display burrito summary
       burrito.displayBurritoSummary();
   }


   // Helper methods to map choice numbers to actual names
   private static String getMeatName(String choice) {
       switch (choice) {
           case "1": return "Smoked Brisket";
           case "2": return "Chicken";
           case "3": return "Steak";
           case "4": return "Beef Barbacoa";
           case "5": return "Carnitas";
           case "6": return "Sofritas";
           case "7": return "Veggie";
           default: return "Unknown";
       }
   }


   private static String getRiceName(String choice) {
       switch (choice) {
           case "1": return "White Rice";
           case "2": return "Brown Rice";
           case "3": return "None";
           default: return "Unknown";
       }
   }


   private static String getBeansName(String choice) {
       switch (choice) {
           case "1": return "Black Beans";
           case "2": return "Pinto Beans";
           case "3": return "None";
           default: return "Unknown";
       }
   }


   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       // Greet user and provide initial instructions
       System.out.println(RED + "Welcome to the Chipotle Chatbot!" + RESET);
       System.out.println(BLUE + "I can help you build a burrito. Type" + RESET + GREEN + " 'burrito' " + RESET+ BLUE + "to make a burrito or type "+ GREEN + "'exit'" +RESET+" to leave." + RESET);


       // Main loop
       while (true) {
           System.out.print("You: ");
           String input = scanner.nextLine().toLowerCase().trim();


           // If the user wants to exit
           if (input.equals("exit")) {
               System.out.println(RED + "Goodbye! Enjoy your Chipotle!");
               break;
           }


           // If the user wants to build a burrito
           else if (input.equals("burrito")) {
               buildBurrito(scanner);
           }


           // Invalid input
           else {
               System.out.println("Sorry, I can only help you build a burrito or let you exit. Type 'burrito' to make a burrito or 'exit' to leave.");
           }
       }


       scanner.close();
   }
}