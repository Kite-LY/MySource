package demo;
//�������
public class HumComPlayer2 {
	
	/** ��̬����: ��ȭ��Ϣ*/
	public static final int MeeageTypeFist = 1;
	/** ��̬����: Ӯ����Ϣ*/
	public static final int MeeageTypeWin = 2;
	/** ��̬����: �����Ϣ*/
	public static final int MeeageTypelose = 3;
	
	
	private String name;
	private int fist;
	private int score;
	
	private String[] fistWords = {
			" --- ���йⲨ...biubiu",
			" --- ��ɱ����",
			" --- ������ϲ�����ཷ��",
			" --- ŷ�ͳ���һȭ��"
	};
	
	private String[] winWords = {
			" --- ����˭��",
			" --- ��ȭ�����е���˼��ż��",
			" --- ����  ����Ӯ��",
			" --- Ϊɶ���ҵ�������ô�õ���"
	};
	
	private String[] loseWords = {
			" --- ͨ���ɹ���·������ʩ��",
			" --- ʧ����ʱ�ɹ�֮ĸ����",
			" --- �һ�̶ˮ��ǧ�ߣ���������������",
			" --- Ȱ������һ���ƣ����������޹���"
	};

	/**
	 *���ݴ�������ݣ������ӡ�������� 
	 * @param msgType  ���������
	 */
	  
	public void sendMessage(int msgType) {
		String message = null;
		int index = (int)(Math.random() * 1000) % 4 ;		//ȡһ��0 �� 3 ֮�����
		switch (msgType) {
		case MeeageTypeFist:      //������int 1
			message =  fistWords[index];
			break;
		case MeeageTypeWin:
			message = winWords[index];
			break;
		case MeeageTypelose:
			message = loseWords[index];
		}
		System.out.println(message);
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFist() {
		//���������ȭ,����1-3 ���������
		fist = ((int)(Math.random() * 1000)) % 3 + 1;
		return fist;
	}

//	public void setFist(int fist) {
//		this.fist = fist;
//	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
