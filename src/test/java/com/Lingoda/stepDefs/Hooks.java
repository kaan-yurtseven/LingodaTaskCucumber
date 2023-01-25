package com.Lingoda.stepDefs;

import com.Lingoda.utilities.Driver;
import com.Lingoda.utilities.Log;
import com.Lingoda.utilities.MyScreenRecorder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp() throws Exception {

        Driver.get().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
        new Log().info("===========TEST SCENARİO STARTED=================");
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        scenario.write("Complete scenario: "+ scenario.getName());
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());
        }
        new Log().info(scenario.getName()+"===========TEST SCENARİO ENDED=================");
        Driver.closeDriver();

    }
}
