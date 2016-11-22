package com.interview.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.interview.entity.FactorType;

@Transactional
public interface FactorTypeDao extends JpaRepository<FactorType, Serializable> {

	public List<FactorType> findByFactor(String factor);

	@SuppressWarnings("unchecked")
	public FactorType save(FactorType factorTypesBean);

	@Modifying
	@Query("UPDATE FactorType ft SET ft.score = :score WHERE ft.factortype = :factortype")
	int updateFactortype(@Param("score") float score, @Param("factortype") String factortype);
}
