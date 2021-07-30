package br.jpe.storems.customers.application.ports.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOutput {

	private Long id;

	private String name;

	private String email;

	private Integer age;

}
