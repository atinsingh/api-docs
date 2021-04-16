package io.pragra.lms.lmsdemo.conf;

import feign.Contract;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Parking for Security Discussion
 */s
@Component
public class AuthInterceptor implements RequestInterceptor {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }


    @Override
    public void apply(RequestTemplate requestTemplate) {
      //  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    }
}
