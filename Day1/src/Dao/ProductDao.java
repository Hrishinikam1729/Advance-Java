package Dao;

import java.util.List;

import Beans.Product;

public interface ProductDao {

	List<Product> getAll();

	Product displaybyid(int id);

	boolean removeByid(int rid);

	boolean addproduct(int pid, String pname, int qty, double price);

	List<Product> displaySorted();

	boolean modifyById(int id);

	void closeConnection();

	

}
