import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-beneficiarios',
  templateUrl: './beneficiarios.component.html',
  styleUrls: ['./beneficiarios.component.scss']
})
export class BeneficiariosComponent {
  cpf: string = '';
  nome: string = '';
  dataNascimento: string = '';
  mensagemSucesso: string = '';
  mensagemErro: string = '';

  constructor(private http: HttpClient) {}

  salvarBeneficiario() {
    const payload = {
      "cpf": this.cpf,
      "nome": this.nome,
      "data-nascimento": this.dataNascimento,
    };

    this.http.post('http://localhost:9090/beneficiarios', payload).subscribe(
      (response: any) => {
        this.mensagemSucesso = 'Beneficiário salvo com sucesso.';
      },
      (error) => {
        this.mensagemErro = 'Não foi possível salvar o beneficiário. Tente novamente mais tarde.';
      }
    );
  }
}