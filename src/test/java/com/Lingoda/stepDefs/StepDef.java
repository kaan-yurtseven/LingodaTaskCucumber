package com.Lingoda.stepDefs;

import com.Lingoda.pages.BasePage;
import com.Lingoda.pages.HomePage;
import com.Lingoda.utilities.Driver;

import com.Lingoda.utilities.Log;
import com.Lingoda.utilities.Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class StepDef {
    Log log = new Log();
    BasePage basePage =new BasePage();
    HomePage homePage = new HomePage();

    @Given("the user is on the website")
    public void theUserIsOnTheWebsite() {
        String url = Reader.get("url");
        try{
            Driver.get().get(url);
            log.info(url+" is launched");
        }catch (Exception e){
            log.error(e+" "+url+" couldn't launched");
        }

    }

    @Then("Website is opened as a {string}")
    public void websiteIsOpenedAsA(String title) {
        try{
            assertTrue(title.equalsIgnoreCase(Driver.get().getTitle()));
            log.info("Web site title is opened as a "+title);
        }catch (Exception e){
            log.error(e+" Web site title is not opened as a "+title);
        }

    }



    @When("{string} is {string} with {string}")
    public void isWith(String str, String action, String type) throws InterruptedException {
        basePage.actions(str,action,type);
    }



    @Then("TodoList has {int} items")
    public void todolistHasItems(int i) {
        try{
            assertTrue(homePage.toDoList().size()==i);
            log.info("ToDo List has "+i+" items");
        }catch (Exception e){

        }

    }


}
