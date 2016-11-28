package View;

import Controller.Controller;
import Model.Genre;
import Model.Track;
import org.omg.CORBA.Object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class ConsoleInterface {
    private static Scanner in = new Scanner(System.in);
    private static Controller controller=new Controller();

    public static void startApplication() {
        int close = 0;
        while (close != 6) {
            displayInformation();
           try {
                close = in.nextInt();

                if (close > 6 || close < 0) {
                    System.out.println("ОШИБКА! Формат данных введен неверно");
                    break;
                }

                switch (close) {
                    case 1: {
                        switch (menuItems("add", false)) {
                            case 1: {
                                controller.setTrack();
                            }
                            break;
                            case 2: {
                                controller.setGenre();
                            }
                            break;
                        }
                    }
                    break;
                    case 2: {
                        menuItems("delete", false);

                    }
                    break;
                    case 3: {
                        menuItems("change", false);

                    }
                    break;
                    case 4: {
                        switch (menuItems("browse", true)) {
                            case 1: {
                                displayTracks(controller.getTracks());
                            }
                            break;
                            case 2: {
                                displayGenres(controller.getGenres());
                            }
                            break;
                        }
                    }
                    break;
                    case 5: {
                        //menuItems("find");
                        try {
                            displayTracks(controller.search());
                        }
                        catch (PatternSyntaxException e){
                            System.out.println("поиск поданному символу невозможен");
                        }
                    }
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("ОШИБКА! Формат данных введен неверно");
                return;
            }
        }


        controller.serialisation();
    }

    /**
     * print to console help for interact with the application
     */
    private static void displayInformation() {
        System.out.println("What you want to do?");
        System.out.println("1 - add new track or genre to library");
        System.out.println("2 - delete some data");
        System.out.println("3 - change some data");
        System.out.println("4 - browse library");
        System.out.println("5 - find track");
        System.out.println("6 - close application\n");
    }

    /**
     * interface for menu items 2,3,5
     */
    private static int menuItems(String action, boolean multiply) {
        String track="track";
        String genre="genre";
        if (multiply){
            track+="s";
            genre+="s";
        }
        System.out.printf("1 - %s %s\n", action, track);
        System.out.printf("2 - %s %s\n", action, genre);
        System.out.println("3 - back");
        return in.nextInt();
    }

    private static void displayTracks(ArrayList<Track> tracks){
        if (tracks.size()==0){
            System.out.println("Library is empty");
            System.out.println("------------------------------\n");
        }else {
            for (Track track : tracks) {
                System.out.println("Name: " + track.getTrackName());
                System.out.println("Artist: " + track.getTrackArtist());
                System.out.println("Album: " + track.getTrackAlbum());
                System.out.println("Genre: "+track.getTrackGenre().getGenreName());
                int minutes = track.getTrackLength() / 60;
                int seconds = track.getTrackLength() - minutes * 60;
                System.out.printf("Length: %d:%d\n", minutes, seconds);
                System.out.println("-----------------------\n");
            }
        }
    }

    private static void displayGenres(ArrayList<Genre> genres){
        if (genres.size()==0){
            System.out.println("Library is empty");
            System.out.println("------------------------------\n");
        }
        else{
            for (Genre genre:genres){
                System.out.println("Genre name: "+genre.getGenreName());
                System.out.println("Etablishing Century: "+genre.getEstablishingCentury());
                System.out.println("------------------------------\n");
            }
        }
    }
}
