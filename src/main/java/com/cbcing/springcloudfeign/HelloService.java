package com.cbcing.springcloudfeign;

import com.cbcing.springcloudfeign.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 访问服务 ------ feign配置
 */
@FeignClient(name = "test-eureka-service-provider", fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader(value = "name") String name, @RequestHeader(value = "age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    String hello(@RequestBody User user);

}
