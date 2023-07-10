package remoteTesting.DockerValidation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StartDocker {

	@Test
	public void startDocker() throws Exception {
		boolean flag = false;
		String file = "output.txt";
		
		BufferedWriter writer =new BufferedWriter(new FileWriter(file));
		writer.write("");
		writer.flush();
		writer.close();
		
		Runtime ru = Runtime.getRuntime();
		ru.exec("cmd /c Start startDocker.bat");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 30);
		long sec = cal.getTimeInMillis();

		while (System.currentTimeMillis() < sec) {
			if (flag) {
				break;
			}

			BufferedReader read = new BufferedReader(new FileReader(file));
			String currentline = read.readLine();
			while (currentline != null && !flag) {
				// Started Selenium Hub 4.10.0
				// INFO stopped: selenium-grid-hub
				if (currentline.contains("Started Selenium Hub 4.10.0")) {
					System.out.println("Docker is up and running");
					System.out.println("Se Hub and Node is started");
					flag = true;
					break;
				}
				currentline = read.readLine();
			}
			read.close();
		}
		Assert.assertTrue(flag);
		ru.exec("cmd /c Start scaleup.bat");
		Thread.sleep(10000);

	}

}
