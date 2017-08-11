package main.base;

import main.entity.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class BaseController {

    @Autowired
    private HttpSession session;

    protected UserBean checkSession() {
        return (UserBean) session.getAttribute(Session.USER);
    }
}