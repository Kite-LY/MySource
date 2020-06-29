package Demo07_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Orooerties:常用来处理配置文件，key value，都是String类型的
 *
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Properties pro = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("jdbc.properties");
            pro.load(fis);
            String name = pro.getProperty("name");
            String password = pro.getProperty("password");
            System.out.println("name : " + name + "  password: " + password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
