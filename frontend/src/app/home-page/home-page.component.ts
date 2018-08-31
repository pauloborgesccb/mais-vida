import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { PessoaService } from "../pessoa.service";
import { Pessoa } from "../../model/pessoa";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  title: 'lista de pessoas';
  pessoas: Array<Pessoa> = [];
  constructor(private srvPessoa: PessoaService, private router: Router) {}

  ngOnInit() {
    this.srvPessoa.getPessoas().subscribe(
      (pessoas: Array<Pessoa>) => {
        this.pessoas = pessoas;
      }
    );
  }

  public criarPessoa(url, id) {
    this.router.navigate([url, id]).then(e => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

}
