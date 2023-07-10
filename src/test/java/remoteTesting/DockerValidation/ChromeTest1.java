package remoteTesting.DockerValidation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest1 {
	
	@BeforeTest
	public void startingDock() throws Exception {
		StartDocker start = new StartDocker();
		start.startDocker();
	}
	
	@AfterTest
	public void stopDock() throws Exception {
		StopDocker stop = new StopDocker();
		stop.stopDocker();
	}
	
	@Test
	public void test1() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");

		URL u = new URL("http://localhost:4444");
		RemoteWebDriver driver = new RemoteWebDriver(u, cap);
		String url = "https://atsqa.org/certified-testers/profile/470b2a23cc4a4297abd68f4c7806a2c7";
		driver.get(url);
		System.out.println(driver.getTitle());
	}
}
