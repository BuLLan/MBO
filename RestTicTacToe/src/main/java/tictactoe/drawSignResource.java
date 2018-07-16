package tictactoe;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import tictactoe.model.drawSign;

@Path("drawSign")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class drawSignResource {


    @GET
    public drawSign getSign(){
       return new drawSign("Kreuz", "1", "A", "Oben", "Links", "Zentrum");
    }

    @POST
    public drawSign setSign(drawSign ds){

        String zeichen = ds.getSign();
        String zeile = ds.getZeile();
        String spalte = ds.getSpalte();
        String level = ds.getLevel();
        String direction = ds.getDirection();
        String centre = ds.getCentre();

        int box=9;

        if (spalte.equals("A") || direction.equals("Links")){
            if(zeile.equals("1") || level.equals("Oben")){
                box = 0;
            }
        }
        if (spalte.equals("B") || direction.equals("Mitte")){
            if(zeile.equals("1") || level.equals("Oben")){
                box = 1;
            }
        }
        if (spalte.equals("C") || direction.equals("Rechts")){
            if(zeile.equals("1") || level.equals("Oben")){
                box = 2;
            }
        }
        if (spalte.equals("A") || direction.equals("Links")){
            if(zeile.equals("2") || level.equals("Mitte")){
                box = 3;
            }
        }
        if (centre.equals("Zentrum")){
            box = 4;
        }
        if (spalte.equals("B") || direction.equals("Mitte")){
            if(zeile.equals("2") || level.equals("Mitte")){
                box = 4;
            }
        }
        if (spalte.equals("C") || direction.equals("Rechts")){
            if(zeile.equals("2") || level.equals("Mitte")){
                box = 5;
            }
        }
        if (spalte.equals("A") || direction.equals("Links")){
            if(zeile.equals("3") || level.equals("Unten")){
                box = 7;
            }
        }
        if (spalte.equals("B") || direction.equals("Mitte")){
            if(zeile.equals("3") || level.equals("Unten")){
                box = 7;
            }
        }
        if (spalte.equals("C") || direction.equals("Rechts")){
            if(zeile.equals("3") || level.equals("Unten")){
                box = 8;
            }
        }
        if(GUI.state[box] == 0) {
            if (GUI.player == 1 && (zeichen.equals("Kreuz") || zeichen.equals("Icks"))) {
                GUI.state[box] = 1;
                Game.check(GUI.player);
                GUI.player = 2;
            }

            if (GUI.player == 2 && (zeichen.equals("Kreis") || zeichen.equals("Ring") || zeichen.equals("Oh"))) {
                GUI.state[box] = 2;
                Game.check(GUI.player);
                GUI.player = 1;
            }
        }
        return ds;
    }

}
