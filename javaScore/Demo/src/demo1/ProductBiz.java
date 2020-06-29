//package demo1;
//
//import javax.swing.JOptionPane;
//
///**
// * 商品管理类
// * */
//public class ProductBiz {
//	public static void main(String[] args) {
//		int[] counts = new int[3];
//		double total = 0;
//		//创建数组对象
//		Product[] products = new Product[3]; 
//		
//		for (int i = 0; i < counts.length; i++) {
//			//重新创建对象
//			products[i] = new Product();
//			
//			//Product product = new Product();
//			String name = JOptionPane.showInputDialog("请输入商品名称：");
//			products[i].setName(name);
//			//注意返回值是字符串类型
//			String strPrice = JOptionPane.showInputDialog("请输入商品单价：");
//			products[i].setPrice(Double.parseDouble(strPrice));
//			//商品的数量
//			String strCount = JOptionPane.showInputDialog("请输入商品的数量：");
//			counts[i] = Integer.parseInt(strCount);
//			//计算总价
//			total += products[i].getPrice() * counts[i];
//			
//		}
//		//JOptionPane.showConfirmDialog(null, "总价"+ total, "总价" , 0);
//		for (int i = 0; i < products.length; i++) {
//			System.out.println(products[i].getName() + "\t" + products[i].getPrice());
//		}
//		
//		System.out.println("商品的总价格：" + total);
//	}
//}
// 