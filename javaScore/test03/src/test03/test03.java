package test03;


/** this �����ڴ��ַ��ָ������*/

class myDate{
	int year;
	int month;
	int day;
	myDate(){
		this(2013, 12, 3);      //this��������������ڹ��췽���ĵ�һ��,��ʾ���������
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
