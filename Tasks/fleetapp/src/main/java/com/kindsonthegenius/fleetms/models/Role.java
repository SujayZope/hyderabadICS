package com.kindsonthegenius.fleetms.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
		
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private int roleId;
    private String role;
    private String description;
	



}
