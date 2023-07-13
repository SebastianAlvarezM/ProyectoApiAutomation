package com.lulobank.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.lulobank.questions.Response.getIdImage;
import static net.serenitybdd.rest.SerenityRest.given;

public class Delete implements Task{

    private final String resourceApi;

    public Delete(String resourceApi) {
        this.resourceApi = resourceApi;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        given().
                and().when().delete(resourceApi +"s"+"/"+getIdImage())
                .then().extract().response();
    }

    public static Delete deleteImage(String resourceApi){
        return Tasks.instrumented(Delete.class, resourceApi);
    }
}
