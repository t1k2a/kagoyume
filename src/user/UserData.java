package user;

import java.sql.Timestamp;
import java.util.ArrayList;

import kagoyume.productDataBeans;

public class UserData {
	 ArrayList<productDataBeans> mycart = new ArrayList<productDataBeans>();

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


    public UserData(){
    this.userID = 0;
    this.name = "";
    this.password = "";
    this.mailaddress = "";
    this.address = "";
    this.totalPrice = 0;
    this.deleteFlg = 0;
    this.buyID = 0;
    this.itemcode = "";
    this.type = 0;
 }

    //getter,setterの設定
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
		if(name.trim().length()==0){
		    this.name = "";
		    }else{
		        this.name = name;
		    }
   }

   public String getPassword() {
        return password;
    }
   public void setPassword(String name) {
        if(name.trim().length()==0){
            this.password = "";
        }else{
            this.password = name;
        }
    }

   public String getMailaddress() {
        return mailaddress;
    }
   public void setMailaddress(String name) {

	   if(name.trim().length()==0){
            this.mailaddress = "";
        }else{
            this.mailaddress = name;
        }
    }

   public String getAddress() {
        return address;
    }
   public void setAddress(String adress) {

	   if(adress.trim().length()==0){
            this.address = "";
        }else{
            this.address = adress;
        }
    }

       public Timestamp getNewDate(){
        return newDate;
    }
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }

    public int gettotalPrice(){
        return totalPrice;
    }
    public void settotalPrice(int totalPrice){
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

    public ArrayList<productDataBeans> getCart(){
    	return mycart;
    }
    public void setCart(ArrayList<productDataBeans> mycart) {
    	this.mycart = mycart;
    }

    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.password.equals("")){
            chkList.add("password");
        }
        if(this.mailaddress.equals("")){
            chkList.add("mailaddress");
        }
        if(this.address.equals("")){
            chkList.add("address");
        }
        return chkList;
    }



    //データベースにアクセスするためにDTO型に変換するメソッド
    public void UD2DTOMapping(UserDataDTO udd){
        udd.setUserID(this.userID);
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMailaddress(this.mailaddress);
        udd.setAddress(this.address);
        udd.setTotalPrice(this.totalPrice);
        udd.setDeleteFlg(this.deleteFlg);
        udd.setBuyID(this.buyID);
        udd.setItemcode(this.itemcode);
        udd.setType(this.type);

    }

    //データベースから取り出したDTO型のデータを利用するために変換するメソッド
    public void DTO2UDMapping(UserDataDTO udd){
       this.setUserID(udd.getUserID());
       this.setName(udd.getName());
       this.setPassword(udd.getPassword());
       this.setMailaddress(udd.getMailaddress());
       this.setAddress(udd.getAddress());
       this.settotalPrice(udd.getTotalPrice());
       this.setNewDate(udd.getNewDate());
       this.setDeleteFlg(udd.getDeleteFlg());
    }

}
