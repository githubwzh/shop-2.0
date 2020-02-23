package com.tianying.product.service.impl;


import com.tianying.base.BaseApiService;
import com.tianying.base.BaseResponse;
import com.tianying.product.api.service.ProductSearchService;
import com.tianying.product.es.entity.ProductEntity;
import com.tianying.product.es.reposiory.ProductReposiory;
import com.tianying.product.output.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductSearchServiceImpl extends BaseApiService<List<ProductDto>> implements ProductSearchService {
    @Autowired
    private ProductReposiory productReposiory;

    @Override
    public BaseResponse<List<ProductDto>> search(String name) {
        log.info("###全局捕获3333333333333异常###,error:{}");
        int m = 1 / 0;
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        // 模拟查询
        builder.must(QueryBuilders.fuzzyQuery("name", name));
        Pageable pageable = new QPageRequest(0, 5);
        Page<ProductEntity> page = productReposiory.search(builder, pageable);
        List<ProductEntity> content = page.getContent();
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        List<ProductDto> mapAsList = mapperFactory.getMapperFacade().mapAsList(content, ProductDto.class);
        return setResultSuccess(mapAsList);
    }

}
