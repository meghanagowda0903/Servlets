package com.ripple.users.dto;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity

@Table(name="emp")
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String dept;

}
