package Demo7;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;

public class FileDemo {
	//private static String filePath = "."; 			// . 代表当前的根目录
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser(new File(".")); 	//设置文件对话框的打开时的根目录
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.showOpenDialog(null);								//显示文件的选择对话框
		File file = fileChooser.getSelectedFile();						//获得用户选择的文件
		if(file == null) {
			//判断用户选择的文件是否为空
			System.out.println("用户未选择任何文件，系统强制退出");
			System.exit(0);
		}
		
		//File file = new File(filePath);
		System.out.println("文件的绝对路径：" + file.getAbsoluteFile());
		System.out.println("路径" + file.getPath());
		System.out.println("文件的大小：" + file.length() / 1024 + "KB");
		System.out.println("文件是不是存在" + file.exists() + "\t是否是文件：" + file.isFile());
		System.out.println("文件夹是否存在：" + file.isDirectory());
		
		//列出当前目录下所有文件/文件夹
		if(file.isDirectory()) {
			System.out.println(file.getAbsolutePath() + "路径下的所有文件/文件夹");
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
