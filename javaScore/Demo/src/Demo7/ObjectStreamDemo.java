package Demo7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ʵ�ֶ�������л��ͷ����л�
 * @author С����
 *
 */
public class ObjectStreamDemo {
	
	private static String FilePath = "src/Demo7/Lyrice.sav";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Player play1 = new Player("�����ڼ���", 100);
		
		//ʹ�ö����������л�д�뵽�ļ���
		FileOutputStream FOutStream = new FileOutputStream(FilePath);
		ObjectOutputStream ObjOutStram = new ObjectOutputStream(FOutStream);
		ObjOutStram.writeObject(play1);
		
		ObjOutStram.close();
		FOutStream.close();
		System.out.println("�ļ�д��ɹ���");
		
		//���ļ��ж�ȡ����ת���ɲ����Ķ��� 
		FileInputStream in = new FileInputStream(FilePath);
		ObjectInputStream oIn = new ObjectInputStream(in);
		Player p2 = (Player)oIn.readObject();
		System.out.println("��ȡ���ļ����ݣ�" + p2);
		System.out.println(play1 == p2);   			//�Ƚ��ļ��ĵ�ַ(false)
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