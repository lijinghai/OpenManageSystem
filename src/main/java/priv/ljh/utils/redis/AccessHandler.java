package priv.ljh.utils.redis;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 编写拦截逻辑
 * @author Dorian
 */
public class AccessHandler implements HandlerInterceptor {
    @Override
    //这个⽅法是在访问接⼝之前执⾏的，我们只需要在这⾥写验证登陆状态的业务逻辑，就可以在⽤户调⽤指定接⼝之前验证登陆状态了

    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
        //每⼀个项⽬对于登陆的实现逻辑都有所区别，我这⾥使⽤最简单的Session提取User来验证登陆。
        HttpSession session = request.getSession();
        //这⾥的User是登陆时放⼊session的
        Object user = session.getAttribute(session.getId());
        //如果session中没有user，表示没登陆
        if (user == null) {
            //这个⽅法返回false表示忽略当前请求，如果⼀个⽤户调⽤了需要登陆才能使⽤的接⼝，如果他没有登陆这⾥会直接忽略掉
            //当然你可以利⽤response给⽤户返回⼀些提示信息，告诉他没登陆
            response401(response);
            return false;
        } else {
            //如果session⾥有user，表示该⽤户已经登陆，放⾏，⽤户即可继续调⽤⾃⼰需要的接⼝
            return true;
        }
    }

    private void response401(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            response.getWriter().print("⽤户未登录！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}