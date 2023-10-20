package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Testbase {

	public static Properties props;
	public FileInputStream file;
	public static WebDriver driver;

	public Testbase() throws Throwable {

		props = new Properties();

		try {
			file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\com.empirehome\\src\\main\\java\\com\\configprop\\configprop");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Initialization() {

		String browsername = props.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if (browsername.equalsIgnoreCase("Edge")) {

			System.setProperty("Webdriver.edge.driver",
					"C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64.exe");

			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

}
