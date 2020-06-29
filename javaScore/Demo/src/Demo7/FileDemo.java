package Demo7;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;

public class FileDemo {
	//private static String filePath = "."; 			// . ����ǰ�ĸ�Ŀ¼
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser(new File(".")); 	//�����ļ��Ի���Ĵ�ʱ�ĸ�Ŀ¼
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.showOpenDialog(null);								//��ʾ�ļ���ѡ��Ի���
		File file = fileChooser.getSelectedFile();						//����û�ѡ����ļ�
		if(file == null) {
			//�ж��û�ѡ����ļ��Ƿ�Ϊ��
			System.out.println("�û�δѡ���κ��ļ���ϵͳǿ���˳�");
			System.exit(0);
		}
		
		//File file = new File(filePath);
		System.out.println("�ļ��ľ���·����" + file.getAbsoluteFile());
		System.out.println("·��" + file.getPath());
		System.out.println("�ļ��Ĵ�С��" + file.length() / 1024 + "KB");
		System.out.println("�ļ��ǲ��Ǵ���" + file.exists() + "\t�Ƿ����ļ���" + file.isFile());
		System.out.println("�ļ����Ƿ���ڣ�" + file.isDirectory());
		
		//�г���ǰĿ¼�������ļ�/�ļ���
		if(file.isDirectory()) {
			System.out.println(file.getAbsolutePath() + "·���µ������ļ�/�ļ���");
			String[] fileName = file.list(new DirFilter());
			for (int i = 0; i < fileName.length; i++) {
				System.out.println(fileName[i]);
			}
		}
		

		
	}
	
	
	static class DirFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			
		if(name.endsWith("bin") || name.endsWith("src")) {
			return true;
		}
			return true;
		}
		
	}
}
