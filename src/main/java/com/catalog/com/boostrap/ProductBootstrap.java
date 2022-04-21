package com.catalog.com.boostrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.catalog.com.models.Category;
import com.catalog.com.models.Product;
import com.catalog.com.repositories.CategoryRepository;
import com.catalog.com.repositories.ProductRepository;

@Component
public class ProductBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	@Autowired
	public ProductBootstrap(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData(9);
	}

	private void initData(int count) {

		for (int i = 1; i < count; i++) {
			Product product = new Product();
			String name = "name" + i;
			long quantity = i;
			long price = i * 100;

			Category category = categoryRepository.findById(i).get();

			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setCategory(category);

			productRepository.save(product);
		}

	}
}