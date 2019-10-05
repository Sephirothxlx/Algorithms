package algorithm;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;

public class JsonToDom {
	public static void convert() {
		try {
			JSONObject json=new JSONObject("{\"a\":{\"b\":2}}");
			System.out.println(json.get("a") instanceof JSONObject);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args) {
		convert();
	}
}
