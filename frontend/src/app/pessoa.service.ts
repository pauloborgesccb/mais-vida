import { Injectable } from '@angular/core';
import { environment } from "../environments/environment";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";

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

  getPessoa(idPessoa: number) {
    return this.httpClient.get(this.env.pessoa + "/" + idPessoa)
      .pipe(
        map(
          (res: any) => res.resposta
        )
      );
  }
}
