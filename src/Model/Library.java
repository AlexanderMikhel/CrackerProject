package Model;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * This class keeping tracks and provides tools for managing them
 */
public class Library implements Serializable{
    private ArrayList<Track> tracksStore = new ArrayList<>();
    private ArrayList<Genre> genres = new ArrayList<>();
    private int tracksQuantity=0;
    private int genresQuantity=0;

    public Library() {

    }
    public int getTracksQuantity(){
        return  tracksQuantity;
    }

    /*add to library single track*/
    public void setTrack(Track track){
        tracksStore.add(track);
        tracksQuantity++;
    }
    public void setGenre(Genre genre){
        genres.add(genre);
        genresQuantity++;
    }
    public ArrayList getTracks(){
        return tracksStore;
    }
    public ArrayList getGenres(){
        return genres;
    }

    public Track getTrack(String trackName){
        return tracksStore.get((int) getTrackIndex(trackName).get(0));
    }

    /**find track in the library and remove them*/
    public void removeTrack(String trackName){
        for(int i = 0; i < getTrackIndex(trackName).size(); i++){
            tracksStore.remove((int) getTrackIndex(trackName).get(i));
        }
    }

    /**change exist track for a new*/
    public void setTrack(Track newTrack, String oldTrackName){
        tracksStore.set((int) getTrackIndex(oldTrackName).get(0), newTrack);
    }

    public ArrayList<Track> search(String str) throws PatternSyntaxException{
        ArrayList<Track> searchTrack= new ArrayList<>();
        Pattern p = Pattern.compile(str);
        for(int i = 0; i< tracksQuantity; i++ ) {
            Matcher trackName=p.matcher(tracksStore.get(i).getTrackName());
            Matcher trackArtist=p.matcher(tracksStore.get(i).getTrackArtist());
            Matcher trackAlbum=p.matcher(tracksStore.get(i).getTrackAlbum());
            Matcher trackLenght=p.matcher(tracksStore.get(i).getTrackLenghttoString());
            if(trackName.find() || trackArtist.find() || trackAlbum.find() || trackLenght.find()){
                  searchTrack.add(tracksStore.get(i));
              }
        }
        return searchTrack;
    }

    public Genre getGenre(String genre){
        Pattern pattern = Pattern.compile(genre);
        for (int i=0;i<genresQuantity;i++){
            Matcher genreName= pattern.matcher(genres.get(i).getGenreName());
            if (genreName.find()){
                return genres.get(i);
            }
        }
        return null;
    }
    //return the index of the first found element;
    private ArrayList getTrackIndex(String str) {
        Pattern p = Pattern.compile(str);
        ArrayList<Integer> a = new ArrayList<>(2);
        for (int i = 0; i < tracksQuantity; i++) {
            Matcher trackName = p.matcher(tracksStore.get(i).getTrackName());
            Matcher trackArtist = p.matcher(tracksStore.get(i).getTrackArtist());
            Matcher trackAlbum = p.matcher(tracksStore.get(i).getTrackAlbum());
            Matcher trackLenght = p.matcher(tracksStore.get(i).getTrackLenghttoString());
            if (trackName.find() || trackArtist.find() || trackAlbum.find() || trackLenght.find()) {
                    a.add(i);
            }
        }
        return a;
    }
    
}