package tictactoe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class drawSign {
    private String sign;
    private String zeile;
    private String spalte;

    public drawSign(@JsonProperty("sign") String sign, @JsonProperty("zeile") String zeile, @JsonProperty("spalte") String spalte){
        this.sign = sign;
        this.zeile = zeile;
        this.spalte = spalte;
    }

    public String getSign(){ return sign; }
    public void setSign(String sign){ this.sign = sign; }

    public String getZeile(){ return zeile; }
    public void setZeile(String zeile){ this.zeile = zeile; }

    public String getSpalte(){ return spalte; }
    public void setSpalte(String spalte){ this.spalte = spalte; }
}
