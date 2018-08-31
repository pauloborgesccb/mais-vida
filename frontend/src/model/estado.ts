export class Estado {

  idEstado: number;
  noEstado: string;
  sgEstado: string;

  constructor(data?) {
    if (data) {
      this.idEstado = data.idEstado;
      this.noEstado = data.noEstado;
      this.sgEstado = data.sgEstado;
    }
  }

}
