package Demo7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	
	private static final String FilePath = "src/Demo7/Lyrice.sav";
	private static final String FilePath1 = "src/Demo7/LyriceCopy.txt";
	
	
	/**
	 * ʹ��RandomAccessFileʵ���ļ��ĸ���
	 */
	public static void CopyFile() {
		try(
			RandomAccessFile srcFile = new RandomAccessFile(new File(FilePath), "r");   //���Ƶ��ļ�
			RandomAccessFile newFile = new RandomAccessFile(new File(FilePath1), "rw");
			){
			//�����ļ�֮ǰ��Ҫ���newFile
			newFile.setLength(0);
			//���Ҫ�����ļ����ֽڴ�С
			long srcLeng = srcFile.length();
			//�����Լ����飬���ļ����� ��񼽨������
			byte[] bytes = new byte[(int)srcLeng];
			srcFile.read(bytes);
			//���ֽ�����д�����ļ���
			newFile.write(bytes);
			System.out.println("�ļ����Ƴɹ�");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException {

		CopyFile();
		
		
		
//		File file = new File(FilePath);
//		if(! file.exists()) {
//			file.createNewFile();			//����ļ������ڴ����µ��ļ�
//		}
//		try(RandomAccessFile rFlie = new RandomAccessFile(file, "rw")){
//			rFlie.setLength(0);					//ǿ�����ļ���С���� - �ȼ���ɾ���ļ��е���������
//			//д��20000����������
//			for(int i =0; i < 2000; i++) {
//				rFlie.write(i);
//			}
//			//��ȡ
//			System.out.println("��ǰ�ļ���С��" + rFlie.length());
//			//�ƶ��ʼ�ָ��
//			rFlie.seek( 4 * 8);
//			System.out.println("�ƶ�8�����ͣ�32���ֽ�)��ֵ��" + rFlie.readInt());
//			
//		}
//				
		
	}

}
