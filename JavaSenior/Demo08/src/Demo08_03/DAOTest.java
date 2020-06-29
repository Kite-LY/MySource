package Demo08_03;

import org.junit.jupiter.api.Test;

public class DAOTest {

    @Test
    public void test01(){
        //这时只能操作的customers表
        CustomersDAO cus = new CustomersDAO();
        cus.add(new Customer());
    }
}
