public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

//    constructor

    /**
     * @param name The name of the movie
     * @param format The format of the movie (DVD or Blu-ray)
     * @param rating The rating of the movie
     */
    public Movie(String name, String format, double rating) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot null/blank");
        }
        if(!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blu-ray"))) {
            throw new IllegalArgumentException("Movie must be a DVD or Blu-ray");
        }
        if(rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating cannot be less than zero or greater than ten");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.sellingPrice = format.equalsIgnoreCase("Blu-ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("Blu-ray") ? 1.99 : 0.99;
    }

//    copy constructor

    /**
     * @param film an object of the Movie class
     */
    public Movie(Movie film) {
        this.name = film.name;
        this.format = film.format;
        this.rating = film.rating;
        this.sellingPrice = film.sellingPrice;
        this.rentalPrice = film.rentalPrice;
        this.isAvailable = film.isAvailable;
    }

//    getters and setters

    /**
     * @return The name of the movie
     */
    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Format cannot be null/blank");
        }
        if (!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blu-ray"))) {
            throw new IllegalArgumentException("Invalid format input");
        }
        setSellingPrice(format.equalsIgnoreCase("Blu-ray") ? 4.25 : 2.25);
        setRentalPrice(format.equals("Blu-ray") ? 1.99 : 0.99);
        this.format = format;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating cannot be less than 0 or greater than 10");
        }
        this.rating = rating;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String toString() {
        return "\t Movie: " + this.name + '\n' +
               "\t Format: " + this.format + '\n' +
               "\t Rating: " + this.rating + '\n' +
               "\t SellingPrice: " + this.sellingPrice + '\n' +
               "\t RentalPrice: " + this.rentalPrice + '\n' +
               "\t Availability: " + (this.isAvailable ? "in-stock" : "rented") + '\n';
    }

    public static void main(String[] args) {
        System.out.println("\n********************BOB'S VIDEO STORE********************\n");
        Movie movie = new Movie("The Shawshank Redemption","Blu-ray",9.2);
        System.out.println(movie);
    }
}
