package Demo05_1;


/**
 * enum枚举类
 * "让枚举类实现抽象方法
 *
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 s1 = Season1.SUMMER;
        System.out.println("季节：" + s1.getSeasonName() + "描述：" + s1.getSeasonDesc());

        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        Season1 spring = Season1.valueOf("SPRING");
        System.out.println(spring);

    }
}
interface info{
    public void show();
}
//自定义枚举类
enum Season1 implements info{
    //1提供枚举类对象，多个对象用，隔开
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.print("春天真的好美！");
        }
    },
    SUMMER("夏天","夏伊昂坦") {
        @Override
        public void show() {
            System.out.print("夏天真的好美！");
        }
    },
    AUTUMN("秋天","秋天来了") {
        @Override
        public void show() {
            System.out.print("秋天真的好美！");
        }
    },
    WINTER("冬天","冬暖夏凉") {
        @Override
        public void show() {
            System.out.print("冬天真的好美！");
        }
    };
    //1.声明枚举类的属性
    private final String seasonName;
    private final String seasonDesc;
    //2、私有化构造器进行赋值
    private  Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前的枚举类的对各对象：public static final进行定义


    //4.述求1：获取枚举类对象的属性


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //单个的实现重载
//    @Override
//    public void show() {
//        System.out.println("这是一个美丽的季节！");
//    }
    //4.toString方法

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}