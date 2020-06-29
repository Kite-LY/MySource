package demo;
//电脑玩家
public class HumComPlayer2 {
	
	/** 静态常量: 出拳信息*/
	public static final int MeeageTypeFist = 1;
	/** 静态常量: 赢的信息*/
	public static final int MeeageTypeWin = 2;
	/** 静态常量: 输的信息*/
	public static final int MeeageTypelose = 3;
	
	
	private String name;
	private int fist;
	private int score;
	
	private String[] fistWords = {
			" --- 动感光波...biubiu",
			" --- 必杀技！",
			" --- 大姐姐你喜欢吃青椒嘛",
			" --- 欧巴吃我一拳！"
	};
	
	private String[] winWords = {
			" --- 还有谁？",
			" --- 猜拳还是有点意思的偶！",
			" --- 哈哈  我又赢了",
			" --- 为啥，我的运气这么好的哇"
	};
	
	private String[] loseWords = {
			" --- 通往成功的路上总在施工",
			" --- 失败来时成功之母的嘛",
			" --- 桃花潭水深千尺，不及汪伦送我情",
			" --- 劝君更进一杯酒，西出阳关无故人"
	};

	/**
	 *根据传入的数据，随机打印数据类型 
	 * @param msgType  传入的数据
	 */
	  
	public void sendMessage(int msgType) {
		String message = null;
		int index = (int)(Math.random() * 1000) % 4 ;		//取一个0 到 3 之间的数
		switch (msgType) {
		case MeeageTypeFist:      //类似于int 1
			message =  fistWords[index];
			break;
		case MeeageTypeWin:
			message = winWords[index];
			break;
		case MeeageTypelose:
			message = loseWords[index];
		}
		System.out.println(message);
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFist() {
		//电脑随机出拳,生成1-3 的随机数字
		fist = ((int)(Math.random() * 1000)) % 3 + 1;
		return fist;
	}

//	public void setFist(int fist) {
//		this.fist = fist;
//	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
