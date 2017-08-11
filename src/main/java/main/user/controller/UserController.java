package main.user.controller;

import main.base.BaseController;
import main.base.Session;
import main.entity.bean.UserBean;
import main.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController("user.controller.UserController")
@RequestMapping("/user")
@SessionAttributes(value = Session.USER, types = UserBean.class)
public class UserController extends BaseController {

    private static final String loginTemplate = "Hello, %s!";
    private static final String logoutTemplate = "Good Bye, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public main.base.ResponseBody greeting(@RequestParam(value = "name", defaultValue = "World") String name
            , Map<String,UserBean> map) {
        main.base.ResponseBody responseBody = new main.base.ResponseBody();
        UserBean user = checkSession();

        if (user == null) {
            user = new UserBean(counter.incrementAndGet(),
                    String.format(loginTemplate, name));
        }

        map.put("user", user);

        responseBody.setBody(map);
        return responseBody;
    }

    // TODO: 2017/8/11 退出清除缓存
}
