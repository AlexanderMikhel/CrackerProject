package Model;

import java.io.Serializable;

/**
 * Contains information about single track
 *
 * @version 0.1
 */
public class Track implements Serializable{
    /**
     * name of this track
     */
    private String trackName;

    /**
     * artist, who perform this track
     */
    private String trackArtist;

    /**
     * album, which contains this track
     */
    private String trackAlbum;

    /**
     * length of this track in seconds
     */
    private int trackLength;

    private Genre trackGenre;

    public Track(String trackName, String trackArtist, String trackAlbum, int trackLength, Genre trackGenre) {
        this.trackName = trackName;
        this.trackArtist = trackArtist;
        this.trackAlbum = trackAlbum;
        this.trackLength = trackLength;
        this.trackGenre = trackGenre;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Genre getTrackGenre() {
        return trackGenre;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public void setTrackAlbum(String trackAlbum) {
        this.trackAlbum = trackAlbum;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public String getTrackAlbum() {
        return trackAlbum;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public String getTrackLenghttoString(){
        int sec = trackLength%60;
        int min = trackLength - sec;
        return sec+" "+min;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Track)) {
            return false;
        }
        Track track = (Track) object;
        return ((this.trackName.equals(track.trackName)) && (this.trackArtist.equals(track.trackArtist)) &&
                (this.trackAlbum.equals(track.trackAlbum)) && (this.trackLength == track.trackLength));
    }
}