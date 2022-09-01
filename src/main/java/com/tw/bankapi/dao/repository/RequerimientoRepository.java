package com.tw.bankapi.dao.repository;

import com.tw.bankapi.entities.RequerimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RequerimientoRepository extends JpaRepository<RequerimientoEntity, Integer>, JpaSpecificationExecutor<RequerimientoEntity> {
}
