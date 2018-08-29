package br.med.maisvidas.service;

import br.med.maisvidas.model.Estado;
import br.med.maisvidas.model.Pessoa;
import br.med.maisvidas.repository.EstadoRepository;
import br.med.maisvidas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodasPessoas() {
        return this.pessoaRepository.findAll();
    }
}
