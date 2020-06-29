package CalcMoney;
/**
 * 淘宝交易额开始800亿 每年增长25% 啥时到达2000亿
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
		System.out.println(year + "年，交易额为2000亿以上（" + money + "亿元+）");
		
	}

}
