package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static com.lulobank.factory.CreateImagesDataFactory.LIMIT;
import static net.serenitybdd.rest.SerenityRest.given;

public class Post implements Task {

    private String resourceApi;

    public Post(String resourceApi) {
        this.resourceApi = resourceApi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        given().body("{\n" +
                        "\t\"remote_url\": \"file:///Users/tataymini/Mis_Documentos/Semillero_Lulo/SebasAlvarezApiTesting/images/Cattatay.jpg\"\n" +
                        "}")
                .and().post(resourceApi +"/"+"upload"+"&"+"api_key=live_FRAjjBNx71XCGDjN3NAfH6nmP73Y6DKxnW1L6kakHTUz2l9srV7zCoswhmnHd32O")
                .then().extract().response();

    }

    public static Post favoritesImage(String resourceApi){
        return Tasks.instrumented(Post.class, resourceApi);

    }


}
