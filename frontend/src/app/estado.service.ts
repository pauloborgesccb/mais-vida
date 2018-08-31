import { Injectable } from '@angular/core';
import { environment } from "../environments/environment";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  env = environment;
  constructor(private httpClient: HttpClient) { }

  listaEstados() {
    return this.httpClient.get(this.env.estado)
      .pipe(
        map(
          (res: any) => res.resposta
        )
      );
  }
}
