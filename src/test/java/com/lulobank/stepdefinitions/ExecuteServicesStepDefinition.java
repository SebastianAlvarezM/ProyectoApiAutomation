package com.lulobank.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.lulobank.exceptions.ErrorsAssertion.THE_CODES_DO_NOT_MATCH;
import static com.lulobank.questions.Response.getIdImage;
import static com.lulobank.tasks.Delete.deleteImage;
import static com.lulobank.tasks.Get.executeGetMethodWithThe;
import static com.lulobank.tasks.Post.favoritesImage;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static com.lulobank.questions.Response.getStatusCode;

public class ExecuteServicesStepDefinition {

    @Before
    public static void actor(){
        OnStage.setTheStage(new Cast());
        theActorCalled("Cat");
    }

    @Before
    public static void setUpRest(){
        RestAssured.baseURI = "https://api.thecatapi.com";
        RestAssured.basePath = "/v1";
        RestAssured.filters(new ResponseLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .build();
    }

    @Given("I makes the connection to the api")
    public void iMakesTheConnectionToTheApi() {
        givenThat(theActorCalled("cat").whoCan(CallAnApi.at("/")));
    }

    @When("Execute the method GET with the resource api {string}")
    public void executeTheMethodGETWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetMethodWithThe(resourceApi));

    }

    @Then("See that the is returned {int}")
    public void seeThatTheIsReturned(Integer statusCode) {
        assertThat(THE_CODES_DO_NOT_MATCH,
                theActorInTheSpotlight().asksFor(getStatusCode()), equalTo(statusCode)

                );

    }

    @When("Execute the method DELETE with the resource api {string}")
    public void executeTheMethodDELETEWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(deleteImage(resourceApi));
    }

    @When("Execute the method POST with the resource api {string}")
    public void executeTheMethodPOSTWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(favoritesImage(resourceApi));

    }
}
