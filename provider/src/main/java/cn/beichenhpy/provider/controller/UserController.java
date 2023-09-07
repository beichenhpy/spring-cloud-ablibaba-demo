package cn.beichenhpy.provider.controller;

import cn.beichenhpy.provider.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping("/v1/user")
@RestController
public class UserController {


    @GetMapping("/info")
    public ResponseEntity<User> getUser(@RequestParam String id) {
        log.info("user id: {}", id);
        User user = new User();
        user.setId("123");
        user.setName("测试");
        user.setAge(25);
        return ResponseEntity.ok(user);
    }
}
