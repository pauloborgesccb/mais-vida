package br.med.maisvidas.repository;

import br.med.maisvidas.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findAll();

    Estado findByIdEstado(int idEstado);
}
