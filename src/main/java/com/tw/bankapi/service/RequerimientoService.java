package com.tw.bankapi.service;

import com.tw.bankapi.dao.RequerimientoDao;
import com.tw.bankapi.entities.RequerimientoEntity;
import com.tw.bankapi.util.BankApiResponse;
import com.tw.bankapi.util.exceptions.BankApiException;
import org.springframework.stereotype.Service;

@Service
public class RequerimientoService {
    final
    RequerimientoDao requerimientoDao;

    public RequerimientoService(RequerimientoDao requerimientoDao) {
        this.requerimientoDao = requerimientoDao;
    }

    public RequerimientoEntity save(RequerimientoEntity dataToSave) {
        if(dataToSave == null){
            throw new BankApiException(BankApiResponse.PARAMETER_NULL);
        }
        return requerimientoDao.save(dataToSave);
    }
}
