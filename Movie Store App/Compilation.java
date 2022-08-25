import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Compilation {
    static Store movieStore = new Store();

    public static void main(String[] args) throws IOException {
        System.out.println("\n********************BOB'S VIDEO STORE********************\n");
        try{
            loadMovies("movies.txt");
            System.out.println(movieStore);
            System.out.println("MOVIES LOADED\n\n");
            manageMovies();

        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Process Complete");
        }
    }
    /**
     * @param filename the name of the file
     * @throws FileNotFoundException signals that the file has not been found
     */
    public static void loadMovies(String filename) throws FileNotFoundException {
        FileInputStream file = new FileInputStream(filename);
        Scanner fileScanner = new Scanner(file);
        while(fileScanner.hasNextLine()) {
            String[] fileLines = fileScanner.nextLine().split("--");
            movieStore.addMovie(new Movie(fileLines[0], fileLines[1],Double.parseDouble(fileLines[2])));
        }
        fileScanner.close();
    }
    public static void manageMovies() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Would you like to \n\ta) purchase\n\tb) rent \n\tc) return");
            String input = scanner.nextLine();

            if(!(input.equalsIgnoreCase("a") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("c"))) {
                scanner.close();
                break;
            }

            System.out.print("Enter movie name: ");
            String movieName = scanner.nextLine();

            if(movieStore.getMovie(movieName) == null) {
                System.out.println("\n\nInvalid Input. Please try again.\n");
                continue;
            }
            switch (input) {
                case "a" -> {
                    if(!movieStore.getMovie(movieName).isAvailable()){
                        System.out.println("The movie is not available for purchase. Please try again.\n");
                        continue;
                    }
                    movieStore.action(movieName, "sell");
                }
                case "b" -> movieStore.action(movieName, "rent");
                case "c" -> movieStore.action(movieName, "return");
            }
            System.out.println("\n\nUPDATED MOVIES\n\n" + movieStore);
        }
        scanner.close();
    }
}
