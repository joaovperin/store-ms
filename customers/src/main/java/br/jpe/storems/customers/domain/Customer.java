package br.jpe.storems.customers.domain;

import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private Long id;

	private String name;

	private String email;

	private ZonedDateTime dateOfBirth;

	public int getAge() {
		return Period.between(dateOfBirth.toLocalDate(), ZonedDateTime.now().toLocalDate())
				.getYears();
	}
	
	public Customer withAge(int age) {
		this.dateOfBirth = ZonedDateTime.now().minus(age, ChronoUnit.YEARS);
		return this;
	}

}
