package cn.kitey.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 文件上传控制类
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 使用SpringMVC上传文件
     * @param upload
     * @param upload
     * @return
     */
    @RequestMapping("/fileUpLoad3")
    public String fileUpLoad3( MultipartFile upload)  {
        System.out.println("跨服务器文件上传！！！");
        //获取文件上传的地址
        String path = "http://localhost:9090/flieUpLoadServer/uploads/";
        //说明上传的文件项
        //获取文件名称
        String fileName = upload.getOriginalFilename();
        //设置文名称为唯一值
        long millis = System.currentTimeMillis();
        fileName = millis + fileName;

        //创建客户端对象
        Client client = Client.create();
        //和图片服务器相连接
        WebResource resource = client.resource(path + fileName);
        //上传文件
        try {
            resource.put(upload.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(path);
        return "success";
    }

    /**
     * 使用SpringMVC上传文件
     * @param upload
     * @param upload
     * @return
     */
    @RequestMapping("/fileUpLoad2")
    public String fileUpLoad2( MultipartFile upload)  {
        System.out.println("SpringMVC文件上传了！");
        //使用fileupload组件完成文件上传
        //创建文件上传存储位置
        String path ="D:\\java\\mybatis-spring-springmvc\\SpringMvcSource\\uploads\\";
        //判断该路径下是否存在该文件，如果不存在进行创建
        File file = new File(path);
        if(!file.exists()){
            //创建该文件夹
            file.mkdirs();
        }
        //获取文件上传名称
        String filename = upload.getOriginalFilename();
        long newTime = System.currentTimeMillis();
        //重新定义文件名
        filename = newTime+filename;
        //完成文件上传
        try {
            upload.transferTo(new File(path,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(path);
        return "success";
    }




    @RequestMapping("/fileUpLoad1")
    public String fileUpLoad1(HttpServletRequest request)  {
        System.out.println("基本的文件上传了！");
        //使用fileupload组件完成文件上传
        //创建文件上传存储位置
        String path ="D:\\java\\mybatis-spring-springmvc\\SpringMvcSource\\uploads\\";
        //判断该路径下是否存在该文件，如果不存在进行创建
        File file = new File(path);
        if(!file.exists()){
            //创建该文件夹
            file.mkdirs();
        }

        //解析request对象，获取上传对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //对获取的对象进行遍历
        for (FileItem fileItem : fileItems) {
            //进行判断，当前的item对象是否事上传文件项
            if(fileItem.isFormField()){
                //表单项
            }else {
                //文件项
                //获取文件上传的名称
                String filename = fileItem.getName();
                //完成文件上传
                try {
                    fileItem.write(new File(path,filename));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //删除缓存文件
                fileItem.delete();
            }
        }

        System.out.println(path);
        return "success";
    }

}
