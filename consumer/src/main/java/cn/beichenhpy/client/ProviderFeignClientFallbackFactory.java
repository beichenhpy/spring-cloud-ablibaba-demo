package cn.beichenhpy.client;


import cn.beichenhpy.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProviderFeignClientFallbackFactory implements FallbackFactory<ProviderFeignClient> {

    @Override
    public ProviderFeignClient create(Throwable cause) {
        log.info("服务调用失败");
        return new ProviderFeignClient() {
            @Override
            public ResponseEntity<User> getUser(String id) {
                return ResponseEntity.badRequest().body(new User());
            }
        };
    }
}
