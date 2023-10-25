package com.amazon.interactions;

import com.amazon.utils.EscrituraExcel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static com.amazon.userInterface.AmazonCatalogueUI.LBL_NAME_ARTICLE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickRandom implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        //Todo esto es una Interacción

        /*Listado*/
        List<WebElementFacade> ListaNombres = LBL_NAME_ARTICLE.resolveAllFor(actor);
        /*numero aleatorio*/
        Random random = new Random();
        int randomSelection = random.nextInt(ListaNombres.size());
        EscrituraExcel.escrituraExcel("datos/Data.xlsx",ListaNombres.get(randomSelection).getText(),1,1);
        ListaNombres.get(randomSelection).click();

    }
    public static Performable ClickRandom(){
        return instrumented(ClickRandom.class);
    }
}
