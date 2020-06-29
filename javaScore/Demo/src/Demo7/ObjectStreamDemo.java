package Demo7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 实现对象的序列化和反序列化
 * @author 小风筝
 *
 */
public class ObjectStreamDemo {
	
	private static String FilePath = "src/Demo7/Lyrice.sav";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Player play1 = new Player("刘备在加油", 100);
		
		//使用对象流将序列化写入到文件中
		FileOutputStream FOutStream = new FileOutputStream(FilePath);
		ObjectOutputStream ObjOutStram = new ObjectOutputStream(FOutStream);
		ObjOutStram.writeObject(play1);
		
		ObjOutStram.close();
		FOutStream.close();
		System.out.println("文件写入成功！");
		
		//从文件中读取对象，转换可操作的对象 
		FileInputStream in = new FileInputStream(FilePath);
		ObjectInputStream oIn = new ObjectInputStream(in);
		Player p2 = (Player)oIn.readObject();
		System.out.println("读取出文件内容：" + p2);
		System.out.println(play1 == p2);   			//比较文件的地址(false)
		oIn.close();
		in.close();
	}

}

class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7399876561438149102L;
	private String nickName;
	private int level;
	
	public Player() {}
	public Player(String nickName, int level) {
		setnickName(nickName);
		setLevel(level);
	}
	@Override
	public String toString() {
		
		return nickName + "\t" + level;
	
	}
	
	
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getnickName() {
		return nickName;
	}
	public void setnickName(String nickName) {
		this.nickName= nickName;
	}
}