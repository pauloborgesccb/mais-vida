import { Injectable } from '@angular/core';
import { environment } from "../environments/environment";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Pessoa } from "../model/pessoa";

@Injectable({
  providedIn: 'root'
})
export class PessoaService {
  env = environment;
  constructor(private httpClient: HttpClient) { }

  getPessoas() {
    return this.httpClient.get(this.env.pessoa)
      .pipe(
        map(
          (res: any) => res.resposta
        )
      );
  }

  removerPessoa(idPessoa: number) {
    return this.httpClient.delete(this.env.pessoa + '/' + idPessoa);
  }

  salvarPessoa(pessoa: Pessoa) {
    if (pessoa.idPessoa) {
      return this.httpClient.put(this.env.pessoa + '/' + pessoa.idPessoa, pessoa);
    }
    return this.httpClient.post(this.env.pessoa , pessoa);
  }

  getPessoa(idPessoa: number) {
    return this.httpClient.get(this.env.pessoa + "/" + idPessoa)
      .pipe(
        map(
          (res: any) => res.resposta
        )
      );
  }
}
