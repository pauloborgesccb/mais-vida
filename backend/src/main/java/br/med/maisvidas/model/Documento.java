package br.med.maisvidas.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "tb_documento", schema = "db_mais_vida", catalog = "")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento", nullable = false)
    private int idDocumento;

    @Basic
    @NotNull(message = "Número do documento obrigatório")
    @Column(name = "no_numero", nullable = true, length = 45)
    private String noNumero;

    @Basic
    @NotNull(message = "Tipo do documento obrigatório")
    @Column(name = "no_tipo", nullable = true, length = 200)
    private String noTipo;

    @ManyToOne
    @JsonBackReference
    @NotNull(message = "O documento deve estar associado a uma pessoa")
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
}

