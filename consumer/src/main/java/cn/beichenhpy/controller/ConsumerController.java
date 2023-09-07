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
@RequestMapping("/v1/consumer")
@RestController
public class ConsumerController {

    @Autowired
    private ProviderFeignClient providerFeignClient;

    @GetMapping("/remote")
    public ResponseEntity<User> test() {
        return providerFeignClient.getUser("consumer/remote");
    }
}
