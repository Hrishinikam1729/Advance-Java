package Test;

import java.util.List;
import java.util.Scanner;

import Beans.Product;
import Dao.DBUtil;
import Services.ProductService;
import Services.ProductServiceImpl;

public class Test {
		public static void main(String[] args) {
			ProductService pservice = new ProductServiceImpl(); 
			int choice = 0;
			Scanner sc = new Scanner(System.in);
			
			do {
				System.out.println("Select one of the options below :");
				System.out.println("1. Show Table\n2. Display By Id\n3. Remove By Id\n4. Add New Product\n5. Display in sorted order by price\n6. Modify product\n7. Exit : ");
				choice = sc.nextInt();
				switch(choice) {			
				case 1:
					List<Product> plist = pservice.displayAll();
					plist.forEach(System.out::println);
					break;
				case 2:
					System.out.println("Enter Id to display ");
					int id = sc.nextInt();
					Product pro = pservice.displayById(id);
					System.out.println(pro);
					break;
				case 3:
					System.out.println("Enter Id to remove ");
					int rid = sc.nextInt();
					boolean flag = pservice.removeById(rid);
					if(flag) {
						System.out.println("Removed Successfully");
					}else {
						System.out.println("Entry not found");
					}
					break;
				case 4:
					System.out.println("Enter Product Id");
					int pid = sc.nextInt();
					System.out.println("Enter Product name");
					String pname =sc.next();
					System.out.println("Enter Product quantity");
					int qty = sc.nextInt();
					System.out.println("Enter Product price");
					double price = sc.nextDouble();
					
					boolean flag1 = pservice.addProduct(pid,pname,qty,price);
					if(flag1) {
						System.out.println("Record Inserted successfully");
					}else {
						System.out.println("Not Inserted");
					}					
					break;
				case 5:
					List<Product> plist1 = pservice.displaySorted();
					plist1.forEach(System.out::println);
					break;
				case 6:
					System.out.println("Enter product id");
					int pid1 = sc.nextInt();
					boolean flag3 = pservice.modifyById(pid1);
					if(flag3) {
						System.out.println("Modified Successfully");
					}else {
						System.out.println("Not Modified");
					}
					break;
				case 7:
					sc.close();
					pservice.closeMyConnection();
					System.out.println("Thanks for visiting!!!");
					break;
				default:
					System.out.println("Wrong choice entered....");
				}
				
			}while(choice!=7);
		}
}
