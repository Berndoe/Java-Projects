import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void loadItems(String filename) throws FileNotFoundException {
        FileInputStream file = new FileInputStream(filename);
        Scanner scan = new Scanner(file);

// nested loop that helps load the data in a file to the store array
        for (int i = 0; scan.hasNextLine(); i++) {
            String[] fileLines = scan.nextLine().split(";");

            for (int j = 0; j < fileLines.length; j++) {
                String[] fields = fileLines[j].split("=");
                store.setItem(i, j, new Item(fields[0], Double.parseDouble(fields[1])));
            }
        }
        scan.close();
    }

    public static void manageItems() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Java Grocers. What would you like to do?");

        while (true) {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);

            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String options = userInput.nextLine(); // why is this preventing the use of b

            switch (options) {
                case "a" -> {
                    System.out.print("Choose aisle number between 1 -7: ");
                    int aisle = userInput.hasNextInt() ? userInput.nextInt() - 1: 404; // checks whether the input is an integer
                    userInput.nextLine();

                    System.out.print("Choose item number between 1-3: ");
                    int itemNumber = userInput.hasNextInt() ? userInput.nextInt() - 1: 404;
                    userInput.nextLine();

                    if (aisle == 404 || itemNumber == 404) {
                        System.out.println("Invalid Input. Please try again");
                        continue;
                    }
                    else if (aisle < 0 || aisle > 6 || itemNumber < 0 || itemNumber > 2) {
                        System.out.println("Invalid Input. Please try again");
                        continue;
                    }

                    Item item = new Item(store.getItem(aisle, itemNumber));
                    if (cart.addItem(item)) {
                        System.out.println(item.getName() + " was added to your shopping cart.");
                    }
                    else {
                        System.out.println(item.getName() + " is already in your shopping cart.");
                    }
                }
                case "b" -> {
                    if (cart.isEmpty()) continue;
                    System.out.print("Choose the item you want to remove: ");
                    cart.removeItem(userInput.nextLine());
                }
                case "c" -> {
                    if (cart.isEmpty()) continue;
                    System.out.println(cart.checkOut());
                    userInput.close();
                    System.exit(0);
                }
            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("Enter anything to continue: ");
            userInput.nextLine();

        }
    }
        public static void main (String[]args){
            try {
                loadItems("products.txt");
                manageItems();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }



        }
}

