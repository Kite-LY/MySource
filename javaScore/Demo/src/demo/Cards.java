package demo;

public class Cards {

	public static void main(String[] args) {
		final int N = 52;
		int[] cards = new int[N];
		
		//����52����
		for (int i = 0; i < cards.length; i++) {
			cards[i] = i;			//�����ѭ��������ͬ��0 �� 51֮��
		}
		//��ӡϴ��ǰ
		//�ƵĻ�ɫ
		String[] colors = {"����", "����", "����", "÷��"};
		//����
		String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "", "K"};
		System.out.println("ϴ�ƺ�");
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
		//ϴ��
		for (int i = 0; i < cards.length; i++) {
			int newIndex = (int)(Math.random()*N);
			int temp = cards[i];
			cards[i] = cards[newIndex];
			cards[newIndex] = temp;
		}
		//�ƵĻ�ɫ
//		String[] colors = {"����", "����", "����", "÷��"};
//		//����
//		String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q",  "K"};
		System.out.println("ϴ�ƺ�");
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
