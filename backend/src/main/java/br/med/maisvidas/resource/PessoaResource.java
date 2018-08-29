package br.med.maisvidas.resource;

import br.med.maisvidas.builder.Resposta;
import br.med.maisvidas.builder.RespostaBuilder;
import br.med.maisvidas.model.Estado;
import br.med.maisvidas.model.Pessoa;
import br.med.maisvidas.service.EstadoService;
import br.med.maisvidas.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @ApiOperation(
            value = "Retorna todas pessoas"
    )
    @GetMapping(value = "/pessoa")
    @ResponseBody
    public ResponseEntity<?> getPessoas() {
        List<Pessoa> pessoas = this.pessoaService.listarTodasPessoas();
        Resposta resposta = RespostaBuilder.getBuilder().resposta(pessoas).build();
        return new ResponseEntity<Resposta>(resposta, HttpStatus.OK);
    }
}
