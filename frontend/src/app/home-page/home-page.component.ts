import { Component, Inject, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { PessoaService } from "../pessoa.service";
import { Pessoa } from "../../model/pessoa";
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from "@angular/material";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  title: 'lista de pessoas';
  pessoas: Array<Pessoa> = [];
  constructor(private srvPessoa: PessoaService, private router: Router, private dialog: MatDialog) {}

  ngOnInit() {
    this.carregaPessoas();
  }

  removerPessoa(idPessoa: number) {
    const dialogRef = this.dialog.open(DialogRemoverPessoa, {
      width: '250px',
      data: {idPessoa: idPessoa}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.carregaPessoas();
      console.log('The dialog was closed');
    });
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

  private carregaPessoas() {
    this.srvPessoa.getPessoas().subscribe(
      (pessoas: Array<Pessoa>) => {
        this.pessoas = pessoas;
      }
    );
  }

}

@Component({
  selector: 'dialog-remover-pessoa',
  templateUrl: 'dialog-remover-pessoa.html',
})
export class DialogRemoverPessoa {

  constructor(
    public dialogRef: MatDialogRef<DialogRemoverPessoa>,
    private srvPessoa: PessoaService,
    @Inject(MAT_DIALOG_DATA) public pessoa: Pessoa) {}

  remover(): void {
    this.srvPessoa.removerPessoa(this.pessoa.idPessoa).subscribe(
      () => {
        alert('Pessoa removida com sucesso');
        this.dialogRef.close();
      },
      () => {
        alert('Não foi possível remover o registro');
        this.dialogRef.close();
      }
    );
  }

}
