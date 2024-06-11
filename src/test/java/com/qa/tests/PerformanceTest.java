package com.qa.tests;

import com.qa.util.APIClient;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PerformanceTest {

    private WebDriver driver;
    private APIClient apiClient;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        apiClient = new APIClient();
    }

    @Test
    public void testAPIResponseTime() {
        // Browse to API to verify if is available
        driver.get("http://localhost:8080/");

        // Measure the API performance
        long startTime = System.currentTimeMillis();

        Response response = apiClient.getPetById(1);
        // Call the correct method with the value ID

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        // Record the response time
        System.out.println("API Response Time: " + responseTime + " ms");

        // Assert to verify code response and max time
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(responseTime < 2000, "API response time is too high!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
     }
}