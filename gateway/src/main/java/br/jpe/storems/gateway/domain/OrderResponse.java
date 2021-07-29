package br.jpe.storems.gateway.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

	private Long id;

	private BigDecimal totalValue;

	private ZonedDateTime entryDate;
	
	private Long customerId;

	private CustomerResponse customer;

	@Builder.Default()
	private List<OrderItemResponse> items = new ArrayList<>();

}
