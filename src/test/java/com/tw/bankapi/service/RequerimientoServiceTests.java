package com.tw.bankapi.service;

import com.tw.bankapi.dao.RequerimientoDao;
import com.tw.bankapi.dao.repository.RequerimientoRepository;
import com.tw.bankapi.entities.RequerimientoEntity;
import com.tw.bankapi.util.exceptions.BankApiException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RequerimientoServiceTests {
    @Mock
    RequerimientoDao requerimientoDao = Mockito.mock(RequerimientoDao.class);
    @Test
    public void shouldCallRequerimientoDaoWhenCreatedNewRequerimiento(){

        RequerimientoEntity dataToSave = new RequerimientoEntity();
        RequerimientoService requerimientoService = new RequerimientoService(requerimientoDao);
        dataToSave.setCorreo("test@tes.com");
        dataToSave.setDescripcion("description");
        dataToSave.setCategoriaId(1);
        Mockito.when(requerimientoDao.save(dataToSave)).thenReturn(dataToSave);

        RequerimientoEntity resultServiceSaveRequerimiento =requerimientoService.save(dataToSave);

        Mockito.verify(requerimientoDao,Mockito.times(1)).save(dataToSave);
        assertNotNull(resultServiceSaveRequerimiento);

    }

    @Test
    public void shouldThrowAnExceptionWhenEntityIsNull(){
        RequerimientoService requerimientoService = new RequerimientoService(requerimientoDao);

        BankApiException bankApiException = assertThrows(BankApiException.class, () -> {
            requerimientoService.save(null);
        });

        Mockito.verify(requerimientoDao,Mockito.never()).save(null);
        assertEquals("PARAMETER_NULL", bankApiException.getMessage());
    }
}
