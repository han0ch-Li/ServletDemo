import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入请求");
        //处理请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("hanoch")&& password.equals("123456")){
            //加上工程名
            System.out.println("success");
            resp.sendRedirect("/Response/Home.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
