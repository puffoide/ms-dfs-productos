package dfs.s3.ms_dfs_productos.controller;

import dfs.s3.ms_dfs_productos.model.Envio;
import dfs.s3.ms_dfs_productos.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/envios")
public class ProductosController {

    private static final Logger log = LoggerFactory.getLogger(ProductosController.class);

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> getAllEnvios() {
        log.info("GET /envios");
        log.info("Retornando el estado de todos los envios.");
        return envioService.getAllEnvios();
    }

    @GetMapping("/seguimiento/{id}")
    public Envio getEnvioById(@PathVariable Long id) {
        return envioService.getEnvioById(id);
    }

    @GetMapping("/pendientes")
    public List<Envio> getEnviosPendientes() {
        log.info("GET /pendientes");
        log.info("Retornando todos los envios pendientes.");
        return envioService.getEnviosPendientes();
    }

    @PostMapping
    public Envio createEnvio(@RequestBody Envio envio) {
        return envioService.createEnvio(envio);
    }

    @PutMapping("/{id}")
    public Envio updateEnvio(@PathVariable Long id, @RequestBody Envio envioDetails) {
        return envioService.updateEnvio(id, envioDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable Long id) {
        envioService.deleteEnvio(id);
    }

}
