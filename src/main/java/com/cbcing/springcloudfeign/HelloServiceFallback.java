package com.cbcing.springcloudfeign;

import com.cbcing.springcloudfeign.domain.User;
import org.springframework.stereotype.Component;

/**
 * 服务降级
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("no name", 0);
    }

    @Override
    public String hello(User user) {
        return "erroe";
    }
}
