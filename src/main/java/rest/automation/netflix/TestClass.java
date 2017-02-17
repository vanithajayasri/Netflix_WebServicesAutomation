package rest.automation.netflix;
import  rest.automation.netflix.ReusableMethods;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class TestClass {
	
	//private final String yamlPath = "rest/automation/netflix/search.yaml";
	

	@Test(dataProviderClass = Dataprovider.class , dataProvider = "netflix")
	public static void  TestValidateResponse(NetflixTestData netflixTestData){
		
		String url = "http://netflixroulette.net/api/api.php?";
		
		if((netflixTestData.getResourceMetaData().getFirst().getSearchData().getSearchRequest().getTitle()!= null)){
		     url = url + "title="+netflixTestData.getResourceMetaData().getFirst().getSearchData().getSearchRequest().getTitle();
		}
		if((netflixTestData.getResourceMetaData().getFirst().getSearchData().getSearchRequest().getDirector())!=null){
			 url = url + "director="+netflixTestData.getResourceMetaData().getFirst().getSearchData().getSearchRequest().getDirector();
		}
		
		SearchResponse sr1 = ReusableMethods.apiSetup( netflixTestData, url);
	   
		ReusableMethods.validateResponse(netflixTestData.getResourceMetaData().getLast().getSearchData().getSearchResponse(), sr1);
		
			
	}
}
	

