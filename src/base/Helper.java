package base;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class Helper {
	public static Helper getInstance() {
		return new Helper();
	}

	private final String homeURL = "top.jsp";
	private final String loginURL = "Login";
	private final String cartURL = "Cart";

	public String home() {
		return "<a href=\""+homeURL+"\">トップへ戻る</a>";
	}

	public String login() {
		return 	"<a href=\""+loginURL+"\">ログイン</a>";
	}

	public String cart() {
		return "<a href=\""+cartURL+"\">カート一覧</a>";
	}

    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("password")){
                    output += "パスワード";
                }
                if(val.equals("mailaddress")){
                    output += "メールアドレス";
                }
                if(val.equals("address")){
                    output += "住所";
                }

                output +="が未記入です。<br>";
            }
        return output;
    }

	public String exTypeNum(int i) {
		String type = "";

		switch(i) {
			case 1:
				type = "郵送";
				break;
			case 2:
				type = "コンビニ受け取り";
				break;
			default:
				type = "その他";
				break;
		}

		return type;
	}

	public String getName(JsonNode jsonnode, int code) {
		return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(code)).get("Name").textValue());
	}

	public int getTotalresult(JsonNode jsonnode) {
		return Integer.parseInt(String.valueOf(jsonnode.get("ResultSet").get("totalResultsAvailable").textValue()));
	}

	public String getImage(JsonNode jsonnode, int code) {
		return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(code)).get("Image").get("Medium").textValue());
	}

	public int getPrice(JsonNode jsonnode, int code) {
        return Integer.parseInt(String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(code)).get("Price").get("_value").textValue()));
	}

	public String getDescription(JsonNode jsonnode, int code) {
		return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(code)).get("Description").textValue());
	}

	public double getReview(JsonNode jsonnode, int code) {
		return Double.parseDouble(String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(code)).get("Review").get("Rate").textValue()));
	}

	public String getCode(JsonNode jsonnode, int code) {
		return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(code)).get("Code").textValue());
	}

	public String getItemName(JsonNode jsonnode) {
		return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get("0").get("Name").textValue());
	}

	public int getItemPrice(JsonNode jsonnode) {
        return Integer.parseInt(String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get("0").get("Price").get("_value").textValue()));
	}

	public int getItemTotalresult(JsonNode jsonnode) {
		return Integer.parseInt(String.valueOf(jsonnode.get("ResultSet").get("totalResultsAvailable").textValue()));
	}

	public String getItemImage(JsonNode jsonnode) {
		System.out.println(String.valueOf(jsonnode.get("ResultSet").get("0")));
		return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get("0").get("Image").get("Small").textValue());
	}

	public String getItemDescription(JsonNode jsonnode) {
		System.out.println(jsonnode);
		return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get("0").get("Description").textValue());
	}

	public double getItemReview(JsonNode jsonnode) {
		System.out.println(String.valueOf(jsonnode));
		return Double.parseDouble(String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get("0").get("Review").get("Rate").textValue()));
	}

	public String getItemCode(JsonNode jsonnode) {
		return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get("ItemCode").get("0").get("Code").textValue());
	}
}
