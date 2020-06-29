package Demo07_01;

/**
 * MyDate类包含：
 * private成员变量year，month， day并为每一个属性定义getter，setter
 */

public class MyDate {
    private int yaer;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int yaer, int month, int day) {
        this.yaer = yaer;
        this.month = month;
        this.day = day;
    }

    public int getYaer() {
        return yaer;
    }

    public void setYaer(int yaer) {
        this.yaer = yaer;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "yaer=" + yaer +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
