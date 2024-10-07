package dfs.s3.ms_dfs_productos.controller;

import dfs.s3.ms_dfs_productos.model.Envio;
import dfs.s3.ms_dfs_productos.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/envios")
public class ProductosController {

    private static final Logger log = LoggerFactory.getLogger(ProductosController.class);

    @Autowired
    private EnvioService envioService;

    // Obtener todos los envíos 
    @GetMapping
    public CollectionModel<EntityModel<Envio>> getAllEnvios() {
        log.info("GET /envios");
        log.info("Retornando el estado de todos los envios.");
        List<Envio> envios = envioService.getAllEnvios();

        List<EntityModel<Envio>> envioResources = envios.stream()
            .map(envio -> EntityModel.of(envio,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(envio.getId())).withSelfRel()))
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios());
        return CollectionModel.of(envioResources, linkTo.withRel("envios"));
    }

    // Obtener un envío por ID 
    @GetMapping("/seguimiento/{id}")
    public EntityModel<Envio> getEnvioById(@PathVariable Long id) {
        log.info("GET /seguimiento/" + id);
        Optional<Envio> envio = Optional.ofNullable(envioService.getEnvioById(id));

        if (envio.isPresent()) {
            return EntityModel.of(envio.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("all-envios"));
        } else {
            throw new EnvioNotFoundException("Envio not found with id: " + id);
        }
    }

    // Obtener envíos pendientes 
    @GetMapping("/pendientes")
    public CollectionModel<EntityModel<Envio>> getEnviosPendientes() {
        log.info("GET /pendientes");
        log.info("Retornando todos los envios pendientes.");
        List<Envio> envios = envioService.getEnviosPendientes();

        List<EntityModel<Envio>> envioResources = envios.stream()
            .map(envio -> EntityModel.of(envio,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(envio.getId())).withSelfRel()))
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnviosPendientes());
        return CollectionModel.of(envioResources, linkTo.withRel("envios-pendientes"));
    }

    // Crear un nuevo envío 
    @PostMapping
    public EntityModel<Envio> createEnvio(@Validated @RequestBody Envio envio) {
        log.info("POST /envios");
        Envio createdEnvio = envioService.createEnvio(envio);
        return EntityModel.of(createdEnvio,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(createdEnvio.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("all-envios"));
    }

    // Actualizar un envío 
    @PutMapping("/{id}")
    public EntityModel<Envio> updateEnvio(@PathVariable Long id, @Validated @RequestBody Envio envioDetails) {
        log.info("PUT /envios/" + id);
        Envio updatedEnvio = envioService.updateEnvio(id, envioDetails);
        return EntityModel.of(updatedEnvio,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEnvioById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEnvios()).withRel("all-envios"));
    }

    // Eliminar un envío
    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable Long id) {
        log.info("DELETE /envios/" + id);
        envioService.deleteEnvio(id);
    }

    // Clase para manejar excepciones
    static class EnvioNotFoundException extends RuntimeException {
        public EnvioNotFoundException(String message) {
            super(message);
        }
    }
}
