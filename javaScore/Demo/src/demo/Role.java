package demo;

import java.util.logging.Level;

public class Role {
		public String name;
		public int level;
		public String job;
		//Ĭ�Ϲ���
		public Role() {}
		//���ι���
		public Role(String name,int level,String job) {
			this.name = name;
			this.level = level;
			this.job = job;
		}
		
		
		public void doSkill() {
			if(name.equals("����")) {
				System.out.println("�����ļ��ܣ�");
			}else if(name.equals("�����")) {
				System.out.println("����յļ��ܣ�");
			}else {
				System.out.println("��������ļ��ܣ�");
			}
		}
		public void show()
		{
			System.out.println(name + "\t" + level + "\t" + job);
		}
}
