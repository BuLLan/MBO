package tictactoe;

import javax.ws.rs.*;

@Path("restart")
public class restartResource {

    @POST
    public void init_restart(){
        Game.reset();
    }

}
