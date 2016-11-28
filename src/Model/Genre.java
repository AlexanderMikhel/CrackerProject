package Model;

import java.io.Serializable;

/**
 * This class contains basic information about single genre
 * @version 0.1
 */
public class Genre implements Serializable{
    /**name of this genre*/
    private String genreName;

    /**century when this genre was established*/
    private int establishingCentury;

    public Genre(String genreName, int establishingCentury){
        this.genreName=genreName;
        this.establishingCentury=establishingCentury;
    }

    public String getGenreName() {
        return genreName;
    }

    public int getEstablishingCentury() {
        return establishingCentury;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void setEstablishingCentury(int establishingCentury) {
        this.establishingCentury = establishingCentury;
    }
}
