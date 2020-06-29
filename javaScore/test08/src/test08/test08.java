package test08;

public class test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建对象
		DebitAcount da = new DebitAcount();
		//赋值
		da.setActno("001");
		
		//读取 间接访问
		System.out.println(da.getActno());
		da.getActno();
	}

}
