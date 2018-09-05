package br.med.maisvidas.resource;

import br.med.maisvidas.builder.Resposta;
import br.med.maisvidas.builder.RespostaBuilder;
import br.med.maisvidas.model.Pessoa;
import br.med.maisvidas.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @ApiOperation(value = "Retorna todas pessoas")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<?> getPessoas() {
        List<Pessoa> pessoas = this.pessoaService.listarTodasPessoas();
        Resposta resposta = RespostaBuilder.getBuilder().resposta(pessoas).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna pessoa")
    @GetMapping(value = "/{idPessoa}")
    @ResponseBody
    public ResponseEntity<?> getPessoa(@PathVariable("idPessoa") int idPessoa) {
        Pessoa pessoa = this.pessoaService.listarPessoa(idPessoa);
        Resposta resposta = RespostaBuilder.getBuilder().resposta(pessoa).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @ApiOperation(value = "Deletar pessoa")
    @DeleteMapping(value = "/{idPessoa}")
    @ResponseBody
    public ResponseEntity<Resposta> delete(@PathVariable("idPessoa") int idPessoa) {
        this.pessoaService.remover(idPessoa);
        Resposta resposta = RespostaBuilder.getBuilder().resposta("Pessoa removido com sucesso").build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @ApiOperation(value = "Atualizar pessoa")
    @PutMapping(value = "/{idPessoa}")
    @ResponseBody
    public ResponseEntity<Resposta> update(
            @PathVariable("idPessoa") int idPessoa,
            @Validated @RequestBody Pessoa pessoaData
    ) {
        Pessoa pessoa = this.pessoaService.atualizar(idPessoa, pessoaData);
        Resposta resposta = RespostaBuilder.getBuilder().resposta(pessoa).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @ApiOperation(value = "Criar nova pessoa")
    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<Resposta> create(
            @Validated @RequestBody Pessoa pessoaData
    ) {
        Pessoa pessoa = this.pessoaService.criar(pessoaData);
        Resposta resposta = RespostaBuilder.getBuilder().resposta(pessoa).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }
}
