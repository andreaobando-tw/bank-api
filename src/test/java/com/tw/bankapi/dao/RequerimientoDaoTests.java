package com.tw.bankapi.dao;
import com.tw.bankapi.dao.repository.RequerimientoRepository;
import com.tw.bankapi.entities.RequerimientoEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RequerimientoDaoTests {

    @Mock
    RequerimientoRepository requerimientoRepository = Mockito.mock(RequerimientoRepository.class);

    @Test
    public void shouldReturnRequerimientoEntityWhenRequerimientoRepositoryReturnData() {
        RequerimientoEntity dataToInsert = new RequerimientoEntity();
        RequerimientoDao requerimientoDao = new RequerimientoDao(requerimientoRepository);
        dataToInsert.setCorreo("test@tes.com");
        dataToInsert.setDescripcion("description");
        dataToInsert.setCategoriaId(1);
        dataToInsert.setFechaCreacion(LocalDate.of(2022, 1, 8));

        Mockito.when(requerimientoRepository.save(dataToInsert)).thenReturn(dataToInsert);

        RequerimientoEntity entityResult = requerimientoDao.save(dataToInsert);

        Mockito.verify(requerimientoRepository, Mockito.times(1)).save(dataToInsert);
        assertNotNull(entityResult);
    }

    @Test
    public void shouldReturnExeptionWhenRequerimientoRepositoryReturnException() {
        String errorExceptionMessage = "errorExceptionMessage";
        RequerimientoEntity dataToInsert = new RequerimientoEntity();
        RequerimientoDao requerimientoDao = new RequerimientoDao(requerimientoRepository);
        Mockito.when(requerimientoRepository.save(dataToInsert)).thenThrow(new Error(errorExceptionMessage));

        Error entityResultException = assertThrows(Error.class, () -> {
            requerimientoDao.save(dataToInsert);
        });

        Mockito.verify(requerimientoRepository, Mockito.times(1)).save(dataToInsert);
        assertEquals(errorExceptionMessage, entityResultException.getMessage());
    }
}
