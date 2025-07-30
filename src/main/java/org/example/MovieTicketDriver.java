package org.example;

public class MovieTicketDriver {
    public static void main(String[] args){
        Movie m = new Movie("Dabangg","Action",4.7, 126,"Its a good movie about a Mumbai Cop (Salman Khan)");
        m.insertMovie();
        m.showMovies();
    }
}
