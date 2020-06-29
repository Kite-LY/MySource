package cn.kitey.controller;


        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody     //这个直接将返回值进行输出
    @RequestMapping("/hello")
    public String hello(){
        return "hello World";
    }

}
