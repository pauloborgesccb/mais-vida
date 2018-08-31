import { Pessoa } from "./pessoa";

export class Documento {

  idDocumento: number;
  noNumero: string;
  noTipo: string;
  pessoa: Pessoa;

  constructor(data?) {
    if (data) {
      this.idDocumento = data.idDocumento;
      this.noNumero = data.noNumero;
      this.noTipo = data.noTipo;
      this.pessoa = new Pessoa(data.pessoa);
    }
  }

}
