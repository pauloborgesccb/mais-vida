package br.med.maisvidas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.med.maisvidas.model.Documento;
import br.med.maisvidas.model.Pessoa;
import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    List<Documento> findAllByPessoa(Pessoa pessoa);
    Documento findByIdDocumento(int idDocumento);
    void deleteByIdDocumento(int idDocumento);
    List<Documento> findAll();
}
