package demo;

public class Cards {

	public static void main(String[] args) {
		final int N = 52;
		int[] cards = new int[N];
		
		//生成52张牌
		for (int i = 0; i < cards.length; i++) {
			cards[i] = i;			//牌面和循环变量相同，0 到 51之间
		}
		//打印洗牌前
		//牌的花色
		String[] colors = {"红桃", "黑桃", "方块", "梅花"};
		//牌面
		String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "", "K"};
		System.out.println("洗牌后：");
		for (int i = 0; i < cards.length; i++) {
			System.out.print(colors[cards[i] / 13] + "-" + values[cards[i] % 13]);
			if((i + 1) % 13 == 0)
			{
				System.out.println();
			}
			else {
				System.out.print('\t');
			}
		}
		//洗牌
		for (int i = 0; i < cards.length; i++) {
			int newIndex = (int)(Math.random()*N);
			int temp = cards[i];
			cards[i] = cards[newIndex];
			cards[newIndex] = temp;
		}
		//牌的花色
//		String[] colors = {"红桃", "黑桃", "方块", "梅花"};
//		//牌面
//		String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q",  "K"};
		System.out.println("洗牌后：");
		for (int i = 0; i < cards.length; i++) {
			System.out.print(colors[cards[i] / 13] + "-" + values[cards[i] % 13]);
			if((i + 1) % 13 == 0)
			{
				System.out.println();
			}
			else {
				System.out.print('\t');
			}
		}
		
	}

}
