package dfs.s3.ms_dfs_productos.repository;

import dfs.s3.ms_dfs_productos.model.Envio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EnvioRepositoryTest {

    @Autowired
    private EnvioRepository envioRepository;

    @Test
    public void testSaveEnvio() {
        Envio envio = new Envio();
        envio.setCodSeguimiento("11111111");
        envio.setProductoNombre("Producto de prueba");
        envio.setEstado("Pendiente");

        Envio savedEnvio = envioRepository.save(envio);
 
 
        assertNotNull(savedEnvio.getId());
        assertEquals("11111111", savedEnvio.getCodSeguimiento());
    }

    
}
