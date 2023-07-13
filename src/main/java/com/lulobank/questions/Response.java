package com.lulobank.questions;


import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class Response {

    public static Question<Integer> getStatusCode(){
            return Question.about("Status code").answeredBy(actor -> SerenityRest.lastResponse().statusCode());
    }

    public static Question<String> getIdImage(){
        return Question.about("Id Image").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("id").toString());
    }
}
