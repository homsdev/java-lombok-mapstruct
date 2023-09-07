package com.imrhoms.main.config;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.imrhoms.main.dto.GetProduct;
import com.imrhoms.main.entity.Product;
import com.imrhoms.main.mapper.ProductMapper;
import com.imrhoms.main.repository.ProductRepository;

@Configuration
public class InitDatabase {

	ProductRepository productRepository;

	ProductMapper productMapper;

	public InitDatabase(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Bean
	public CommandLineRunner testProductMapperCommand() {

		return args -> {

			System.out.println("Product Entity");
			List<Product> products = productRepository.findAll();
			products.forEach(System.out::println);

			System.out.println("Product Entity to DTO Product");
			List<GetProduct> productDTOList = products.stream().map(product -> productMapper.toGetProductDTO(product))
					.peek(System.out::println).collect(Collectors.toList());

			System.out.println("ProductList to ProductDTOList");
			List<GetProduct> dtoGetProductList = productMapper.toDTOGetProductList(products);
			dtoGetProductList.forEach(System.out::println);
			
			System.out.println("Product to Entity List");
			List<Product> entityProductList = productMapper.toEntityProductList(dtoGetProductList);
			entityProductList.forEach(System.out::println);
		};
	}

}
