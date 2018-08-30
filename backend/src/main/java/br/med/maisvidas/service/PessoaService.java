package br.med.maisvidas.service;

import br.med.maisvidas.model.Pessoa;
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

    public Pessoa listarPessoa(int idPessoa) {
        return this.pessoaRepository.findByIdPessoa(idPessoa);
    }

    public void remover(int idPessoa) {
        this.pessoaRepository.deleteByIdPessoa(idPessoa);
    }

    public Pessoa atualizar(int idPessoa, Pessoa Pessoa) {
        Pessoa.setIdPessoa(idPessoa);
        return this.pessoaRepository.save(Pessoa);
    }

    public Pessoa criar(Pessoa Pessoa) {
        return this.pessoaRepository.save(Pessoa);
    }
}
