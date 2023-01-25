package com.Lingoda.runners;


import com.Lingoda.utilities.MyScreenRecorder;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com/Lingoda/stepDefs"
)
public class FailedRunner {
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
