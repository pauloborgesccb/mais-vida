package br.med.maisvidas.model;

import lombok.EqualsAndHashCode;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "tb_estado", schema = "db_mais_vida", catalog = "")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", nullable = false)
    private int idEstado;

    @Basic
    @Column(name = "no_estado", nullable = true, length = 45)
    private String noEstado;

    @Basic
    @Column(name = "sg_estado", nullable = true, length = 2)
    private String sgEstado;
}
