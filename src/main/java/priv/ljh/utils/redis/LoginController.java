package priv.ljh.utils.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import priv.ljh.operate.entity.AdminUser;
import priv.ljh.operate.service.AdminUserService;
import priv.ljh.utils.fastDFS.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/login")
    public Result login(@RequestBody AdminUser adminUser) {
        AdminUser login = adminUserService.verify(adminUser);
        if (null == login) {
            return new Result(500, "登陆失败，⽤户名密码错误", null);
        }
        httpSession.setAttribute(httpSession.getId(), login);
        return new Result(200, "登陆成功", login);
    }

    @GetMapping("/getUser")
    public Result getUser() {
        Object attribute = httpSession.getAttribute(httpSession.getId());
        if (attribute instanceof AdminUser) {
            AdminUser p = (AdminUser) attribute;
            return new Result(200, "获取成功", p);
        }
        return new Result(500, "获取失败", attribute);
    }
}