package com.amazon.tasks;


import com.amazon.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.amazon.userInterface.AmazonHomeUI.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AmazonHomeTask implements Task {

    private static ArrayList<Map<String, String>> leerExcel = new ArrayList();


    /*Permite que el actor realice tareas concretas*/
    @Override
    public <T extends Actor> void performAs(T actor) {

        /*Permite el llamado del documento Excel =(Nombre del dumento y la hoja)*/
        try {
            leerExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx","Search");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*Permite el llamado de la posicion y nombre de la hoja*/
        actor.attemptsTo(
                Enter.theValue(leerExcel.get(0).get("Search")).into(TXT_SEARCH).
                        thenHit(Keys.ENTER)
        );

    }
    public static Performable AmazonHomeTask(){
        return instrumented(AmazonHomeTask.class);

    }


}
