package com.Lingoda.pages;

import com.Lingoda.utilities.Driver;
import com.Lingoda.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

Log log = new Log();

    public List<WebElement> toDoList(){
        return Driver.get().findElements(By.xpath("//ul[contains(@class,'todo')]/li"));
    }


    public WebElement textElement(String text){
        return Driver.get().findElement(By.xpath("//*[text()='"+text+"']"));
    }
    public WebElement placeholderElement(String text){
        return Driver.get().findElement(By.xpath("//*[@placeholder='"+text+"']"));
    }
    Actions a=new Actions(Driver.get());



    public void actions(String text,String action,String type) throws InterruptedException {
       try{
           WebElement element = null;

           String place=text;
           if (action.equalsIgnoreCase("writed")|action.equalsIgnoreCase("editted")){
               place=text.split(" - ")[0];
           }

           if (type.equalsIgnoreCase("text")){
               element=textElement(place);
           }else if (type.equalsIgnoreCase("placeholder")){
               element=placeholderElement(place);
           }

           if (action.equalsIgnoreCase("clicked")){
               element.click();
           }else if (action.equalsIgnoreCase("displayed")){
               element.isDisplayed();
           }else if (action.equalsIgnoreCase("writed")){
               element.sendKeys(text.split(" - ")[1]+ Keys.ENTER);
           } else if (action.equalsIgnoreCase("double clicked")){
               a.doubleClick(element).build().perform();
           }else if (action.equalsIgnoreCase("editted")){
               JavascriptExecutor js = ((JavascriptExecutor) Driver.get());
               js.executeScript("arguments[0].innerText='"+text.split(" - ")[1]+"'", element);
           }
           log.info(text+" is "+action+" with "+ type);
       }catch (Exception e){
           log.error(e+" "+text+" couldn't "+action+ " with "+type);
       }

    }


}
