package com.lingzhix.mapper;

import com.lingzhix.entity.DormitorySet;

import java.util.List;

public interface DormitorySetMapper {

	public int create(DormitorySet dormitorySet);

	public int delete(Integer id);

	public int update(DormitorySet dormitorySet);

	public int updateSelective(DormitorySet dormitorySet);

	public List<DormitorySet> query(DormitorySet dormitorySet);

	public DormitorySet detail(Integer id);

	public int count(DormitorySet dormitorySet);

}