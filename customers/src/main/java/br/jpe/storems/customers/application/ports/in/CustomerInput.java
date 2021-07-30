package br.jpe.storems.customers.application.ports.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInput {

	private String name;

	private String email;

	private Integer age;

}
