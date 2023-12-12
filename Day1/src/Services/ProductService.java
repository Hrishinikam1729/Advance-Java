package Services;

import java.util.List;

import Beans.Product;

public interface ProductService {

	List<Product> displayAll();

	Product displayById(int id);

	boolean removeById(int rid);

	boolean addProduct(int pid, String pname, int qty, double price);

	List<Product> displaySorted();

	boolean modifyById(int id);

	void closeMyConnection();

	

	
	
	

}
