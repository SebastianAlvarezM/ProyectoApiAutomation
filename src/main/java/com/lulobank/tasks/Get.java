package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static com.lulobank.factory.CreateImagesDataFactory.LIMIT;
import static net.serenitybdd.rest.SerenityRest.given;

public class Get implements Task{

        private String resourceApi;

    public Get(String resourceApi) {
        this.resourceApi = resourceApi;
    }

        @Step("{0} consume get method")
        @Override
        public <T extends Actor> void performAs(T actor) {
        if ("image".equals(resourceApi)){
            given().
                    and().when().get(resourceApi +"s"+"/"+"search")
                    .then().extract().response();
        } else {
            given().
                    and().when().get(resourceApi +"/"+"search"+"?limit="+LIMIT+"&"+"api_key=live_FRAjjBNx71XCGDjN3NAfH6nmP73Y6DKxnW1L6kakHTUz2l9srV7zCoswhmnHd32O")
                    .then().extract().response();
        }

    }
        public static Get executeGetMethodWithThe(String resourceApi){
        return Tasks.instrumented(Get.class, resourceApi);

    }
}
