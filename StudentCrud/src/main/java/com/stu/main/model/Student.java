package com.stu.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int               studentRollNo;
	private String              studentName;
	private String           studentAddress;
	private  String         studentStandard;
	@Lob
	private byte[]        studentProfilepic;
	@Lob
	private byte[]         studentSignature;
	
	
	
	
	
	
	
}
