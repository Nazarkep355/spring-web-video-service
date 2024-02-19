package com.example.springwebvideoservice.service;

import com.example.springwebvideoservice.entity.Season;
import com.example.springwebvideoservice.model.SeasonModel;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperService {
    final private ModelMapper mapper = new ModelMapper();

    public <T,C> T mapObject(C object,Class<T> tClass){
        return mapper.map(object,tClass);
    }
}
