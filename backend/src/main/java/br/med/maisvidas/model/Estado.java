package br.med.maisvidas.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_estado", schema = "db_mais_vida", catalog = "")
public class Estado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_estado", nullable = false)
    private int idEstado;

    @Basic
    @Column(name = "no_estado", nullable = true, length = 45)
    private String noEstado;

    @Basic
    @Column(name = "sg_estado", nullable = true, length = 2)
    private String sgEstado;
}
