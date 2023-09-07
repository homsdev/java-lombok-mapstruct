package com.imrhoms.main.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.imrhoms.main.dto.GetProduct;
import com.imrhoms.main.entity.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {CategoryMapper.class})
public interface ProductMapper {

	@Mappings( {
			@Mapping(source = "id", target = "productId"),
			@Mapping(source = "name", target = "productName"),
			@Mapping(source = "creationDate", target = "creationDate", dateFormat = "yyyy-mm-dd HH:mm:ss"),
			@Mapping(source = "price", target = "price", numberFormat = "$#0.00"),
			@Mapping(source = "category", target = "categoryProduct")
			} )
	GetProduct toGetProductDTO(Product product);

	@InheritInverseConfiguration
	Product toProductEntity(GetProduct getProduct);

	List<GetProduct> toDTOGetProductList(List<Product> product);

	List<Product> toEntityProductList(List<GetProduct> product);

}
