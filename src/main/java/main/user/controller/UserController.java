package main.user.controller;

import main.base.BaseController;
import main.entity.bean.UserBean;
import main.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController("user.controller.UserController")
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserService userService;

    @RequestMapping("/greeting")
    public UserBean greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new UserBean(counter.incrementAndGet(),
                String.format(template, name));
    }
}
