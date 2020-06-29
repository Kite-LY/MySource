package cn.kitey.jpa.controller;


        import cn.kitey.jpa.entity.User;
        import cn.kitey.jpa.repository.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

/**
 * 带返回值的控制类
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User one = userRepository.findById(id).get();
        return one;

    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save =  userRepository.save(user);
        return save;
    }
}
