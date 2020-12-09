package kagoyume;

import java.io.Serializable;

public class productDataBeans implements Serializable {
	private String productName;
	private String image;
	private String description;
	private String code;
	private double review;
	private int price;
	private int number;

	public productDataBeans(){
		productName  = "";
		image = "";
	    price = 0;
	    code = "";
	    description = "";
	    review = 0;
	    number = 0;
	}

    public String getProductName(){
        return this.productName;
    }
    public void setProductName(String name){
        this.productName = name;
    }

    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description ;
    }

    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }

    public double getReview(){
        return review;
    }
    public void setReview(double review){
        this.review = review;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int i){
        this.price = i;
    }

    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }

}
