package com.stu.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
	private int         studentRollNo;
	private String      studentName;
	private String      studentAddress;
	private  String     studentStandard;
	private byte[]      studentProfilepic;
	private byte[]      studentSignature;
	
	
	
	
	
}
