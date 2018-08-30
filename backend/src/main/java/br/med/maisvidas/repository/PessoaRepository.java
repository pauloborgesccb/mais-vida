package br.med.maisvidas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.med.maisvidas.model.Pessoa;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByIdPessoa(int idPessoa);
    void deleteByIdPessoa(int idPessoa);
    List<Pessoa> findAll();
}
