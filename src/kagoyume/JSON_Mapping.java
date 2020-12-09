package kagoyume;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON_Mapping {
	public static JsonNode getResult(String urlString) {
		String result = "";
		JsonNode root = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.connect(); // URL接続
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); // 接続した際に帰ってきたデータを読み込み
			String tmp = "";
			while ((tmp = in.readLine()) != null) { // 一行ずつ読み込む
				result += tmp;
			}
			ObjectMapper mapper = new ObjectMapper();
			root = mapper.readTree(result);
			in.close();
			con.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return root;
	}

//	public static JsonNode getJsonNode(String jsonString) {
//		JsonNode head = null;
//		try {
//			JsonFactory jfactory = new JsonFactory();
//			JsonParser parser = jfactory.createParser(jsonString);
//			ObjectMapper mapper = new ObjectMapper();
//			head = mapper.readTree(parser);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return head;
//	}

}
