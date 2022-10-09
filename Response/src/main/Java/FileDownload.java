import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDownload extends HttpServlet {
    //下载注意事项
    //pom,war,jar三种打包方式的区别
    //父工程中定义pom打包，子工程中一般为war
    //文件需要在打包后的目录中找到，也就是target文件夹中，所以先clean maven，再package，resources目录下的文件才会到target目录下
    //不需要在子工程pom.xml中定义build配置，会继承父工程的配置
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 要获取下载文件的路径，通过绝对路径写死
        String realPath = "D:\\Code\\JavaCode\\JavaSE\\Servlet\\ServletDemo\\Response\\target\\classes\\eva.jpg";
        System.out.println("下载文件的路径："+realPath);
//        2. 下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
//        3. 设置想办法让浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-disposition","attachment;filename"+fileName);
//        4. 获取下载文件的输入流
        FileInputStream fis = new FileInputStream(realPath);
//        5. 创建缓冲区
        int len = 0;
        byte[]buffer = new byte[1024];
//        6. 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
//        7. 将FileOutputStream流写入到Buffer缓冲区
        while((len = fis.read(buffer))>0){
            out.write(buffer,0,len);
        }
//        8. 使用OutputStream将缓冲区中的数据输出到客户端
        fis.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
