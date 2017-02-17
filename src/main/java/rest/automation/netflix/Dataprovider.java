package rest.automation.netflix;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	private final String yamlPath = "src/main/java/rest/automation/netflix/search.yaml";
	
	@DataProvider(name = "netflix")
	public Iterator<Object[]> getTestDataFromYaml(Method testMethod, ITestContext testContext) throws Exception{
		return NetflixYamlProvider.getNetflixTestData(testMethod, yamlPath);
	}

/*	@DataProvider(name = "searchMovieDetails")
	public static Object[][] movieFields() throws IOException{
		Object[][] data1 = new Object[1][6];
		Object[][] recData = readxls( "C:/VANITHA//netflix_data/netflix_data.xlsx", "Sheet1");
		
		data1[0][0] = recData[1][0];
		data1[0][1] = Integer.parseInt(recData[1][1].toString());
		data1[0][2] = Integer.parseInt(recData[1][2].toString());
		data1[0][3] = recData[1][3];
		data1[0][4] = recData[1][4];
		data1[0][5] = recData[1][5];
		
		
		return data1;
		
	}*/
}
