package cn.beichenhpy.controller;

import cn.beichenhpy.client.ProviderFeignClient;
import cn.beichenhpy.entity.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1/consumer2")
@RestController
public class Consumer2Controller {


    @CircuitBreaker(name = "consumer2-test", fallbackMethod = "testFallback")
    @GetMapping("/remote")
    public ResponseEntity<?> test() {
        User user = new User();
        user.setName("consumer2");
        int i = 1 / 0;
        return ResponseEntity.ok(user);
    }


    public ResponseEntity<?> testFallback(Throwable throwable) {
        log.error("调用异常 熔断");
        return ResponseEntity.badRequest().body("调用异常 熔断");
    }
}
