package BookDemo1;
 
public class Main {

	public static void main(String[] args) {
		BookView bookView = new BookView();
		//show();
		
	}
	public static void show() {
		BookBiz bookBiz= new BookBiz();
		if(bookBiz.getBookCount() == 0) {
			System.out.println("≤÷ø‚ø’ø’»Á“≤£°");
			return;
		}
		for(int i = 0; i < bookBiz.getBookCount(); i++) {
			System.out.println( Dates.BookStore[i].getBookId() + "\t" + Dates.BookStore[i].getBookName() + "\t" + Dates.BookStore[i].getCount());
		}
	}
	

}
