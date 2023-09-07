package cn.beichenhpy.client;


import cn.beichenhpy.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider", fallbackFactory = ProviderFeignClientFallbackFactory.class)
public interface ProviderFeignClient {

    @GetMapping("/v1/user/info")
    ResponseEntity<User> getUser(@RequestParam String id);
}
