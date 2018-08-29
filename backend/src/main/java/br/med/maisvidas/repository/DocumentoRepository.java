package br.med.maisvidas.repository;

import br.med.maisvidas.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
