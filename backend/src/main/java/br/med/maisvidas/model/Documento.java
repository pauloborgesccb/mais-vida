package br.med.maisvidas.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_documento", schema = "db_mais_vida", catalog = "")
public class Documento {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_documento", nullable = false)
    private int idDocumento;

    @Basic
    @Column(name = "no_numero", nullable = true, length = 45)
    private String noNumero;

    @Basic
    @Column(name = "no_tipo", nullable = true, length = 200)
    private String noTipo;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
}
