package dfs.s3.ms_dfs_productos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductosNotFoundException extends RuntimeException {

    public ProductosNotFoundException(String message) {
        super(message);
    }
}
