import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class launchChrome {
	public static void main(String args[]) throws InterruptedException {
		String chromedriverPath = System.getProperty("user.dir")
				+ "\\resources\\chromedriver.exe";
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);

		prefs.put("download.prompt_for_download", false);
		prefs.put("directory_upgrade", true);
		prefs.put("download.default_directory", System.getProperty("user.dir"));

		options.setExperimentalOption("prefs", prefs);

		options.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");

		System.out.println("Chrome Launched Succesfully!");

		driver.quit();
	}
}