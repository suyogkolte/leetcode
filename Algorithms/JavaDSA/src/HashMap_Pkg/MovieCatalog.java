/*
Given a string array containing a list of movies with details like (#, Title, ReleaseYear, Genres)
implement getMovies(genre, startYear, endYear) which returns a list of movies matching the
criteria given in params
*/
package HashMap_Pkg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieCatalog {
    HashMap<String, List<Movie>> genreMap = new HashMap<>();

    class Movie{
        private int id;
        private String title;
        private int releaseYear;
        private List<String> genres;

        public int getId(){
            return id;
        };

        public void setId(int id){
            this.id = id;
        }

        public String getTitle(){
            return title;
        };

        public void setTitle(String title){
            this.title = title;
        }

        public int getReleaseYear(){
            return releaseYear;
        };

        public void setReleaseYear(int year){
            this.releaseYear = year;
        }

        public List<String> getGenres(){
            return genres;
        };

        public void setGenres(List<String> genres){
            this.genres = genres;
        }
    }

    public static void main(String[] args) {
        String[] movieFile = {"#, Title, ReleaseYear, Genres",
                "1,Inception,2010,Action|Adventure|Sci-Fi|Thriller",
                "2,The Godfather,1972,Crime|Drama",
                "3,The Matrix,1999,Action|Sci-Fi",
                "4,Catch Me If You Can,2003,Biography|Crime|Drama",
                "5,The Dark Knight,2008,Action|Crime|Drama",
                "6,A Beautiful Mind,2001,Biography|Drama|Mystery",
                "7,WALL·E,2008,Animation|Adventure|Family",
                "8,The Good the Bad and the Ugly,1966,Adventure|Western",
                "9,The Terminal,2004,Comedy|Drama|Romance",
                "10,Titanic,1997,Drama|Romance"};

        MovieCatalog mvCat = new MovieCatalog(movieFile);
        List<Movie> listAns = mvCat.getMovies("Action", 1987, 2000);
        if(listAns.isEmpty())
            System.out.println("No movies found that match the given criteria");
        else {
            System.out.println("The movies found are ");
            for (Movie mv : listAns) {
                System.out.println(mv.title);
            }
        }
    }

    public MovieCatalog(String[] mvFile){
        for (String mv : mvFile) {
            if(mv.startsWith("#"))
                continue;

            String[] strMvDetails = mv.split(",");
            String[] strmvDetailGenres = strMvDetails[3].split("\\|");

            Movie movie = new Movie();
            movie.setId(Integer.parseInt(strMvDetails[0]));
            movie.setTitle(strMvDetails[1]);
            movie.setReleaseYear(Integer.parseInt(strMvDetails[2]));

            List<String> listGenre = new ArrayList<>();
            for(String strGenre : strmvDetailGenres) {
                listGenre.add(strGenre);
            }
            movie.setGenres(listGenre);

            for(String strGenre : strmvDetailGenres){
                if(genreMap.containsKey(strGenre)){
                    genreMap.get(strGenre).add(movie);
                }
                else {
                    List<Movie> listMovies = new ArrayList<>();
                    listMovies.add(movie);
                    genreMap.put(strGenre, listMovies);
                }
            }
        }
    }

    public List<Movie> getMovies(String genre, int startYear, int endYear){
        List<Movie> listMovie = new ArrayList<>();

        if(!genreMap.containsKey(genre)){
            return listMovie;
        }

        List<Movie> moviesFromCatalog = genreMap.get(genre);
        for(Movie mv : moviesFromCatalog){
            if(mv.releaseYear >= startYear && mv.releaseYear <= endYear)
                listMovie.add(mv);
        }

        return listMovie;
    }
}
