//package demo1;
//
//import javax.swing.JOptionPane;
//
///**
// * ��Ʒ������
// * */
//public class ProductBiz {
//	public static void main(String[] args) {
//		int[] counts = new int[3];
//		double total = 0;
//		//�����������
//		Product[] products = new Product[3]; 
//		
//		for (int i = 0; i < counts.length; i++) {
//			//���´�������
//			products[i] = new Product();
//			
//			//Product product = new Product();
//			String name = JOptionPane.showInputDialog("��������Ʒ���ƣ�");
//			products[i].setName(name);
//			//ע�ⷵ��ֵ���ַ�������
//			String strPrice = JOptionPane.showInputDialog("��������Ʒ���ۣ�");
//			products[i].setPrice(Double.parseDouble(strPrice));
//			//��Ʒ������
//			String strCount = JOptionPane.showInputDialog("��������Ʒ��������");
//			counts[i] = Integer.parseInt(strCount);
//			//�����ܼ�
//			total += products[i].getPrice() * counts[i];
//			
//		}
//		//JOptionPane.showConfirmDialog(null, "�ܼ�"+ total, "�ܼ�" , 0);
//		for (int i = 0; i < products.length; i++) {
//			System.out.println(products[i].getName() + "\t" + products[i].getPrice());
//		}
//		
//		System.out.println("��Ʒ���ܼ۸�" + total);
//	}
//}
// 