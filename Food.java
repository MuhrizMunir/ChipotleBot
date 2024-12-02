public class Food {
    //Color
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\033[38;5;214m";
    // Properties of the Food (burrito) object
    String meat;
    String rice;
    String beans;
    boolean hasGuacamole;
    boolean hasFreshTomatoSalsa;
    boolean hasRoastedChiliCornSalsa;
    boolean hasTomatilloGreenChiliSalsa;
    boolean hasTomatilloRedChiliSalsa;
    boolean hasSourCream;
    boolean hasFajitaVeggies;
    boolean hasCheese;
    boolean hasLettuce;
    boolean hasQuesoBlanco;
    double price;
    int calories;

    // Custom object to hold price and calories
    public static class BurritoDetails {
        double price;
        int calories;
        
        BurritoDetails(double price, int calories) {
            this.price = price;
            this.calories = calories;
        }
    }

    // Constructor to initialize the Food object
    public Food(String meat, String rice, String beans, boolean hasGuacamole, boolean hasFreshTomatoSalsa, 
                boolean hasRoastedChiliCornSalsa, boolean hasTomatilloGreenChiliSalsa, 
                boolean hasTomatilloRedChiliSalsa, boolean hasSourCream, boolean hasFajitaVeggies, 
                boolean hasCheese, boolean hasLettuce, boolean hasQuesoBlanco) {
        this.meat = meat;
        this.rice = rice;
        this.beans = beans;
        this.hasGuacamole = hasGuacamole;
        this.hasFreshTomatoSalsa = hasFreshTomatoSalsa;
        this.hasRoastedChiliCornSalsa = hasRoastedChiliCornSalsa;
        this.hasTomatilloGreenChiliSalsa = hasTomatilloGreenChiliSalsa;
        this.hasTomatilloRedChiliSalsa = hasTomatilloRedChiliSalsa;
        this.hasSourCream = hasSourCream;
        this.hasFajitaVeggies = hasFajitaVeggies;
        this.hasCheese = hasCheese;
        this.hasLettuce = hasLettuce;
        this.hasQuesoBlanco = hasQuesoBlanco;
        BurritoDetails details = calculatePrice(); // Calculate price and calories when the object is created
        this.price = details.price;
        this.calories = details.calories;
    }

    // Method to calculate the total price and calories of the burrito based on selected ingredients
    private BurritoDetails calculatePrice() {
        double totalPrice = 8.50; // base burrito price
        int totalCalories = 0;

        // Adjust price based on the meat choice
        switch (meat) {
            case "Smoked Brisket":
                totalPrice += 14.45;
                totalCalories += 360;
                break;
            case "Steak":
                totalPrice += 12.35;
                totalCalories += 150;
                break;
            case "Beef Barbacoa":
                totalPrice += 12.35;
                totalCalories += 170;
                break;
            case "Sofritas":
                totalPrice += 10.60;
                totalCalories += 150;
                break;
            case "Chicken":
                totalPrice += 10.60;
                totalCalories += 180;
                break;
            case "Carnitas":
                totalPrice += 11.25;
                totalCalories += 210;
                break;
            case "Veggie":
                totalPrice += 10.60;
                totalCalories += 0;
                break;
            default:
                break;
        }

        // Adjust price for rice
        if (rice.equals("White Rice") || rice.equals("Brown Rice")) {
            totalPrice += 0.50;  // Add charge for rice
            totalCalories += 210;
        }

        // Adjust price for beans
        if (beans.equals("Black Beans") || beans.equals("Pinto Beans")) {
            totalPrice += 0.50;  // Add charge for beans
            totalCalories += 130;
        }

        // Add charges for paid toppings
        if (hasGuacamole) {
            totalPrice += 2.95;  
        }
        if (hasQuesoBlanco) {
            totalPrice += 1.75;  
        }
        if (hasFreshTomatoSalsa){
            totalCalories += 0.50;
        }

        // Return the new BurritoDetails object containing both price and calories
        return new BurritoDetails(totalPrice, totalCalories);
    }

    // Method to display a summary of the burrito choices
    public void displayBurritoSummary() {
        System.out.println(YELLOW + "\nYour burrito is ready! Here are what you made:" + RESET);
        System.out.println(YELLOW + "Meat: " + capitalize(meat) + RESET);
        System.out.println(YELLOW +"Rice: " + capitalize(rice)+ RESET);

        // Display each topping based on whether the user selected it
        if (hasGuacamole) System.out.println(YELLOW + "Guacamole: ($2.95)"+ RESET);
        if (hasFreshTomatoSalsa) System.out.println(YELLOW + "Fresh Tomato Salsa: (Free)"+ RESET);
        if (hasRoastedChiliCornSalsa) System.out.println(YELLOW + "Roasted Chili-Corn Salsa: (Free)"+ RESET);
        if (hasTomatilloGreenChiliSalsa) System.out.println(YELLOW + "Tomatillo-Green Chili Salsa: (Free)"+ RESET);
        if (hasTomatilloRedChiliSalsa) System.out.println(YELLOW + "Tomatillo-Red Chili Salsa: (Free)"+ RESET);
        if (hasSourCream) System.out.println(YELLOW + "Sour Cream: (Free)"+ RESET);
        if (hasFajitaVeggies) System.out.println(YELLOW + "Fajita Veggies: (Free)"+ RESET);
        if (hasCheese) System.out.println(YELLOW + "Cheese: (Free)"+ RESET);
        if (hasLettuce) System.out.println(YELLOW + "Romaine Lettuce: (Free)"+ RESET);
        if (hasQuesoBlanco) System.out.println(YELLOW + "Queso Blanco: ($1.75)" + RESET);

        // Display the total price and calories of the burrito
        System.out.println(ORANGE + "\nTotal price: $" + price + RESET);
        System.out.println(ORANGE +"Total calories: " + calories + "\n Type 'exit' to go out and enjoy your Chipotle!" + RESET);
    }

    // Helper method to capitalize the first letter of each word
    private String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.split(" ");
        StringBuilder capitalizedString = new StringBuilder();
        for (String word : words) {
            capitalizedString.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        return capitalizedString.toString().trim();
    }}

