import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到session
        HttpSession session = req.getSession();
        //在session中存入数据
        session.setAttribute("username","Hanoch");
        session.setAttribute("Person",new Person(1,"Raylene",24));

        //获取sessionID
        String id = session.getId();

        //判断session是不是新创建的
        if(session.isNew()){
            resp.getWriter().write("Session "+id+ " created successfully");
        }
        else {
            resp.getWriter().write("Session "+id+" already Existed");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
