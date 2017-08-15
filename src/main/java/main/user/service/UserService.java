package main.user.service;

import main.entity.bean.UserBean;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final AtomicLong counter = new AtomicLong();

    public UserBean login(String account, String password) {

        if (account.equals("test") && password.equals("123456")) {
            return new UserBean(counter.incrementAndGet(),
                    account);
        }

        return null;
    }


    public void logout(){

    }
}
