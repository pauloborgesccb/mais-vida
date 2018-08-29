package br.med.maisvidas.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tb_pessoa", schema = "db_mais_vida", catalog = "")
public class Pessoa {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_pessoa", nullable = false)
    private int idPessoa;

    @Basic
    @NotNull(message = "Nome da pessoa é um campo obrigatório")
    @Column(name = "no_pessoa", nullable = false, length = 200)
    private String noPessoa;

    @OneToOne
    @NotNull(message = "A pessoa pessoa deve estar associada a um estado federativo")
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(targetEntity = Documento.class, mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<Documento> documentos;

}
