package com.Lingoda.runners;

import com.Lingoda.utilities.MyScreenRecorder;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features",
        glue = "com/Lingoda/stepDefs",
        dryRun = false,
        tags = " @Test"
)
public class Runner {
@BeforeClass
    public static void start() throws Exception {
    try {
        MyScreenRecorder.deleteRecorded();
    }catch (Exception e){
        System.out.println(e);
    }

    MyScreenRecorder.startRecording("test");
}
@AfterClass
    public static void end() throws Exception {
    MyScreenRecorder.stopRecording();

}

}