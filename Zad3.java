package Natiii;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Zad3 {
	public final static String DEPENDENCIES = "resource//dependencies.json";
	public final static String ALL_PACKAGES = "resource//all_packages.json";

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ParseException {

		JSONParser parser = new JSONParser();

		JSONObject depObj = (JSONObject) parser.parse(new FileReader(
				DEPENDENCIES));
		JSONObject packObj = (JSONObject) parser.parse(new FileReader(
				ALL_PACKAGES));
		JSONArray depArray = (JSONArray) depObj.get("dependencies");
		if (checkDependencies(packObj, depArray)) {
			System.out.println("Installation of dependencies done.");
		}
	}

	private static boolean checkDependencies(JSONObject packObj,
			JSONArray depArray) {
		for (Object i : depArray) {
			if (packObj.containsKey(i)) {
				System.out.println("Installing '" + i.toString() + "'.");
				JSONArray array = (JSONArray) packObj.get(i);
				if (array.size() > 0) {
					System.out.println("In order to install " + "'"
							+ i.toString() + "', we need " + array);
					checkDependencies(packObj, array);
				} else {
					System.out.println("Installation of '" + i.toString()
							+ "' done.");
				}
			}
		}
		return true;
	}
}
