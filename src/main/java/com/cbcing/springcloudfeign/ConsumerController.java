package com.cbcing.springcloudfeign;

import com.cbcing.springcloudfeign.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(helloService.hello()).append("\n");
        stringBuffer.append(helloService.hello("David")).append("\n");
        stringBuffer.append(helloService.hello("David", 17)).append("\n");
        stringBuffer.append(helloService.hello(new User("David", 17))).append("\n");
        return stringBuffer.toString();
    }

}
