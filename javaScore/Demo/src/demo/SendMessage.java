package demo;

public class SendMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SendMessage("����", "����Ƶ��", "���Ŵ��", 3, 1);
		
		//�������ع���
		SendMessage("�ŷ�");
	}
	/**
	 * ���ع������ܣ�
	 * @param nicName
	 */
	
	public static void SendMessage(String nicName) {
		String[] contents = {
				"�������Ǵ�ҵģ�",
				"�ܸ��������㣡",
				"������"
		};
		SendMessage(nicName, "Ĭ��Ƶ��", contents[(int)(Math.random() * 2)], 3, 1);
	}
	
	
	/**
	 * 
	 * @param name
	 * @param channelName		����Ƶ��
	 * @param message
	 * @param count				��������
	 * @param interval			�������
	 */
	public static void SendMessage(String name, String channelName, String message, int count, int interval) {
		String value = String.format("[%s]%s:%s", 
				channelName,name, message
			);
		for(int i =0; i < count; i++) {
			System.err.println(value);
			try {
				Thread.sleep(interval * 1000); //���߶�����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
	
	

}
