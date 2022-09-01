package com.tw.bankapi.dao;

import com.tw.bankapi.dao.repository.RequerimientoRepository;
import com.tw.bankapi.entities.RequerimientoEntity;

public class RequerimientoDao {
    RequerimientoRepository requerimientoRepository;

    public RequerimientoDao(RequerimientoRepository requerimientoRepository){
        this.requerimientoRepository = requerimientoRepository;
    }

    public RequerimientoEntity save(RequerimientoEntity requerimientoEntity) {
        return requerimientoRepository.save(requerimientoEntity);
    }
}
