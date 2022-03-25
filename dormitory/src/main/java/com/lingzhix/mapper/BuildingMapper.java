package com.lingzhix.mapper;

import com.lingzhix.entity.Building;

import java.util.List;

public interface BuildingMapper {

	public int create(Building building);

	public int delete(Integer id);

	public int update(Building building);

	public int updateSelective(Building building);

	public List<Building> query(Building building);

	public Building detail(Integer id);

	public int count(Building building);

}