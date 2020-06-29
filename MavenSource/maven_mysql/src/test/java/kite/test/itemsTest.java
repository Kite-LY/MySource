package kite.test;

import kite.dao.itemsDao;
import kite.dao.itemsDaoImpl;
import kite.domian.items;
import org.junit.Test;

import java.util.List;

public class itemsTest {

    @Test
    public void findAll(){
        itemsDao itemsDao = new itemsDaoImpl();
        List<items> all = itemsDao.findAll();
        for (items items : all) {
            System.out.println("编号：" + items.getId()+"，   书名："+items.getBookname());
        }
    }
}
