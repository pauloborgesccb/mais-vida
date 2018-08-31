import { Estado } from "./estado";
import { Documento } from "./documento";

export class Pessoa {

  idPessoa: number;
  noPessoa: string;
  estado: Estado;
  documentos: Array<Documento>;

  constructor(data?) {
    if (data) {
      this.idPessoa = data.idPessoa;
      this.noPessoa = data.noPessoa;
      this.estado = new Estado(data.estado);
      this.documentos = <Array<Documento>> this.documentos;
    }
  }

}
