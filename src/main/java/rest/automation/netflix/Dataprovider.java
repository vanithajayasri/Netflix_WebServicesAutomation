package rest.automation.netflix;

import org.testng.annotations.DataProvider;

public class Dataprovider {

	@DataProvider(name = "searchMovieDetails")
	public static Object[][] movieFields(){
		Object[][] data1 = new Object[][]{{"Titanic",35,1181461,"Titanic", "1997","James Cameron"}};
		return data1;
		
	}
}
