package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Beans.Product;

public class ProductDaoImpl implements ProductDao {
    private static Connection conn;
    private static PreparedStatement selectAll, displaybyId, removeByID, addProduct, displaySorted, modifyById;

    static {
        try {
            conn = DBUtil.getMyConnection();
            selectAll = conn.prepareStatement("select * from product");
            displaybyId = conn.prepareStatement("select * from product where pid=?");
            removeByID = conn.prepareStatement("delete from product where pid=?");
            addProduct = conn.prepareStatement("insert into product values(?,?,?,?)");
            displaySorted = conn.prepareStatement("select * from product order by price");
            modifyById = conn.prepareStatement("update product set pnm =?,qty=?,price=? where pid=?");
        } catch (SQLException e) {
            // Handle the exception appropriately (e.g., log or rethrow)
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> plist = new ArrayList<>();

        try (ResultSet rs = selectAll.executeQuery()) {
            while (rs.next()) {
                plist.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            // Handle the exception appropriately (e.g., log or rethrow)
            e.printStackTrace();
        }

        return plist;
    }

	@Override
	public Product displaybyid(int id) {
		try {
			displaybyId.setInt(1, id);
			ResultSet rs = displaybyId.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean removeByid(int rid) {
		try {
			removeByID.setInt(1, rid);
			int rs = removeByID.executeUpdate();
			if(rs>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean addproduct(int pid, String pname, int qty, double price) {
		try {
			addProduct.setInt(1, pid);
			addProduct.setString(2, pname);
			addProduct.setInt(3, qty);
			addProduct.setDouble(4, price);
			int n1 = addProduct.executeUpdate();
			
			if(n1>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Product> displaySorted() {
		List<Product> plist2 = new ArrayList<>();
		   
		try {
			ResultSet rs3 = displaySorted.executeQuery();
			while(rs3.next()) {
				plist2.add(new Product(rs3.getInt(1),rs3.getString(2),rs3.getInt(3),rs3.getDouble(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plist2;
	}

	@Override
	public boolean modifyById(int id) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter pname");
		String pname = sc.next();
		System.out.println("Enter Quantity");
		int quantity = sc.nextInt();
		System.out.println("Enter price");
		double price =  sc.nextDouble();
		try {
			modifyById.setString(1, pname);
			modifyById.setInt(2, quantity);
			modifyById.setDouble(3, price);
			modifyById.setInt(4, id);
			
			int ns = modifyById.executeUpdate();
			if(ns>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public void closeConnection() {
		DBUtil.closeMyConnection();
	}
}
