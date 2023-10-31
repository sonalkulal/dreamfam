package com.meteorite.screenshotsetup;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.meteorite.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FullPageScreenShot {
	public void takeFullPageScreenShot(String fileName) throws IOException {
		Date date = new Date();
		String screnShotFname = date.toString().replace(" ", "-").replace(":", "-");

		System.out.println(date);

		AShot ashot = new AShot();
		BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
				.takeScreenshot(TestBase.getDriver()).getImage();
		String baseDir = System.getProperty("user.dir");
		ImageIO.write(img, "png",
				new File(baseDir + "\\src\\main\\resources\\FaildTestCaseScreenShot\\" + screnShotFname + fileName+".png"));
	}

}
