package com.amazon.stepDefinitions;

import com.amazon.tasks.AmazonArticuloTask;
import com.amazon.tasks.AmazonHomeTask;
import com.amazon.tasks.AmazonSearchTask;
import com.amazon.utils.Excel;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.amazon.userInterface.AmazonArticuloUI.LBL_ARTICLE;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SearchAmazonStepDefinition {

    /*Permite abrir la pagina*/
    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("I am on the amazon")
    public void iAmOnTheAmazon() {
        theActorCalled("Robot").wasAbleTo(Open.url("https://www.amazon.com/"));

    }
    @When("I am on the Amazon page and I'm looking for a random item Shop by Category")
    public void iAmOnTheAmazonPageAndIMLookingForARandomItemShopByCategory() {

        /*Permite llamar la clase*/
        theActorInTheSpotlight().attemptsTo(
                AmazonHomeTask.AmazonHomeTask(),
                AmazonSearchTask.AmazonSearchTask()
        );

    }
    @Then("I will validate the name of  the article")
    public void iWillValidateTheNameOfThearticle() {
        ArrayList<Map<String, String>> dataExcel;
        try {
            dataExcel = Excel.leerDatosDeHojaDeExcel("datos/Data.xlsx", "Search");

            OnStage.theActorInTheSpotlight()
                    .should(GivenWhenThen.seeThat(WebElementQuestion.the(LBL_ARTICLE),
                                    WebElementStateMatchers.containsText(dataExcel.get(0).get("Validation"))
                            )
                    );

        } catch (IOException e) {
            e.printStackTrace();
        }

        theActorInTheSpotlight().attemptsTo(AmazonArticuloTask.AmazonArticuloTask());


    }
}
