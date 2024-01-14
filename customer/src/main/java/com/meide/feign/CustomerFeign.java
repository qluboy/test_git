package com.meide.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通过CustomerFeign 去调用nacos服务中的provider服务
 * 所以要映射起来 :@FeignClient("provider") ##
 */
@FeignClient("provider")
public interface CustomerFeign {
    /**
     * 并且要调用provider服务中的方法（@GetMapping("/index")）要一致 ##
     * @return
     */
    @GetMapping("/index")
    String index();
}
