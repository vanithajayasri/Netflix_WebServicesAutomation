package rest.automation.netflix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.Yaml;


/**
 * DataProvider implementation for read data from the yaml files.
 */
public class BaseYAMLDataProvider {
	
	private Yaml yamlFile;
	private Reader reader;
	protected List<Object> allObjects;

	/**
	 * This is a public constructor to create an input stream & Yaml instance
	 * for the input file.
	 * 
	 * @param fileName
	 *            the name of the YAML data file.
	 * @throws IOException
	 */
	public BaseYAMLDataProvider(String fileName) throws IOException {

		InputStream input = null;
		try {
			input = getInputFileStream(fileName);
			if (input == null) {
				FileNotFoundException e = new FileNotFoundException("Resource "
						+ fileName + " not found");
				throw e;
			}
			reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
			yamlFile = new Yaml();

			allObjects = new ArrayList<Object>();
			Iterable<Object> it = yamlFile.loadAll(reader);
			for (Object temp : it) {
				allObjects.add(temp);
			}
			input.close();
			reader.close();
		} catch (FileNotFoundException fnfe) {
			System.err
					.println("YAML file didn't find in the path you specified."
							+ fnfe);
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (final IOException ioe) {
					System.err
							.println("Got the following exception while trying to clean up the reader: "
									+ ioe);
				}
			}
			if (null != input) {
				try {
					input.close();
				} catch (final IOException ioe) {
					System.err
							.println("Got the following exception while trying to clean up the inputStream: "
									+ ioe);
				}
			}
		}
	}
	
	/**
	 * This is a public constructor to create  Yaml instance
	 * for the input file.
	 * 
	 * @param fileName
	 *            the name of the YAML data file.
	 * @param 
	 *            the string with the substituted data content
	 * @throws IOException
	 */
	public BaseYAMLDataProvider(String fileName, String yamlSubstitutedContent) throws IOException {

		yamlFile = new Yaml();

		allObjects = new ArrayList<Object>();
		Iterable<Object> it = yamlFile.loadAll(yamlSubstitutedContent);
		for (Object temp : it) {
			allObjects.add(temp);
		}
	} 

	/**
	 * Returns the input stream based off the file name passed in
	 * 
	 * @param fileName
	 * @return
	 */
	private InputStream getInputFileStream(String fileName) {
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream inputStream = loader.getResourceAsStream(fileName);
		return inputStream;
	}
}
