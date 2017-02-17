package rest.automation.netflix;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class NetflixYamlProvider extends BaseYAMLDataProvider {

	/**
	 * Create a YAML instance based on the for the input file.
	 * 
	 * @param fileName
	 *            the name of the YAML data file.
	 * @throws IOException
	 */
	public NetflixYamlProvider(String fileName) throws IOException {
		
		super(fileName);
	}
	
	public NetflixYamlProvider(String fileName, String yamlSubstitutedContent) throws IOException, URISyntaxException {
		
		super(fileName,yamlSubstitutedContent);
	}

	/**
	 * @param testMethodName
	 * 			
	 * @return
	 * 		Returns the list of GiftCardTestData from the YAML file that matches with the test method name.
	 */
/*	public List<NetflixTestData> getNetflixTestData(String testMethodName) {
		
		List<NetflixTestData> gctsTestDataList = new LinkedList<NetflixTestData>();;
		for (Object yamlObject : allObjects) {
			
			NetflixTestData tempGCTSTestData = (NetflixTestData) yamlObject;
			if(StringUtils.equalsIgnoreCase(testMethodName, tempGCTSTestData.getTestObject().getTestMethod())) {
				
				gctsTestDataList.add(tempGCTSTestData);
			}
		}
		return gctsTestDataList;
	}*/
	
	public List<NetflixTestData> getNetflixTestData() {
		
		List<NetflixTestData> netflixTestDataList = new LinkedList<NetflixTestData>();;
		for (Object yamlObject : allObjects) {
			
			NetflixTestData tempNetflixTestData = (NetflixTestData) yamlObject;
			netflixTestDataList.add(tempNetflixTestData);

		}
		return netflixTestDataList;
	}
	
	/**
	 * Returns an iterator of GiftCardTestData from the YAML file that matches with the test method name.
	 * 
	 * This is to serve the purpose of @dataProvider concept in TestNG.
	 * 
	 * @param testMethod
	 * 			Test 'Method'(java.lang.reflect.Method).
	 * @param yamlFilePath
	 * 			Path to the YAML file (e.g., xxx/yyy/zzz/TestYAML.yaml).
	 * @return
	 * 			An iterator of GiftCardTestData from the YAML file that matches with the test method name.
	 * @throws Exception
	 */
	public static Iterator<Object[]> getNetflixTestData(Method testMethod, String yamlFilePath) throws Exception {
		
		NetflixYamlProvider netflixYAMLDataProvider = new NetflixYamlProvider(yamlFilePath);
		List<NetflixTestData> netflixTestDataList = netflixYAMLDataProvider.getNetflixTestData();
		
        List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
        for (NetflixTestData gctsTestData : netflixTestDataList) {
        	
            dataToBeReturned.add(new Object[] { gctsTestData } );
        }
		return dataToBeReturned.iterator();
	}
	
	/**
	 * Returns an iterator of GiftCardTestData from the YAML file that matches with the test method name.
	 * 
	 * This is to serve the purpose of @dataProvider concept in TestNG.
	 * 
	 * @param testMethod
	 * 			Test 'Method'(java.lang.reflect.Method).
	 * @param originalFilePath
	 * 			Path to the YAML file (e.g., xxx/yyy/zzz/TestYAML.yaml).
	 * @param configFile
	 *          configFile which contains the site specific parameters which is used during substitution
	 * @return
	 * 			An iterator of GiftCardTestData from the YAML file that matches with the test method name.
	 * @throws Exception
	 */
/*	public static Iterator<Object[]> getGiftCardTestData(Method testMethod, String originalFilePath, String configFile) throws Exception {
        GCTSTestDataUtil giftCardTestDataUtil= new GCTSTestDataUtil();
        String yamlSubstitutedContent=giftCardTestDataUtil.substituteValue(originalFilePath, configFile);
        GCTSYamlDataProvider giftcardYAMLDataProvider = new GCTSYamlDataProvider(originalFilePath,yamlSubstitutedContent );
        List<GCTSTestData> GiftCardTestDataList = giftcardYAMLDataProvider.getGCTSTestData(testMethod.getName());
		
        List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
        for (GCTSTestData gctsTestData : GiftCardTestDataList) {

            dataToBeReturned.add(new Object[] { gctsTestData } );

        }
		return dataToBeReturned.iterator();
	}*/
}
