package dfs.s3.ms_dfs_productos.model;

import java.util.List;

public class Producto {
    private int id;
    private String nombre;
    private List<Envio> envio;

    public Producto(int id, String nombre, List<Envio> envio) {
        this.id = id;
        this.nombre = nombre;
        this.envio = envio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Envio> getEnvio() {
        return envio;
    }

    public void setenvio(List<Envio> envio) {
        this.envio = envio;
    }

}
