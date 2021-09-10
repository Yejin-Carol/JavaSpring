package com.mh.org.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mh.org.domain.Board;
import com.mh.org.domain.Customer;

/*
 * CRUD
 * select * from user;
 * insert into user values();
 * update user set
 * delete * from user where
 * */


public interface BoardRepository extends CrudRepository<Board, Long> {



}