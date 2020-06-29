package test03;


/** this 保存内存地址并指向自生*/

class myDate{
	int year;
	int month;
	int day;
	myDate(){
		this(2013, 12, 3);      //this（）语句必须出现在构造方法的第一行,表示代码的重用
	}
	myDate(int _year, int _month, int _day){
		year = _year;
		month = _month;
		day = _day;
	}
}

public class test03 {
	public static void main(String[] args) {
		myDate	t1 = new myDate(2020, 2, 24);
		System.out.println(t1.year + "-" + t1.month + "-" + t1.day);
		myDate t2 = new myDate();
		System.out.println(t2.year + "-" + t2.month + "-" + t2.day);
	}
}
