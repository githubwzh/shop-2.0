package com.tianying.product.es.reposiory;

import com.tianying.product.es.entity.ProductEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductReposiory extends ElasticsearchRepository<ProductEntity, Long> {

}
 