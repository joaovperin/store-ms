package br.jpe.storems.gateway.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {

	private Long id;

	private Long orderId;

	private Integer sequence;

	private BigDecimal quantity;

	private BigDecimal unitValue;

	private BigDecimal totalValue;

	private ProductResponse product;

}
