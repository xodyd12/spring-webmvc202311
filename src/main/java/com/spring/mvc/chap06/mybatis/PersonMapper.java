package com.spring.mvc.chap06.mybatis;


import com.spring.mvc.chap06.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 마이바티스의 SQL실행을 위한 인터페이스
@Mapper
public interface PersonMapper {

    //CRUD를 명세

   boolean save(Person p); //INSERT 기능
    boolean update(Person p); //UPDATE 기능
    boolean delete(String p); //DELETE 기능
    List<Person> findAll(); //SELECT 기능
    Person findOne(String id); // SELECT 기능
}
