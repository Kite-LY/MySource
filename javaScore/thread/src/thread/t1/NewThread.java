package thread.t1;

public class NewThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	//System.out.println("线程运行了。。。");
		while(true) {
			System.out.println("自定义线程执行了。。");
			try {
				Thread.sleep(100);			//线程的超时等待状态，时间到了进入就绪状态
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new NewThread());	//创建了线程，并执行了它
		thread.start();
		
		while(true) {
			System.out.println("主线程执行。。。");
			try {
				Thread.sleep(100);			//线程的超时等待状态
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
		}
	}
}
