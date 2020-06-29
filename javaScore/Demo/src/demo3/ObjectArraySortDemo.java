package demo3;

public class ObjectArraySortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Warriors w1 = new Warriors();
		Warriors w2 = new Warriors();
		Warriors w3 = new Warriors();
		Warriors w4 = new Warriors();
		Warriors w5 = new Warriors();
		
		ArchMage a1 = new ArchMage();
		ArchMage a2 = new ArchMage();
		ArchMage a3 = new ArchMage();
		ArchMage a4 = new ArchMage();
		ArchMage a5 = new ArchMage();
		
		Hero[] HeroArray = {
				w1,w2,w3,w4,w5,
				a1,a2,a3,a4,a5
		};
		System.out.println("昵称\t\t等级\tMaxLife\t生命值\t攻击力");
		for(Hero hero : HeroArray) {
			System.out.println(hero);
		}
		System.out.println();
		sort(HeroArray);
		System.out.println("sort排序后：");
		System.out.println("昵称\t\t等级\tMaxLife\t生命值\t攻击力");
		for(Hero hero : HeroArray) {
			System.out.println(hero);
		}
	}
	
	
	public static void sort(Hero[] heroArray) {
		Hero tempHero = new Hero();
		for (int i = 0; i < heroArray.length; i++) {
			for (int j = 0; j < heroArray.length - i - 1; j++) {
				if(heroArray[j].compareToByName(heroArray[j +1]) < 0) {
					tempHero = heroArray[j];
					heroArray[j] = heroArray[j + 1];
					heroArray[j + 1] = tempHero;
				}
			}
		}
		
		
	}

}
