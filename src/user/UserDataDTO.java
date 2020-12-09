package user;

import java.sql.Timestamp;

public class UserDataDTO {
	// 共通して使用する
	private int userID;

	// ユーザー情報で使用する
    private String name;
    private String password;
    private String mailaddress;
    private String address;
    private Timestamp newDate;
    private int totalPrice;
    private int deleteFlg;

    //商品購入で使用する
    private int buyID;
    private String itemcode;
    private int type;
    private Timestamp buyDate;

    public UserDataDTO(){
	    name = "";
	    password = "";
	    mailaddress = "";
	    address = "";
	    totalPrice=0;
	}

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailaddress() {
        return mailaddress;
    }
    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public Timestamp getNewDate(){
        return newDate;
    }
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }

    public int getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }

    public int getDeleteFlg(){
        return deleteFlg;
    }
    public void setDeleteFlg(int deleteFlg){
        this.deleteFlg = deleteFlg;
    }

    public int getBuyID(){
        return buyID;
    }
    public void setBuyID(int buyID){
        this.buyID = buyID;
    }

    public String getItemcode(){
        return itemcode;
    }
    public void setItemcode(String itemcode){
        this.itemcode = itemcode;
    }

    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }

    public Timestamp getBuyDate(){
        return buyDate;
    }
    public void setBuyDate(Timestamp buyDate){
        this.buyDate = buyDate;
    }
}
