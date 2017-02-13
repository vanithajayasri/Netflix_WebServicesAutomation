package rest.automation.netflix;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StringReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class TestClass {
	@Test(dataProviderClass = Dataprovider.class , dataProvider = "searchMovieDetails")
	public static void  TestValidateResponse(String title,int unit ,int show_id ,String show_title,String release_year,
			String director){
		try{
			
			//client setup
			DefaultHttpClient httpClient = new DefaultHttpClient();
			String url = "http://netflixroulette.net/api/api.php?title="+title;
			HttpGet getRequest = new HttpGet(url);
			
			//Call API	
			HttpResponse response = httpClient.execute(getRequest);
			String result = EntityUtils.toString(response.getEntity());
			SearchResponse sr1 = parseResponse(result);
			sr1.getMovieList();
			
			//Validate Response
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}else{
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(result);
			}
			
			validateResponse(sr1,unit , show_id , show_title,release_year,director);
			
			//Validate DB
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static SearchResponse parseResponse(String result){
		Gson gson = new Gson();
		String res1 = result.substring(0);
		res1 = "{\"movieList\":["+res1+"]}";
		System.out.println(res1);
		return(gson.fromJson(res1, SearchResponse.class));
	}
	
	public static void validateResponse(SearchResponse sr1, int unit ,int show_id ,String show_title,String release_year,
			String director){
		Movie movie1 = new Movie();
		movie1 = sr1.getMovieList().getFirst();
		
		Assert.assertEquals(movie1.getUnit(), unit,"unit not matches");
		Assert.assertEquals(movie1.getShow_id(), show_id,"show id not matches");
		Assert.assertEquals(movie1.getShow_title(),show_title,"show id not matches");
		Assert.assertEquals(movie1.getRelease_year(),release_year,"release_year not matches");
		Assert.assertEquals(movie1.getDirector(),director,"director not matches");

	}

	
}
