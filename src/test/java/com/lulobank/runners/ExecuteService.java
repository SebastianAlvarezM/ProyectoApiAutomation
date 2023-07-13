package com.lulobank.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber"},
        glue = "com.lulobank.stepdefinitions",
        // tags = "@services",
        //tags = "@GetCats",
        //tags = "@GetMoreTenCats",
        //tags = "@GetCats or @DeleteImage",
        tags = "@PostImage",
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)

public class ExecuteService {
}
