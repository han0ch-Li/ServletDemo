import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Validation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果让浏览器每三秒自动刷新一次
        resp.setHeader("refresh","3");

        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics = (Graphics2D)image.getGraphics();
        //设置图片背景色
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,80,20);
        //给图片中写入数据（生成验证码随机数）
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeRandomNums(),0,20);

        //告诉浏览器这个请求使用图片方式打开
        resp.setContentType("image/jpeg");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写入浏览器
        //常见问题
        //1.一般碰到 Can't create output stream!的问题就是我们的tomcat下面没有temp文件夹，因为ImageIO默认使用的缓存目录是tomcat下面的temp文件夹，而我有这个文件夹，但是还没办法生成缓存文件，需要管理员权限才能创建文件所以没办法生成缓存文件。
        //2.ImageIO默认是使用缓存目录，可以通过ImageIO.setUseCache(false)来设置，更改缓存策略，不使用文件目录缓存，使用内存缓存。
        ImageIO.write(image,"jpeg",resp.getOutputStream());
    }

    private String makeRandomNums(){
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 7-num.length(); i++) {
            stringBuffer.append(0);//数字不够7位使用0填充
        }
        num = stringBuffer.toString()+num;
        return num;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
