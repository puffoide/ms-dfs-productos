package dfs.s3.ms_dfs_productos.controller;

import org.springframework.web.bind.annotation.RestController;

import dfs.s3.ms_dfs_productos.model.Envio;
import dfs.s3.ms_dfs_productos.model.Producto;
import dfs.s3.ms_dfs_productos.service.ProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping("/productos")
    public ResponseEntity<List <Producto>> getProductos() {
        List<Producto> producto = productosService.getListaProductos();
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/seguimiento/{pedido}")
    public ResponseEntity<Envio> getEnvioByPedido(@PathVariable int pedido) {
        Envio envio = productosService.getEnvioByPedido(pedido);
        if(envio == null) {
            return ResponseEntity.notFound().build();
        } else
        
        return ResponseEntity.ok(envio);
    }

    @GetMapping("/pendientes")
    public ResponseEntity<List<Envio>> getProductosPendientes() {
        List <Envio> envio = productosService.getProductosPendientes();
        return ResponseEntity.ok(envio);
    }

}
