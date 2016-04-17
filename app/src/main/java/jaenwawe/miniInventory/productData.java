package jaenwawe.miniInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductData {

	List<Map<String,?>>productList;

	public List<Map<String, ?>> getProductList() {
		return productList;
	}

	public int getSize(){
		return productList.size();
	}

	public HashMap getItem(int i){
		if (i >=0 && i < productList.size()){
			return (HashMap) productList.get(i);
		} else return null;
	}

	public ProductData(){
		String productName;
		double price;
		int unitsAvailable;
		int targetNumber;
		String weight;
		String aisn;
		String description;
		String url;
		productList = new ArrayList<Map<String,?>>();


		aisn = "B00HQWLHJ8";
		weight = ".8 ounces";
		price = 17.99;
		productName = "8GB Flash Drive";
		url ="http://ecx.images-amazon.com/images/I/91UObPaaomL._SL1500_.jpg";
		description = "set of 10 - Enfain Bulk 8GB USB 2.0 Flash Drive";
		productList.add(createProduct(productName, R.drawable.usb, description, aisn, weight, price,url));

		aisn = "B0044W4HWW";
		weight = "16 ounces";
		price = 7.03;
		productName = "Trident Sugar Free Gum, Spearmint";
		url ="http://ecx.images-amazon.com/images/I/51IGRrVKnML.SX334_SY500_CR,0,0,334,500_PIbundle-12,TopRight,0,0_SX334_SY500_CR,0,0,334,500_SH20_.jpg";
		description = "Trident Sugar Free Gum, Spearmint,18-Count (Pack of 12).";
		productList.add(createProduct(productName, R.drawable.gum, description, aisn, weight, price,url));

		aisn = "B000YPKODY";
		weight = "3.4 pounds";
		price = 17.98;
		productName = "Cracker Jack";
		url ="http://ecx.images-amazon.com/images/I/91QF3Jtm7CL._SY550SX251_SY550_CR,0,0,251,550_PIbundle-25,TopRight,0,0_SX251_SY550_CR,0,0,251,550_SH20_.jpg";
		description = "Cracker Jack Original Singles, 1-Ounce Boxes (Pack of 25)";
		productList.add(createProduct(productName, R.drawable.popcorn, description, aisn, weight, price,url));

		aisn = "B00HQWLHJ8";
		weight = ".8 ounces";
		price = 17.99;
		productName = "8GB Flash Drive";
		url ="http://ecx.images-amazon.com/images/I/91UObPaaomL._SL1500_.jpg";
		description = "set of 10 - Enfain Bulk 8GB USB 2.0 Flash Drive";
		productList.add(createProduct(productName, R.drawable.usb, description, aisn, weight, price,url));

		aisn = "B0044W4HWW";
		weight = "16 ounces";
		price = 7.03;
		productName = "Trident Sugar Free Gum, Spearmint";
		url ="http://ecx.images-amazon.com/images/I/51IGRrVKnML.SX334_SY500_CR,0,0,334,500_PIbundle-12,TopRight,0,0_SX334_SY500_CR,0,0,334,500_SH20_.jpg";
		description = "Trident Sugar Free Gum, Spearmint,18-Count (Pack of 12).";
		productList.add(createProduct(productName, R.drawable.gum, description, aisn, weight, price,url));

		aisn = "B000YPKODY";
		weight = "3.4 pounds";
		price = 17.98;
		productName = "Cracker Jack";
		url ="http://ecx.images-amazon.com/images/I/91QF3Jtm7CL._SY550SX251_SY550_CR,0,0,251,550_PIbundle-25,TopRight,0,0_SX251_SY550_CR,0,0,251,550_SH20_.jpg";
		description = "Cracker Jack Original Singles, 1-Ounce Boxes (Pack of 25)";
		productList.add(createProduct(productName, R.drawable.avengers, description, aisn, weight, price,url));



		aisn = "B00HQWLHJ8";
		weight = ".8 ounces";
		price = 17.99;
		productName = "8GB Flash Drive";
		url ="http://ecx.images-amazon.com/images/I/91UObPaaomL._SL1500_.jpg";
		description = "set of 10 - Enfain Bulk 8GB USB 2.0 Flash Drive";
		productList.add(createProduct(productName, R.drawable.usb, description, aisn, weight, price,url));

		aisn = "B0044W4HWW";
		weight = "16 ounces";
		price = 7.03;
		productName = "Trident Sugar Free Gum, Spearmint";
		url ="http://ecx.images-amazon.com/images/I/51IGRrVKnML.SX334_SY500_CR,0,0,334,500_PIbundle-12,TopRight,0,0_SX334_SY500_CR,0,0,334,500_SH20_.jpg";
		description = "Trident Sugar Free Gum, Spearmint,18-Count (Pack of 12).";
		productList.add(createProduct(productName, R.drawable.gum, description, aisn, weight, price,url));

		aisn = "B000YPKODY";
		weight = "3.4 pounds";
		price = 17.98;
		productName = "Cracker Jack";
		url ="http://ecx.images-amazon.com/images/I/91QF3Jtm7CL._SY550SX251_SY550_CR,0,0,251,550_PIbundle-25,TopRight,0,0_SX251_SY550_CR,0,0,251,550_SH20_.jpg";
		description = "Cracker Jack Original Singles, 1-Ounce Boxes (Pack of 25)";
		productList.add(createProduct(productName, R.drawable.avengers, description, aisn, weight, price,url));

		aisn = "B00HQWLHJ8";
		weight = ".8 ounces";
		price = 17.99;
		productName = "8GB Flash Drive";
		url ="http://ecx.images-amazon.com/images/I/91UObPaaomL._SL1500_.jpg";
		description = "set of 10 - Enfain Bulk 8GB USB 2.0 Flash Drive";
		productList.add(createProduct(productName, R.drawable.usb, description, aisn, weight, price,url));

		aisn = "B0044W4HWW";
		weight = "16 ounces";
		price = 7.03;
		productName = "Trident Sugar Free Gum, Spearmint";
		url ="http://ecx.images-amazon.com/images/I/51IGRrVKnML.SX334_SY500_CR,0,0,334,500_PIbundle-12,TopRight,0,0_SX334_SY500_CR,0,0,334,500_SH20_.jpg";
		description = "Trident Sugar Free Gum, Spearmint,18-Count (Pack of 12).";
		productList.add(createProduct(productName, R.drawable.gum, description, aisn, weight, price,url));

		aisn = "B000YPKODY";
		weight = "3.4 pounds";
		price = 17.98;
		productName = "Cracker Jack";
		url ="http://ecx.images-amazon.com/images/I/91QF3Jtm7CL._SY550SX251_SY550_CR,0,0,251,550_PIbundle-25,TopRight,0,0_SX251_SY550_CR,0,0,251,550_SH20_.jpg";
		description = "Cracker Jack Original Singles, 1-Ounce Boxes (Pack of 25)";
		productList.add(createProduct(productName, R.drawable.avengers, description, aisn, weight, price,url));



	}


	private HashMap createProduct(String name, int image, String description, String aisn,
								  String weight, double price, String url) {
		HashMap movie = new HashMap();
		movie.put("image",image);
		movie.put("name", name);
		movie.put("description", description);
		movie.put("AISN", aisn);
		movie.put("weight",weight);
		movie.put("price",price);
		movie.put("url", url);
		movie.put("selection",false);
		return movie;
	}

	public void addItem(int position) {

		HashMap item =  (HashMap) productList.get(position);
		HashMap cloned = (HashMap) item.clone();
		productList.add((position + 1), cloned);
	}
	public int findFirst(String query) {
		int i = productList.size();
		for(i = 0;  i <(productList.size()); i++) {
			String mData = (String) productList.get(i).get("name");
			if (mData.toLowerCase().contains(query.toLowerCase()))
				return i;
		}
		return i;
	}

}