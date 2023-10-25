package com.amazon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.amazon.userInterface.AmazonArticuloUI.BTN_HOME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AmazonArticuloTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_HOME)
        );
    }
    public static Performable AmazonArticuloTask () {
        return instrumented(AmazonArticuloTask.class);
    }
}
