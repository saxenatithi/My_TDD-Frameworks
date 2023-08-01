package base_class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TDD_Base {
	
	public static Properties pro=new Properties();
	public static WebDriver driver;
	
	public TDD_Base() {
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\tithi\\Desktop\\Software Testing\\TDD_HRProject\\src\\test\\java\\envi_variables\\config.properties" );
		pro.load(file);
	}
		catch(FileNotFoundException e) { e.printStackTrace();}
		catch(IOException i)	{i.printStackTrace();}
		}

	public static void initial() {
	String browser=	pro.getProperty("Browser"); 
	if(browser.equals("Chrome")) { System.setProperty("webriver.chrome.driver", "chromedriver.exe");
	ChromeOptions Ch=new ChromeOptions();
	Ch.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver (Ch);}
	else if(browser.equals("Firefox")) {System.setProperty("webriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver ();}
	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(pro.getProperty("URL"));
		}
	
	public static void snaps(String filename) {
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(file, new File("C:\\Users\\tithi\\Desktop\\Software Testing\\TDD_HRProject"
				+ "\\src\\test\\java\\proof_snaps\\Snapshots" +filename+".jpg"));
		}
		catch(IOException e) {e.printStackTrace();}
		
	}
}
