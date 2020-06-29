package demo;

import java.util.logging.Level;

public class Role {
		public String name;
		public int level;
		public String job;
		//默认构造
		public Role() {}
		//带参构造
		public Role(String name,int level,String job) {
			this.name = name;
			this.level = level;
			this.job = job;
		}
		
		
		public void doSkill() {
			if(name.equals("劳拉")) {
				System.out.println("劳拉的技能！");
			}else if(name.equals("孙悟空")) {
				System.out.println("孙悟空的技能！");
			}else {
				System.out.println("其他人物的技能！");
			}
		}
		public void show()
		{
			System.out.println(name + "\t" + level + "\t" + job);
		}
}
