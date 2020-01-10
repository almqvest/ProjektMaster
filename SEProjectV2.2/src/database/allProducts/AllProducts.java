package database.allProducts;

import java.util.ArrayList;

import database.shelf.Shelf;
import database.singleProduct.Product;

public class AllProducts { //The Class of the Full Database
	
	public ArrayList<Shelf> shelfs = new ArrayList<Shelf>(); //TODO change to private (use getter/setter)
	
	public AllProducts() {
		for (int ii=0; ii<999; ii++) {
			Shelf newShelf = new Shelf();
			shelfs.add(newShelf);
		}
		try{
			loadFile();
		} catch (Exception e) { 
			//TODO
		}
	}
	
	public void addProduct(int shelfNr, Product p) throws Exception{

		try{
			testNewProduct(p);// Test Syntax
			shelfs.get(shelfNr).addProduct(p);//Weight Tests in ShelfTests Class
			
		} catch (Exception e) {}
	}
	
	public void changeProduct(Product oldVersion, Product newVersion, int oldShelfNr, int newShelfNr) throws Exception {

		try {
			shelfs.get(oldShelfNr).removeProduct(oldVersion);
			addProduct(newShelfNr, newVersion);		
			} catch(Exception e) {throw e;}
	}
			
	
	
	private Boolean testNewProduct(Product p) throws Exception{
		//TODO
		return true;
	}
	
	public void saveFile() {
		//TODO
	}
	
	private void loadFile() throws Exception {
		//TODO
	}
	
	
	
	
	
	
	/*public void save() {				
		// for testing
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			FileWriter writer = new FileWriter(formatter.format(new Date()));
			// save to specific file
			//FileWriter writer = new FileWriter("specificfile");
			for (Product p : data) {
				writer.write(p.getDescription() + "\n");
				writer.write(p.getCategory() + "\n");
				writer.write(p.getQuantity() + "\n");
				writer.write(p.getWeight() + "\n");
				writer.write(p.getPrice() + "\n");
				writer.write(p.getStockNumber() + "\n");
			}
			writer.close();
		}
		catch (IOException e) {
			System.out.println("got it:\n" + e.getMessage());
		}	
	} //save*/
}
