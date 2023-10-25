package com.amazon.tasks;

import com.amazon.interactions.ClickRandom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AmazonSearchTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickRandom.ClickRandom()

        );
    }
    public static Performable AmazonSearchTask(){

        return instrumented(AmazonSearchTask.class);
    }
}
