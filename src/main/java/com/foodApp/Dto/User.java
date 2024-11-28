package com.foodApp.Dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class User
{
	public enum Role{
		CUSTOMER,ADMIN;
	}
	
  private int userId;
  private String name;
  private String email;
  private String password;
  private String phoneNumer;
  private String address;
  private Role role;
  private Timestamp createdAt; 
}
