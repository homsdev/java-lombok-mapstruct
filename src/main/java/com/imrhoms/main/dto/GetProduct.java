package com.imrhoms.main.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProduct {

	private Long productId;
	private String productName;
	private LocalDateTime creationDate;
	private String price;
	private GetCategory categoryProduct;
}
