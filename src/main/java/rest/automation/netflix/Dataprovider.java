package rest.automation.netflix;

/*
1. Linked list traversal.
2. How yo reverse the linked list using one pass
3. How to find middle node of linked list using one pass.
4. How to find a linked list is circular or not ?*/

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	private final String yamlPath = "temp1.yaml";
	
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
