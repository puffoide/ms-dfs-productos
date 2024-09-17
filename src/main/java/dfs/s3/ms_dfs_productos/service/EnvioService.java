package dfs.s3.ms_dfs_productos.service;

import dfs.s3.ms_dfs_productos.model.Envio;

import java.util.List;

public interface EnvioService {
    Envio createEnvio(Envio envio);
    
    List<Envio> getAllEnvios();
    Envio getEnvioById(Long id);
    Envio updateEnvio(Long id, Envio envioDetails);
    void deleteEnvio(Long id);
    List<Envio> getEnviosPendientes();
}
