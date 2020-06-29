package cn.kitey.dao;

        import cn.kitey.domain.Account;
        import org.apache.ibatis.annotations.One;
        import org.apache.ibatis.annotations.Result;
        import org.apache.ibatis.annotations.Results;
        import org.apache.ibatis.annotations.Select;
        import org.apache.ibatis.mapping.FetchType;

        import java.util.List;

public interface AccountDao {

    @Select("select *from account")
    @Results(id = "AccountMap" ,value = {
            @Result(id = true, property = "id" , column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid" ,
                    //fetchType = FetchType.EAGER):表示立即加载
                    one=@One(select = "cn.kitey.dao.UserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findALl();
}
