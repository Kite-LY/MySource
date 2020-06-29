package Demo04_2;

/**
 * 商品类
 *
 */

public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    //重写compareTo（obj ）方法
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods) o;
            //方式一
//            if(this.price > goods.price){
//                return 1;
//            }else if(this.price < goods.price){
//                return -1;
//            }else {
//                return 0;
//            }
            //方式二
            return Double.compare(this.price,goods.price);
        }
//        throw  new RuntimeException("您输入的数据有错误，无法进行比较！");
        return 0;
    }
}
