package dfs.s3.ms_dfs_productos.service;

import dfs.s3.ms_dfs_productos.model.Envio;
import dfs.s3.ms_dfs_productos.repository.EnvioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EnvioServiceTest {

    @InjectMocks
    private EnvioServiceImpl envioService;

    @Mock
    private EnvioRepository envioRepository;

    @Test
    public void testCreateEnvio() {
        Envio envio = new Envio();
        envio.setCodSeguimiento("XYZ789");

        when(envioRepository.save(any(Envio.class))).thenReturn(envio);

        Envio result = envioService.createEnvio(envio);

        assertEquals("XYZ789", result.getCodSeguimiento());
        verify(envioRepository, times(1)).save(envio);
    }

    @Test
    public void testUpdateEnvio() {
        Envio existingEnvio = new Envio();
        existingEnvio.setId(1L);
        existingEnvio.setCodSeguimiento("4534245");
        existingEnvio.setEstado("Pendiente");

        Envio updatedEnvio = new Envio();
        updatedEnvio.setEstado("Despachado");

        when(envioRepository.findById(1L)).thenReturn(Optional.of(existingEnvio));
        when(envioRepository.save(any(Envio.class))).thenReturn(updatedEnvio);

        Envio result = envioService.updateEnvio(1L, updatedEnvio);

        assertEquals("Despachado", result.getEstado());
        verify(envioRepository, times(1)).save(updatedEnvio);
    }

}
