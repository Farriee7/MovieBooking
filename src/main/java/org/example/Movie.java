package org.example;

import java.util.List;
import java.util.Map;

public class Movie {
    private final String title;
    private final String genre;
    private final double rating;
    private final int duration;
    private final String synopsis;

    private final DatabaseOperation db = new DatabaseOperation();
   

    public Movie(String title, String genre, double rating, int duration, String synopsis){
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.synopsis = synopsis;
    }

 

    public void insertMovie(){
        String sql = "INSERT INTO movies (title, genre, rating, duration, synopsis) VALUES(?,?,?,?,?)";
        Object[] values = {title, genre, rating, duration, synopsis};
        int rowsAffected = db.executeUpdate(sql, values);
        if(rowsAffected > 0)
            System.out.println("Movie Inserted Successfully");
        else
            System.out.println("Oops!! Something went wrong");
    }

    public void showMovies(){
        String sql = "SELECT * FROM movies"; // Make sure your table name is lowercase if DB is case-sensitive
        List<Map<String, Object>> movies = db.getRecords(sql);
        for(Map<String , Object> movie : movies){
            System.out.println("Movie ID: " + movie.get("MovieID"));
            System.out.println("Title: " + movie.get("Title"));
            System.out.println("Genre: " + movie.get("Genre"));
            System.out.println("Rating: " + movie.get("Rating"));
            System.out.println("Duration(mins): " + movie.get("Duration"));
            System.out.println("Synopsis: " + movie.get("Synopsis"));
            System.out.println("-----------------------------------------");   
        }
    }
}
