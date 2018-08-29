package br.med.maisvidas.service;

import br.med.maisvidas.model.Estado;
import br.med.maisvidas.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listarTodosEstados() {
        return this.estadoRepository.findAll();
    }
}
