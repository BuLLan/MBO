package tictactoe;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class Main extends Application<RestConfig> {

	public static void main(String[] args) throws Exception {

	    new Main().run(args);

		new GUI();
		new ImageLoader();
	}

	@Override
	public void run(RestConfig conf, Environment env) throws Exception{
        env.jersey().register(new drawSignResource());
        env.jersey().register(new restartResource());
    }

}
