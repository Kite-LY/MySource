package Demo05_1;


/**
 * 一、枚举类的使用：
 * 1.枚举类的理解：类的对象只用有限个，确定的，我们称此类为枚举类
 * 2.当需要定义一组常量是，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式
 *
 * 二、如何定义枚举类
 * 方式一：在jdk5.0之前使用自定义枚举类
 * 方式二：在jdk5。0之后使用enum关键字定义枚举类
 *
 * 三.Enum类的常用方法：
 *     value（）方法：返回枚举类型的对象数组，该方法可以恒方便的遍历所用的枚举类型
 *     valueOf(String str):可以把一个字符串转为对应的枚举类对象，要求字符串必须是枚举类型对象
 *     toString：返回当前的枚举类型对象
 *
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring =  Season.SPRING;
        System.out.println(spring.toString());
        System.out.println(Season.AUTUMN.getSeasonDesc());
    }
}

//自定义枚举类
class Season{
    //1.声明枚举类的属性
    private final String seasonName;
    private final String seasonDesc;
    //2、私有化构造器进行赋值
    private  Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前的枚举类的对各对象：public static final进行定义
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏伊昂坦");
    public static final Season AUTUMN = new Season("秋天","秋天来了");
    public static final Season WINTER = new Season("冬天","冬暖夏凉");

    //4.述求1：获取枚举类对象的属性


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4.toString方法

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
