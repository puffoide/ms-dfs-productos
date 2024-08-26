package dfs.s3.ms_dfs_productos.model;

public class Envio {
    private int pedido;
    private String estado;
    private String ubicacion;
    private String distribuidor;
    private String codSeguimiento;

    public Envio(int pedido, String estado, String ubicacion, String distribuidor, String codSeguimiento) {
        this.pedido = pedido;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.distribuidor = distribuidor;
        this.codSeguimiento = codSeguimiento;
    }

    public int getPedido() {
        return pedido;
    }

    public String getEstado() {
        return estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public String getCodSeguimiento() {
        return codSeguimiento;
    }

}


