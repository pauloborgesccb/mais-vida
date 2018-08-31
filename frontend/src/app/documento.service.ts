import { Injectable } from '@angular/core';
import { map } from "rxjs/operators";
import { environment } from "../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Pessoa } from "../model/pessoa";

@Injectable({
  providedIn: 'root'
})
export class DocumentoService {
  env = environment;
  constructor(private httpClient: HttpClient) { }

  getDocumentosPessoa(pessoa: Pessoa) {
    return this.httpClient.get(this.env.documento + '?idPessoa=' + pessoa.idPessoa)
      .pipe(
        map(
          (res: any) => res.resposta
        )
      );
  }
}
