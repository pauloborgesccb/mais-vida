import { Component, OnInit } from '@angular/core';
import { EstadoService } from "../estado.service";
import { Estado } from "../../model/estado";
import { ActivatedRoute } from "@angular/router";
import { PessoaService } from "../pessoa.service";
import { Pessoa } from "../../model/pessoa";
import { Documento } from "../../model/documento";

@Component({
  selector: 'app-pessoa-page',
  templateUrl: './pessoa-page.component.html',
  styleUrls: ['./pessoa-page.component.css']
})
export class PessoaPageComponent implements OnInit {

  estados: Array<Estado> = [];
  noPessoa: string;
  idEstado: number;
  documentos: Array<Documento> = [];

  constructor(private srvEstado: EstadoService, private srvPessoa: PessoaService, private route: ActivatedRoute) {
    let idPessoa: number = this.route.snapshot.params.id;
    if (idPessoa) {
      this.srvPessoa.getPessoa(idPessoa).subscribe(
        (pessoa: Pessoa) => {
          this.noPessoa = pessoa.noPessoa;
          this.idEstado = pessoa.estado.idEstado;
          this.documentos = pessoa.documentos;
        }
      );
    }

  }

  ngOnInit() {
    this.srvEstado.listaEstados().subscribe(
      (estados: Array<Estado>) => {
        this.estados = estados;
      }
    );
  }

}
