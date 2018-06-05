
package alexattt.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Willkommen bei Tic Tac Toe";
        String repromptText = "Bitte setze dein Zeichen";
        return input.getResponseBuilder()
                .withSimpleCard("TicTacToe", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .build();
    }
}
