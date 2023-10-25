package com.amazon.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class AmazonCatalogueUI {

    public static final Target LBL_NAME_ARTICLE = Target.the("Collection of KOORUI").
            locatedBy("//span[@class='a-size-medium a-color-base a-text-normal' and not(@is-empty)]");


}
