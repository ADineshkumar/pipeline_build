package remoteTesting.DockerValidation;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandaloneTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//DesiredCapabilities - to provide browser info
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setPlatform(Platform.WIN11);
		cap.setBrowserName("chrome");
		
		//URL u = new URL("http://172.17.0.2:4444");
		URL u = new URL("http://localhost:4444");
		//RemoteWebDriver - expecting url and desired caps
		RemoteWebDriver driver = new RemoteWebDriver(u,cap);
		String url ="https://atsqa.org/certified-testers/profile/470b2a23cc4a4297abd68f4c7806a2c7";
		driver.get(url);
		//driver.get("http://google.com");
		System.out.println(driver.getTitle());

	}

}
