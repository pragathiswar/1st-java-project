package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="gardenfeedback")

public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="feedbackid")
	private long feedbackId;
	@Column(name="email", nullable = false)
	private String email;
	@Column(name="feedback", length=50000, nullable = false)
    private String feedback;
}
