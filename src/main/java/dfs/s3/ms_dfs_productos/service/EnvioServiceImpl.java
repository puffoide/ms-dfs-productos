package dfs.s3.ms_dfs_productos.service;

import dfs.s3.ms_dfs_productos.model.Envio;
import dfs.s3.ms_dfs_productos.repository.EnvioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnvioServiceImpl implements EnvioService {

    private static final Logger log = LoggerFactory.getLogger(EnvioServiceImpl.class);

    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public List<Envio> getAllEnvios() {
        return envioRepository.findAll();
    }

    @Override
    public Envio createEnvio(Envio envio) {
        return envioRepository.save(envio);
    }

    @Override
    public Envio getEnvioById(Long id) {
        return envioRepository.findById(id).orElse(null);
    }

    @Override
    public Envio updateEnvio(Long id, Envio envioDetails) {
        return envioRepository.findById(id).map(envio -> {
            envio.setEstado(envioDetails.getEstado());
            envio.setUbicacion(envioDetails.getUbicacion());
            envio.setDistribuidor(envioDetails.getDistribuidor());
            envio.setCodSeguimiento(envioDetails.getCodSeguimiento());
            return envioRepository.save(envio);
        }).orElse(null);
    }

    @Override
    public void deleteEnvio(Long id) {
        envioRepository.deleteById(id);
    }

    @Override
    public List<Envio> getEnviosPendientes() {
        return envioRepository.findAll().stream()
                .filter(envio -> "Pendiente".equals(envio.getEstado()))
                .toList();
    }
}
