package remoteTesting.DockerValidation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StopDocker {

	@Test
	public void stopDocker() throws Exception {
		boolean flag = false;
		String file = "output.txt";
		/*
		 * BufferedWriter writer =new BufferedWriter(new FileWriter(file));
		 * writer.write(""); writer.flush(); writer.close();
		 */
		Runtime ru = Runtime.getRuntime();
		ru.exec("cmd /c Start stopDocker.bat");

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
				if (currentline.contains("INFO stopped: selenium-grid-hub")) {
					System.out.println("Docker shutdown Successfully");
					flag = true;
					break;
				}
				currentline = read.readLine();
			}
			read.close();
		}
		Assert.assertTrue(flag);

	}

}
