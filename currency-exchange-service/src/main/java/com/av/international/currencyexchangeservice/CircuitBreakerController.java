package com.av.international.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "hardCodedRes")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedRes")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sampleAPI(){
        //Retry thrice then return error if not success
        logger.info("Sample API CALL RESERV");
//        ResponseEntity<String> forEntity = new RestTemplate()
//                .getForEntity(
//                        "http://localhost:8080/smaple-new",
//                        String.class
//                );
//        return forEntity.getBody();
        return "Yes";
    }

    public String hardCodedRes(Exception ex){
         return "fall-bak-response "+ ex.getMessage();
    }

}
