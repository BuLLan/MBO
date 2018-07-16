package alexattt.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;



import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class DrawSignHandler implements RequestHandler  {
    public static final String SIGN_SLOT = "sign";
    public static final String REIHE_SLOT = "reihe";
    public static final String SPALTE_SLOT = "spalte";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("drawSign"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        Slot curPlayer = slots.get(SIGN_SLOT);
        Slot curReihe = slots.get(REIHE_SLOT);
        Slot curSpalte = slots.get(SPALTE_SLOT);


        String speechText, repromptText;
        boolean isAskResponse = false;

        speechText = "Erfolgreich eingegeben";
        repromptText = "Weiter geht es";

        if (curPlayer != null && curReihe != null && curSpalte != null) {
            try {
                CloseableHttpClient client = HttpClients.createDefault();
                //TODO: URL anpassen
                HttpPost httpPost = new HttpPost("http://ptsv2.com/t/c8idn-1528175354/post");

                String json = "{\"sign\":\""+curPlayer.getValue()+"\",\"reihe\":\""+curReihe.getValue()+"\",\"spalte\":\""+curSpalte.getValue()+"\"}";
                StringEntity entity = new StringEntity(json);
                httpPost.setEntity(entity);
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");

                CloseableHttpResponse response = client.execute(httpPost);
                client.close();
            }
            catch (IOException e){}
        }

        ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withShouldEndSession(false);

        if (isAskResponse) {
            responseBuilder.withShouldEndSession(false)
                    .withReprompt(repromptText);
        }

        return responseBuilder.build();
    }

}
