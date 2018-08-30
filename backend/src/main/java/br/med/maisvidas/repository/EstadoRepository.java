package br.med.maisvidas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.med.maisvidas.model.Estado;
import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findAll();

}
