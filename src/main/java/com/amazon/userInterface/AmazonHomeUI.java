package com.amazon.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class AmazonHomeUI {

    /*Se dilegencia al localizador: en este caso barra de busqueda*/
    public static Target TXT_SEARCH = Target.the("Textbox Search")
            .locatedBy("//input[@id='twotabsearchtextbox']");
}
