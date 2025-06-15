package com.example.record.dtos;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.example.record.enums.UserCategory;
import com.example.record.model.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class UserDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@NotNull
	@Length(min = 5, max = 200)
	private String name;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UserCategory userCategory;

	@NotNull
	private int cpf;

	@NotNull
	private String email;

	@NotNull
	private LocalDate dateBirth;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Address address;
}
