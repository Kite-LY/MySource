package Demo08_05;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>() ;

    //保存T类型的对象到map成员变量中
    public void save(String id, T entiry){
        map.put(id, entiry);
    }

    //从map中获取id对应的对象
    public T get(String id){
        return map.get(id);
    }
    //替换map中key为id的内容，改为entity对象
    public void update(String id, T entity){
       if(map.containsKey(id)){
           map.put(id,entity);
       }
    }
    //返回map中存放的所有T对象
    public List<T> list(){
        List<T> list = new ArrayList<>();
        Collection<T> collection = map.values();
        for (T t : collection) {
            list.add(t);
        }
        return list;
    }

    //删除指定的id对象
    public void delete(String id){
        map.remove(id);
    }

}
