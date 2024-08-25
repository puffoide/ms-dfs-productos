package dfs.s3.ms_dfs_productos.controller;

import org.springframework.web.bind.annotation.RestController;

import dfs.s3.ms_dfs_productos.model.Envio;
import dfs.s3.ms_dfs_productos.model.Producto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Arrays;


@RestController
public class ProductosController {
    private List<Producto> productos = new ArrayList<>();

    public ProductosController() {
        // Inicializar lista de productos con datos de envío

        productos.add(new Producto(1, "Arena sanitaria TOP K9 10 kg",
                Arrays.asList(
                        new Envio(1, "Despachado", "Sucursal San Joaquín", "Chilexpress", "4534245"),
                        new Envio(4, "Despachado", "Sucursal Santiago Centro", "Starken", "3000443"),
                        new Envio(7, "Pendiente", "En bodega", null, null))));

        productos.add(new Producto(2, "Alimento para Perro Adulto Champion DOG 15 kg",
                Arrays.asList(
                        new Envio(2, "Despachado", "Sucursal San Joaquín", "Chilexpress", "5344245"),
                        new Envio(5, "Despachado", "Sucursal San Joaquín", "Starken", "3030443"),
                        new Envio(8, "Pendiente", "En bodega", null, null))));

        productos.add(new Producto(3, "Alimento para Gato Adulto Whiskas 10 kg",
                Arrays.asList(
                        new Envio(3, "Despachado", "Sucursal San Joaquín", "Chilexpress", "5665691"),
                        new Envio(6, "Despachado", "Sucursal San Joaquín", "Starken", "6569453"),
                        new Envio(9, "Pendiente", "En bodega", null, null))));

    }

    @GetMapping("/seguimiento/{pedido}")
    public Envio getEnvioByPedido(@PathVariable int pedido) {
        for (Producto producto : productos) {
            Optional<Envio> envioOptional = producto.getEnvio().stream()
                    .filter(envio -> envio.getPedido() == pedido).findFirst();
            if (envioOptional.isPresent()) {
                return envioOptional.get();
            }
        }

        return null;
    }

    @GetMapping("/pendientes")
    public List<Envio> getProductosPendientes() {
    
        List<Envio> enviosPendientes = productos.stream()
        .flatMap(producto -> producto.getEnvio().stream())
        .filter(envio -> "Pendiente".equals(envio.getEstado()))
        .collect(Collectors.toList());

        return enviosPendientes;

    }

}
