package demo;

public class SendMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SendMessage("刘备", "世界频道", "组团打怪", 3, 1);
		
		//调用重载构造
		SendMessage("张飞");
	}
	/**
	 * 重载哈话功能！
	 * @param nicName
	 */
	
	public static void SendMessage(String nicName) {
		String[] contents = {
				"世界我们大家的！",
				"很高兴遇见你！",
				"你吃了嘛？"
		};
		SendMessage(nicName, "默认频道", contents[(int)(Math.random() * 2)], 3, 1);
	}
	
	
	/**
	 * 
	 * @param name
	 * @param channelName		喊话频道
	 * @param message
	 * @param count				喊话次数
	 * @param interval			喊话间隔
	 */
	public static void SendMessage(String name, String channelName, String message, int count, int interval) {
		String value = String.format("[%s]%s:%s", 
				channelName,name, message
			);
		for(int i =0; i < count; i++) {
			System.err.println(value);
			try {
				Thread.sleep(interval * 1000); //休眠多少秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
	
	

}
