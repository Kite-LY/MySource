package kite.myJson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kite.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

    //1.javaBean和json的转换
    @Test
    public void test01(){
        Person person = new Person(1, "刘备");
        Gson gson = new Gson();
        //toJson()将person转换为json字符串类型
        String s = gson.toJson(person);
        System.out.println(s);

        //romJson():将json对象转换为对应的java对象类型
        //第一个参数为：json字符串
        //第二个参数：转向的java对象的类型类
        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);

    }

    //2.List和json的转换
    @Test
    public void test02(){

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"刘备"));
        personList.add(new Person(2,"关羽"));

        Gson gson = new Gson();
        //list转换为json类型的字符串
        String listJson = gson.toJson(personList);
        System.out.println(listJson);

        List<Person> list = gson.fromJson(listJson, new PersonListType().getType());
        System.out.println(list);
        Person person1 =  list.get(1);
        System.out.println(person1);

    }

    //3.map 和json的转换
    @Test
    public void test03(){
        Map<Integer,Person> personMap = new HashMap<>();

        personMap.put(1,new Person(1,"张飞"));
        personMap.put(2,new Person(2,"赵云"));
        Gson gson = new Gson();
        //转换为json对象
        String personJson = gson.toJson(personMap);
        System.out.println(personJson);

        //json转换为person对象
        //new TypeToken<Map<Integer,Person>>(){}.getType():这里使用了匿名的内部类方式
        Map<Integer,Person> JsonToMap = gson.fromJson(personJson, new TypeToken<Map<Integer, Person>>() {}.getType());
        for(Map.Entry<Integer,Person> entry:JsonToMap.entrySet()){
            System.out.println(entry.getKey() +" 的值为：" + entry.getValue());
        }
        System.out.println(JsonToMap.get(1));

    }
}













