package Chapter9Demo;


interface Monster{
	void menace();
}

interface Lethal{
	void kill();
}

interface DangerousMonster extends Monster{
	void destroy();
}

class DragonZilla implements DangerousMonster{
	public void menace() {}
	public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal{
	void drinkBlood();
}

class VeryBadVampire implements Vampire{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drinkBlood() {
		// TODO Auto-generated method stub
		
	}
	
}

public class HorrorShow {
	static void u(Monster b) {
		b.menace();
	}
	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}
	static void w(Lethal l) {
		l.kill();
	}
	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
	}

}
