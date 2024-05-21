package com.cucumberproject.steps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cucumberproject.config.Configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestBase {
	private static final Logger LOG = Logger.getLogger(TestBase.class);
	public static RemoteWebDriver driver;
	public Configuration config;

	public static RemoteWebDriver getDriver() {
		return driver;

	}

	// @Parameters("browser-name")
	@Before
	public void setUp() {
		config = new Configuration();
		String browserName = config.getBrowserName();
		if (browserName == null) {
			System.out.println("Browser name was not provided, setting up with default browser");
			browserName = "Firefox";
		}
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("InternetExplorer")) {
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Launching default driver");
			driver = new ChromeDriver();
		}
		driver.get(config.getAppUrl("beta"));

	}

	@After(order = 1)
	public void takeScreenShotOnTestFailure(Scenario scenario) throws IOException {

		try {
			if (scenario.isFailed()) {
				Date date = new Date();
				String screnShotFname = date.toString().replace(" ", "-").replace(":", "-");

				System.out.println(date);

				AShot ashot = new AShot();
				BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
						.takeScreenshot(TestBase.getDriver()).getImage();
				String baseDir = System.getProperty("user.dir");
				ImageIO.write(img, "png", new File(
						baseDir + "\\src\\main\\resources\\FaildTestCaseScreenShot\\" + screnShotFname + ".png"));

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		driver.quit();

	}

}
