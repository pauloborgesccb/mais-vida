import { ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import { EstadoService } from "../estado.service";
import { Estado } from "../../model/estado";
import { ActivatedRoute, Router } from "@angular/router";
import { PessoaService } from "../pessoa.service";
import { Pessoa } from "../../model/pessoa";
import { Documento } from "../../model/documento";
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from "@angular/material";
import { DocumentoService } from "../documento.service";

@Component({
  selector: 'app-pessoa-page',
  templateUrl: './pessoa-page.component.html',
  styleUrls: ['./pessoa-page.component.css']
})
export class PessoaPageComponent implements OnInit {

  estados: Array<Estado> = [];
  idPessoa: number;
  noPessoa: string;
  idEstado: number;
  documentos: Array<Documento> = [];

  constructor(
    private srvEstado: EstadoService,
    private srvPessoa: PessoaService,
    private srvDocumento: DocumentoService,
    private router: Router,
    private dialog: MatDialog,
    private changeDetectorRefs: ChangeDetectorRef,
    private route: ActivatedRoute) {
    this.idPessoa = this.route.snapshot.params.id;
    if (this.idPessoa) {
      this.srvPessoa.getPessoa(this.idPessoa).subscribe(
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

  salvar() {
    let pessoa: Pessoa = new Pessoa();
    let estado: Estado = new Estado();
    if (this.idPessoa) {
      pessoa.idPessoa = this.idPessoa;
    }
    estado.idEstado = this.idEstado;
    pessoa.noPessoa = this.noPessoa;
    pessoa.estado = estado;
    pessoa.documentos = this.documentos;
    this.srvPessoa.salvarPessoa(pessoa).subscribe(
      () => {
        this.router.navigate(['/home']).then(e => {
          if (e) {
            alert('Pessoa salva com sucesso');
          } else {
            console.log("Navigation has failed!");
          }
        });
      },
      () => {alert('Não foi possivel salvar registro')}
    )
  }

  addDocumento() {
    const dialogRef = this.dialog.open(DialogAddDocumento, {
      width: '450px',
      data: new Documento()
    });

    dialogRef.afterClosed().subscribe(documento => {
      let docs = this.documentos;
      this.documentos = [];
      setTimeout(()=> {
        docs.push(documento);
        this.documentos = docs;
        this.changeDetectorRefs.detectChanges();
      });

    });
  }

  removerDoc(documento: Documento) {
    if (documento.idDocumento) {
      this.srvDocumento.removeDocumento(documento.idDocumento).
        subscribe(
        () => {
          this.atualizarListaDocsRemovidos(documento);
          alert('Documento removido da base dados');
        },
        () => {
          alert('Não foi possivel remover registro');
        }
      );
      return;
    }
    this.atualizarListaDocsRemovidos(documento);


  }

  private atualizarListaDocsRemovidos(documento) {
    let docs = this.documentos;
    this.documentos = [];
    setTimeout(()=> {
      let index = docs.indexOf(documento);
      if (index !== -1) docs.splice(index, 1);
      this.documentos = docs;
      this.changeDetectorRefs.detectChanges();
    });
  }
}

@Component({
  selector: 'dialog-add-documento',
  templateUrl: 'dialog-add-documento.html',
})
export class DialogAddDocumento {

  constructor(
    public dialogRef: MatDialogRef<DialogAddDocumento>,
    @Inject(MAT_DIALOG_DATA) public documento: Documento) {}

  cancelar(): void {
    this.dialogRef.close();
  }

}
