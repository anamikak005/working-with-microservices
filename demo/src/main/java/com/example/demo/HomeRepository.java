package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository <GameFormat , Integer> {

	@Query("from GameFormat order by orderOfGame")
	List<GameFormat> findAllSortedByOrderGame();
}