package kite.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UpLoadServlet extends HttpServlet {

    /**
     * 用来上传处理的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("文件上传成功！");
//        System.out.println(req.getCookies());
        //这里以流的方式进行传播，必须以流的方式进行接受



        //1.首先判断上传的是不是多段数据（只有多段数据是，才是文件上传的）
        if(ServletFileUpload.isMultipartContent(req)){
            //创建diskFileItemFactory工厂实现类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //循环判断，每一个表单项，是普通类型，还是上传的文件
                for(FileItem fileItem: list){
                    try {
                        if(fileItem.isFormField()){
                            //判断是不是普通项
                            System.out.println("表单的的name属性值：" + fileItem.getFieldName());
                            //参数utf-8解决乱码问题
                            System.out.println("表单的value的属性值：" + fileItem.getString("UTF-8"));
                        }else{
                            //上传的文件
                            //判断是不是普通项
                            System.out.println("表单的的name属性值：" + fileItem.getFieldName());
                            //参数utf-8解决乱码问题
                            System.out.println("上传文件名：" + fileItem.getName());
                            //fileItem.write(new File("D:\\Java"));
                            InputStream inputStream = fileItem.getInputStream();
                            FileOutputStream fileOutputStream = new FileOutputStream("D:/java");
                            byte[] buffer = new byte[1024];
                            int len = 0;
                            while ((len = inputStream.read(buffer)) != -1){
                                fileOutputStream.write(buffer,0,len);
                            }
                            System.out.println("文件写入成功！");


                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        fileItem.delete();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {

            }

        }

    }
}
