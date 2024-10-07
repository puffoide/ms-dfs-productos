package dfs.s3.ms_dfs_productos.controller;

import dfs.s3.ms_dfs_productos.model.Envio;
import dfs.s3.ms_dfs_productos.service.EnvioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(ProductosController.class)
public class ProductosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnvioService envioService;

    @Test
    public void testGetAllEnvios() throws Exception {
        Envio envio1 = new Envio();
        envio1.setId(1L);
        envio1.setCodSeguimiento("4534245");

        Envio envio2 = new Envio();
        envio2.setId(2L);
        envio2.setCodSeguimiento("3000443");

        List<Envio> envios = List.of(envio1, envio2);

        when(envioService.getAllEnvios()).thenReturn(envios);

        mockMvc.perform(get("/api/envios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.envioList[0].codSeguimiento").value("4534245"))
                .andExpect(jsonPath("$._embedded.envioList[1].codSeguimiento").value("3000443"));

    }

    @Test
    public void testGetEnvioById() throws Exception {
        Envio envio = new Envio();
        envio.setId(3L);
        envio.setCodSeguimiento("543210");

        when(envioService.getEnvioById(3L)).thenReturn(envio);

        mockMvc.perform(get("/api/envios/seguimiento/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codSeguimiento").value("543210"));
    }

    

}
