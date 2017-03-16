package rest.automation.netflix;

import  rest.automation.netflix.ReusableMethods;
import org.testng.annotations.Test;

public class TestClass {
	
	@Test(dataProviderClass = Dataprovider.class , dataProvider = "netflix")
	public void  testSearchMovie(NetflixTestData netflixTestData){
		
		String url = "http://netflixroulette.net/api/api.php?";
		if((netflixTestData.getResourceMetaData().getFirst().getSearchData().getSearchRequest().getTitle()!= null)){
		     url = url + "title="+netflixTestData.getResourceMetaData().getFirst().getSearchData().getSearchRequest().getTitle();
		}
		if((netflixTestData.getResourceMetaData().getFirst().getSearchData().getSearchRequest().getDirector())!=null){
			 url = url + "director="+netflixTestData.getResourceMetaData().getFirst().getSearchData().getSearchRequest().getDirector();
		}
		SearchResponse sr1 = ReusableMethods.apiSetup(netflixTestData, url);
		//Validate the response
		ReusableMethods.validateResponse(netflixTestData.getResourceMetaData().getLast().getSearchData().getSearchResponse(), sr1);
		
			
	}
}
	

