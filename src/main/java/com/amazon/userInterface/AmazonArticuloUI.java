package com.amazon.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class AmazonArticuloUI {

    public static final Target LBL_ARTICLE = Target.the("LABEL VALIDATEION ARTICULO NAME")
            .located(By.id("productTitle"));

    public static final Target BTN_HOME = Target.the("LABEL VALIDATEION ARTICULO NAME")
            .located(By.id("nav-logo-sprites"));
}
