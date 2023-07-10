package remoteTesting.DockerValidation;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest2 {
	@Test
	public void test2() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");

		URL u = new URL("http://localhost:4444");
		RemoteWebDriver driver = new RemoteWebDriver(u, cap);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
	}
}
