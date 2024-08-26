package dfs.s3.ms_dfs_productos.controller;

import org.springframework.web.bind.annotation.RestController;

import dfs.s3.ms_dfs_productos.model.Envio;
import dfs.s3.ms_dfs_productos.model.Producto;
import dfs.s3.ms_dfs_productos.service.ProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productosService.getListaProductos();
    }

    @GetMapping("/seguimiento/{pedido}")
    public Envio getEnvioByPedido(@PathVariable int pedido) {
        return productosService.getEnvioByPedido(pedido);
    }

    @GetMapping("/pendientes")
    public List<Envio> getProductosPendientes() {
        return productosService.getProductosPendientes();
    }

}
