package br.med.maisvidas.resource;

import br.med.maisvidas.builder.Resposta;
import br.med.maisvidas.builder.RespostaBuilder;
import br.med.maisvidas.model.Documento;
import br.med.maisvidas.service.DocumentoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/documento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DocumentoResource {

    @Autowired
    private DocumentoService documentoService;

    @ApiOperation(value = "Retorna todas documentos de uma pessoa")
    @GetMapping(value = "/pessoa/{idPessoa}")
    @ResponseBody
    public ResponseEntity<?> getDocumentos(@PathVariable("idProposta") int idPessoa) {
        List<Documento> documentos = this.documentoService.listarDocumentosPessoa(idPessoa);
        Resposta resposta = RespostaBuilder.getBuilder().resposta(documentos).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna documento")
    @GetMapping(value = "/{idDocumento}")
    @ResponseBody
    public ResponseEntity<?> getDocumento(@PathVariable("idDocumento") int idDocumento) {
        Documento documento = this.documentoService.listarDocumento(idDocumento);
        Resposta resposta = RespostaBuilder.getBuilder().resposta(documento).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @ApiOperation(value = "Deletar documento")
    @DeleteMapping(value = "/{idDocumento}")
    @ResponseBody
    public ResponseEntity<Resposta> delete(@PathVariable("idDocumento") int idDocumento) {
        this.documentoService.remover(idDocumento);
        Resposta resposta = RespostaBuilder.getBuilder().resposta("Documento removido com sucesso").build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @ApiOperation(value = "Atualizar documento")
    @PutMapping(value = "/{idDocumento}")
    @ResponseBody
    public ResponseEntity<Resposta> update(
            @PathVariable("idDocumento") int idDocumento,
            @Validated @RequestBody Documento documentoData
    ) {
        Documento documento = this.documentoService.atualizar(idDocumento, documentoData);
        Resposta resposta = RespostaBuilder.getBuilder().resposta(documento).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @ApiOperation(value = "Criar novo documento")
    @PutMapping(value = "")
    @ResponseBody
    public ResponseEntity<Resposta> create(
            @Validated @RequestBody Documento documentoData
    ) {
        Documento documento = this.documentoService.criar(documentoData);
        Resposta resposta = RespostaBuilder.getBuilder().resposta(documento).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }
}
