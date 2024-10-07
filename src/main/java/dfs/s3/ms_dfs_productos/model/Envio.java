package dfs.s3.ms_dfs_productos.model;

import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "envio")
public class Envio extends RepresentationModel<Envio> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cod_seguimiento")
    @NotNull(message = "El código de seguimiento no puede estar vacío")
    @Size(min = 1, message = "El código de seguimiento debe tener al menos un carácter")
    // @Pattern(regexp = "\\d+", message = "El código de seguimiento solo puede contener números")
    private String cod_seguimiento;

    @Column(name = "distribuidor")
    private String distribuidor;

    @Column(name = "estado")
    @NotNull(message = "El estado no puede estar vacío")
    @Pattern(regexp = "Pendiente|En tránsito|Entregado", message = "Estado debe ser 'Pendiente', 'En tránsito' o 'Entregado'")
    private String estado;

    @Column(name = "producto_nombre")
    @NotNull(message = "El nombre del producto no puede estar vacío")
    @Size(min = 1, message = "El nombre del producto debe tener al menos un carácter")
    private String producto_nombre;

    @Column(name = "ubicacion")
    @Size(min = 1, max = 100, message = "La ubicación debe tener entre 1 y 100 caracteres")
    private String ubicacion;


    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodSeguimiento() {
        return cod_seguimiento;
    }

    public void setCodSeguimiento(String cod_seguimiento) {
        this.cod_seguimiento = cod_seguimiento;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProductoNombre() {
        return producto_nombre;
    }

    public void setProductoNombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
