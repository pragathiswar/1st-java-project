package com.auth;

import com.entity.enumerate.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 

public class RegisterRequest {
	
	private String email;
	private String firstName;
	private String lastName;
	private Long mobile;
	private String Dob;
	private String password;
	private String gender;
	private String experience;
	private String size;
	private String interest;
	private String location;
	private Role role;
}
