package thread.t1;

public class NewThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	//System.out.println("�߳������ˡ�����");
		while(true) {
			System.out.println("�Զ����߳�ִ���ˡ���");
			try {
				Thread.sleep(100);			//�̵߳ĳ�ʱ�ȴ�״̬��ʱ�䵽�˽������״̬
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new NewThread());	//�������̣߳���ִ������
		thread.start();
		
		while(true) {
			System.out.println("���߳�ִ�С�����");
			try {
				Thread.sleep(100);			//�̵߳ĳ�ʱ�ȴ�״̬
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
		}
	}
}
