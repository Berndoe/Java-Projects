import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<>();
    }

    /**
     * @param index the position of the movie in the arraylist
     * @return the movie object at that position
     */
    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public Movie getMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                return new Movie(movie);
            }
        }
      return null;
    }

    /**
     * @param index the position of the movie in the arraylist
     * @param movie a movie object
     */
    public void setMovies(int index, Movie movie) {this.movies.set(index, new Movie(movie));
    }

    /**
     * @param movie a movie object
     */
    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    /**
     * @param name the name of the movie
     * @param action what you want to do with the movie
     */
    public void action(String name, String action) {
        if(!(action.equals("sell") || action.equals("rent") || action.equals("return"))) {
            throw new IllegalArgumentException("Action can only be sell, rent or return");
        }

        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank/null");
        }

        if(movies.isEmpty()) {
            throw new IllegalStateException("The store is out of stock");
        }
        for (int i = 0; i < this.movies.size(); i++) {
            if(movies.get(i).getName().equalsIgnoreCase(name)) {
                switch (action) {
                    case "sell" -> {
                        if (!(movies.get(i).isAvailable())) {
                            throw new IllegalStateException("We cannot buy a movie that has been rented");
                        }
                        this.movies.remove(i);
                    }
                    case "rent" -> this.movies.get(i).setAvailable(false);
                    case "return" -> this.movies.get(i).setAvailable(true);
                }
            }
        }
    }

    /**
     * @return a string showing the details of the movie chosen
     */
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Movie movie : this.movies) {
            temp.append(movie.toString());
            temp.append("\n\n");
        }
        return temp.toString();
    }
}
