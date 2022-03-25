package com.lingzhix.mapper;

import com.lingzhix.entity.Grade;

import java.util.List;

public interface GradeMapper {

	public int create(Grade grade);

	public int delete(Integer id);

	public int update(Grade grade);

	public int updateSelective(Grade grade);

	public List<Grade> query(Grade grade);

	public Grade detail(Integer id);

	public int count(Grade grade);

}