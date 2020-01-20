package com.huashang.core.service;

import java.util.List;

public interface BaseService<T> {

	int deleteByPrimaryKey(String id);

	int insert(T t);

	T selectByPrimaryKey(String id);

	List<T> selectAll();

	int updateByPrimaryKey(T t);

}