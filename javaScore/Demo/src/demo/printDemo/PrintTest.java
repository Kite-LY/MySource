package demo.printDemo;

public class PrintTest {
	public static void main(String[] args) {
		
		Print printer = new Print();
		//printer.setBox(new ColorInkBoxImpl());
		printer.setBox(new ColorInkBox1());
		
		printer.setPaper(new SizePaperImpl());
		printer.print("≤‚ ‘¥Ú”°ƒ⁄»›£°");
	}
}
