package com.tianying.product.api.service;

import com.tianying.base.BaseResponse;
import com.tianying.product.output.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Description
 * @Author wzh
 * @Date 2020/1/30 17:32
 * @Version 2.10
 **/
public interface ProductSearchService {
    @GetMapping("/search")
    public BaseResponse<List<ProductDto>> search(String name);
}
