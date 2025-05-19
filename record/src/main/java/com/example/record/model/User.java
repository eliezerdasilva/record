package com.example.record.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.example.record.enums.UserCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
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
	@Column(name = "cpf", unique = true)
	private int cpf;

	@NotNull
	@Column(name = "email", unique = true)
	private String email;

	@NotNull
	private LocalDate dateBirth;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Address address;

	public enum Values {

		ADMIN(1L), BASIC(2L);

		long userId;

		Values(long userId) {
			this.userId = userId;
		}

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

	}
}
