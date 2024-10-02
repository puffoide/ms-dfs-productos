// package dfs.s3.ms_dfs_productos.controller;

// import dfs.s3.ms_dfs_productos.model.Envio;
// import dfs.s3.ms_dfs_productos.service.EnvioService;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.hateoas.EntityModel;
// import org.springframework.test.web.servlet.MockMvc;

// import java.util.List;
// import java.util.stream.Collectors;

// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import static org.hamcrest.Matchers.is;

// @WebMvcTest(ProductosController.class)
// public class ProductosControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private EnvioService envioService;

//     @Test
//     public void testGetAllEnvios() throws Exception {
//         Envio envio1 = new Envio();
//         envio1.setId(1L);
//         envio1.setCodSeguimiento("ABC123");

//         Envio envio2 = new Envio();
//         envio2.setId(2L);
//         envio2.setCodSeguimiento("DEF456");

//         List<Envio> envios = List.of(envio1, envio2);

//         when(envioService.getAllEnvios()).thenReturn(envios);

//         mockMvc.perform(get("/api/envios"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$._embedded.envios[0].codSeguimiento").value("ABC123"))
//                 .andExpect(jsonPath("$._embedded.envios[1].codSeguimiento").value("DEF456"));

//     }

// }
