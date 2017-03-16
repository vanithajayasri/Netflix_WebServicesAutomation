package rest.automation.netflix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import com.google.gson.Gson;

public class ReusableMethods {
	
	static SearchResponse sr1;
	public static SearchResponse apiSetup(NetflixTestData netflixTestData , String uri){
		try{
					
				//client setup
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpGet getRequest = new HttpGet(uri);
				
				//Call API	
				HttpResponse response = httpClient.execute(getRequest);
				String result = EntityUtils.toString(response.getEntity());
				sr1 = parseResponse(result);
				System.out.println(sr1.getMovieList());
				
				//Validate Response
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response.getStatusLine().getStatusCode());
		       }
		}
	    catch(Exception e){
			e.printStackTrace();
		}
		return sr1;
	}	
	
	public static SearchResponse parseResponse(String result) {
		Gson gson = new Gson();
		String res1 = result.substring(0);
		res1 = "{\"movieList\":"+res1+"}";
		System.out.println(res1);
		SearchResponse response = gson.fromJson(res1, SearchResponse.class);
		return(response);
	}
	
	public static void validateResponse(SearchResponse expectedResponse, SearchResponse actualResponse){
		int length = expectedResponse.getMovieList().size();
		Movie actr=null;
		Movie expr=null;
		HashMap<Integer,Movie> hmExpected = new HashMap<Integer,Movie> ();
		HashMap<Integer,Movie> hmActual = new HashMap<Integer,Movie> ();
		
		for(int i =0 ; i< length ;i++){
			 expr = expectedResponse.getMovieList().get(i);
			 actr = actualResponse.getMovieList().get(i);
			 hmExpected.put(expr.getUnit(), expr);
			 if(!(hmActual.containsKey(actr.getUnit()))){
				hmActual.put(actr.getUnit(), actr);
			 }
		}	
		Set<Integer> hme = hmExpected.keySet();
		for(int key : hme){
			if(hmActual.containsKey(key)){
				Movie valuesExp = hmExpected.get(key);
				Movie valuesAct = hmActual.get(key);
				Assert.assertEquals(valuesExp.getUnit(), valuesAct.getUnit(),"unit not matches");
				Assert.assertEquals(valuesExp.getShow_id(), valuesAct.getShow_id(),"show id not matches");
				Assert.assertEquals(valuesExp.getShow_title(),valuesAct.getShow_title(),"show id not matches");
				Assert.assertEquals(valuesExp.getRelease_year(),valuesAct.getRelease_year(),"release_year not matches");
				Assert.assertEquals(valuesExp.getDirector(),valuesAct.getDirector(),"director not matches");
			}
			else{
				Assert.fail("Actual Response does not have movie with unit- "+key);
			}
		}
	}
	
/*	public static  Object[][]  readxls(String fileName, String sheetName) throws IOException 
		
		// get the filepath
		File xlfile = new File(fileName);
		
		//read the file
		FileInputStream fip = new FileInputStream(xlfile);
		
		//access the workbook POI jar file
		  XSSFWorkbook workbook = new XSSFWorkbook(fip);
		
		//access the sheet
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		
		  int rowCount = sheet.getLastRowNum() + 1 ;
		  int colCount =sheet.getRow(0).getLastCellNum();
		  Object[][]  xlData =new String[rowCount][colCount];
			
			for(int i =0;i< rowCount;i++){
				for(int j=0 ;j<colCount ;j++){
					xlData[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					 
				}
			}
		return xlData;	
	}*/	
}


	