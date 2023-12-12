package Services;

import java.util.List;

import Beans.Product;
import Dao.ProductDao;
import Dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	ProductDao pdao = new ProductDaoImpl();
	@Override
	public List<Product> displayAll() {
			return pdao.getAll();
	}
	@Override
	public Product displayById(int id) {
		return pdao.displaybyid(id);
	}
	@Override
	public boolean removeById(int rid) {
		return pdao.removeByid(rid);
	}
	@Override
	public boolean addProduct(int pid, String pname, int qty, double price) {
		return pdao.addproduct(pid,pname,qty,price);
	}
	@Override
	public List<Product> displaySorted() {
		// TODO Auto-generated method stub
		return pdao.displaySorted();
	}
	@Override
	public boolean modifyById(int id) {
		// TODO Auto-generated method stub
		return pdao.modifyById(id);
	}
	@Override
	public void closeMyConnection() {
		pdao.closeConnection();		
	}

}
