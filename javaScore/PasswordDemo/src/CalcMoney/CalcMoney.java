package CalcMoney;
/**
 * �Ա����׶ʼ800�� ÿ������25% ɶʱ����2000��
 * */
public class CalcMoney {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2015;
		double money = 800;
		while(money <= 2000) {
			year++;
			money *= 1.25;
		}
		System.out.println(year + "�꣬���׶�Ϊ2000�����ϣ�" + money + "��Ԫ+��");
		
	}

}
