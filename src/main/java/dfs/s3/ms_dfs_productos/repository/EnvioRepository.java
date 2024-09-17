package dfs.s3.ms_dfs_productos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dfs.s3.ms_dfs_productos.model.Envio;
public interface EnvioRepository extends JpaRepository<Envio, Long> {

    
}
