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
       return new drawSign("Kreuz", "1", "A");
    }

    @POST
    public drawSign setSign(drawSign ds){

        String zeichen = ds.getSign();
        String zeile = ds.getZeile();
        String spalte = ds.getSpalte();

        int box=9;

        if (spalte.equals("A")){
            if(zeile.equals("1")){
                box = 0;
            }
        }
        if (spalte.equals("B")){
            if(zeile.equals("1")){
                box = 1;
            }
        }
        if (spalte.equals("C")){
            if(zeile.equals("1")){
                box = 2;
            }
        }
        if (spalte.equals("A")){
            if(zeile.equals("2")){
                box = 3;
            }
        }
        if (spalte.equals("B")){
            if(zeile.equals("2")){
                box = 4;
            }
        }
        if (spalte.equals("C")){
            if(zeile.equals("2")){
                box = 5;
            }
        }
        if (spalte.equals("A")){
            if(zeile.equals("3")){
                box = 7;
            }
        }
        if (spalte.equals("B")){
            if(zeile.equals("3")){
                box = 7;
            }
        }
        if (spalte.equals("C")){
            if(zeile.equals("3")){
                box = 8;
            }
        }
        if(GUI.state[box] == 0) {
            if (GUI.player == 1 && zeichen.equals("Kreuz")) {
                GUI.state[box] = 1;
                Game.check(GUI.player);
                GUI.player = 2;
            }

            if (GUI.player == 2 && zeichen.equals("Kreis")) {
                GUI.state[box] = 2;
                Game.check(GUI.player);
                GUI.player = 1;
            }
        }
        return ds;
    }

}