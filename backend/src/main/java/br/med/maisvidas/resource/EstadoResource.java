package br.med.maisvidas.resource;

import br.med.maisvidas.builder.Resposta;
import br.med.maisvidas.builder.RespostaBuilder;
import br.med.maisvidas.model.Estado;
import br.med.maisvidas.service.EstadoService;
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
@RequestMapping(value = "/pessoa", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;

    @ApiOperation(
            value = "Retorna todas Uf's"
    )
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<?> getUf() {
        List<Estado> estados = this.estadoService.listarTodosEstados();
        Resposta resposta = RespostaBuilder.getBuilder().resposta(estados).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }
}
