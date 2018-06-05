package alexattt;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import alexattt.handlers.*;


public class TTTStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new DrawSignHandler())
                // Add your skill id below
                //.withSkillId("amzn1.ask.skill.a5bea85a-f4e2-493d-afdd-cd44abe08cbf")
                .build();
    }

    public TTTStreamHandler() {
        super(getSkill());
    }

}

