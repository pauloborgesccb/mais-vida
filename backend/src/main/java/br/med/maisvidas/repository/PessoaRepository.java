package br.med.maisvidas.repository;

import br.med.maisvidas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findAll();

    Pessoa findAllByIdPessoa(int idPessoa);
}
