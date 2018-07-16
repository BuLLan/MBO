package tictactoe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class drawSign {
    private String sign;
    private String zeile;
    private String spalte;
    private String level;
    private String direction;
    private String centre;




    public drawSign(@JsonProperty("sign") String sign, @JsonProperty("zeile") String zeile, @JsonProperty("spalte") String spalte, @JsonProperty("level") String level, @JsonProperty("direction") String direction, @JsonProperty("centre") String centre){
        this.sign = sign;
        this.zeile = zeile;
        this.spalte = spalte;
        this.level = level;
        this.direction = direction;
        this.centre = centre;
    }

    public String getSign(){ return sign; }
    public void setSign(String sign){ this.sign = sign; }

    public String getZeile(){ return zeile; }
    public void setZeile(String zeile){ this.zeile = zeile; }

    public String getSpalte(){ return spalte; }
    public void setSpalte(String spalte){ this.spalte = spalte; }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getCentre() {
        return centre;
    }
    public void setCentre(String centre) {
        this.centre = centre;
    }
}
