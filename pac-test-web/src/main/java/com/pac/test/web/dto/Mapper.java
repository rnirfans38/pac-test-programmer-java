package com.pac.test.web.dto;

import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
	public <T> T mapper(Object source, Type destination) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true);
		return modelMapper.map(source, destination);
	}
}
