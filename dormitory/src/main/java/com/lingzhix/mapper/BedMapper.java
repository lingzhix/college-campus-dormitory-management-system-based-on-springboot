package com.lingzhix.mapper;

import com.lingzhix.entity.Bed;

import java.util.List;

public interface BedMapper {

	public int create(Bed bed);

	public int delete(Integer id);

	public int deleteByDormitoryId(Integer dormitoryId);

	public int update(Bed bed);

	public int updateSelective(Bed bed);

	public List<Bed> query(Bed bed);

	public Bed detail(Integer id);

	public int count(Bed bed);

}