package innnerclasses10;


public class TestParcel {
	public static void main(String[] args) {
		Parce4 p = new Parce4();
		Contents c = p.contents();
		Destioation d =p.destionation("Tasmania");
	}
}


class Parce4{
	private class PContents implements Contents{   //私有的只能Parcel4可以访问
		private int i =11;
		public int value() {
			return i;
		}
	}

	protected class PDestination implements Destioation{
		private String label;
		private PDestination(String whereTo) {
			label = whereTo;
		}
		@Override
		public String readLable() {
			// TODO Auto-generated method stub
			return label;
		}
	}
	public Destioation destionation(String s) {
		return new PDestination(s);
	}
	public Contents contents() {
		return new PContents();
	}
	
}