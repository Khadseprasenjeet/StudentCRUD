package com.stu.main.Utility;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class EntityDTOConvertor {
//logger 

	ModelMapper mapper = new ModelMapper();

	@Bean
	public <R> R convertTo(Object source, Class<R> resultClass) {
		return mapper.map(source, resultClass);
	}
}
