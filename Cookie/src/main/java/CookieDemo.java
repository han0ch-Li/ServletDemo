import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-16");
        resp.setCharacterEncoding("utf-16");
        PrintWriter writer = resp.getWriter();
        //cookie,服务端从客户端获取
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            //如果cookie存在
            writer.write("上次访问本站的时间为");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if(cookie.getName().equals("lastLoginTime")){
                    long l = Long.parseLong(cookie.getValue());
                    Date date = new Date(l);
                    writer.write(date.toLocaleString());
                }
            }
        }else {
            System.out.println("首次访问本站");
        }
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //设置cookie有效期为一天
        cookie.setMaxAge(24*60*60);
        //服务端给客户端响应一个cookie
        resp.addCookie(cookie);

//cookie传输中文字符
//        URLDecoder.decode(cookie.getValue(),"utf-8");
//        Cookie cookie = new Cookie("name", URLEncoder.encode("李航宇","utf-8"));

//通过替换cookie实现cookie删除
//创建一个cookie，名字必须和要删除的cookie一致（替换掉）
//        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
//        cookie.setMaxAge(0);
//        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
