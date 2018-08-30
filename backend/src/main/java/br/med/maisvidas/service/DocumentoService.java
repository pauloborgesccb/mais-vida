package br.med.maisvidas.service;

import br.med.maisvidas.model.Documento;
import br.med.maisvidas.model.Pessoa;
import br.med.maisvidas.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> listarDocumentosPessoa(int idPessoa) {
        Pessoa pessoa =  new Pessoa();
        pessoa.setIdPessoa(idPessoa);
        return this.documentoRepository.findAllByPessoa(pessoa);
    }

    public void remover(int idDocumento) {
        this.documentoRepository.deleteByIdDocumento(idDocumento);
    }

    public Documento atualizar(int idDocumento, Documento documento) {
        documento.setIdDocumento(idDocumento);
        return this.documentoRepository.save(documento);
    }

    public Documento criar(Documento documento) {
        return this.documentoRepository.save(documento);
    }

    public Documento listarDocumento(int idDocumento) {
        return this.documentoRepository.findByIdDocumento(idDocumento);
    }
}
