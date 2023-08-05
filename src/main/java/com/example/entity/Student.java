package com.example.entity;

import java.time.LocalDate;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, message = "First name should have at least 3 characters")
    private String firstName;

    @NotBlank
    @Size(min = 3, message = "Last name should have at least 3 characters")
    private String lastName;

    @NotNull(message = "Date of Birth is mandatory")
    private LocalDate dob;

    @Min(value = 16, message = "Age should be greater than 15 years")
    @Max(value = 20, message = "Age should be less than or equal to 20 years")
    private int age;
    
    @Min(value = 0, message = "Marks should be greater than or equal to 0")
    @Max(value = 100, message = "Marks should be less than or equal to 100")
    private Integer marks;

    @NotBlank(message = "Section is mandatory")
    private String section;

    @NotBlank(message = "Gender is mandatory")
    private String gender;
    
    public Student() {
    	
    }

	public Student(Long id,
			@NotBlank @Size(min = 3, message = "First name should have at least 3 characters") String firstName,
			@NotBlank @Size(min = 3, message = "Last name should have at least 3 characters") String lastName,
			@NotNull(message = "Date of Birth is mandatory") LocalDate dob,
			@Min(value = 16, message = "Age should be greater than 15 years") @Max(value = 20, message = "Age should be less than or equal to 20 years") int age,
			@Min(value = 0, message = "Marks should be greater than or equal to 0") @Max(value = 100, message = "Marks should be less than or equal to 100") Integer marks,
			@NotBlank(message = "Section is mandatory") String section,
			@NotBlank(message = "Gender is mandatory") String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.age = age;
		this.marks = marks;
		this.section = section;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", age="
				+ age + ", marks=" + marks + ", section=" + section + ", gender=" + gender + "]";
	}
    
    

}
