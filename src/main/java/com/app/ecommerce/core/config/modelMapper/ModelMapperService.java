package com.app.ecommerce.core.config.modelMapper;

public interface ModelMapperService {

    org.modelmapper.ModelMapper forRequest();

    org.modelmapper.ModelMapper forResponse();
}
