import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.scss']
})
export class ConsultaComponent {
  cpf: string = '';
  nomeBeneficiario: string = '';
  especialidades: any[] = [];
  data: string = '';
  hora: string = '';
  mensagemSucesso: string = '';
  mensagemErro: string = '';

  constructor(private http: HttpClient) {
    this.carregarEspecialidades()
  }

  buscarBeneficiario() {
    console.log(this.cpf)
    const cpfSemPontos = this.cpf.replace(/\D/g, ''); // Remove pontos e traços do CPF

    this.http.get(`http://localhost:9090/beneficiarios/${cpfSemPontos}`).subscribe(
      (response: any) => {
        this.nomeBeneficiario = response.nome;
      },
      (error) => {
        this.nomeBeneficiario = ''; // Limpa o campo se ocorrer um erro
        this.mensagemErro = 'Beneficiário não encontrado.';

        console.error(error)
      }
    );
  }

  carregarEspecialidades() {
    this.http.get('http://localhost:9090/especialidades').subscribe(
      (response: any) => {
        this.especialidades = response;
      },
      (error) => {
        this.mensagemErro = 'Não foi possível carregar as especialidades. Tente novamente mais tarde.';
      }
    );
  }

  agendarConsulta() {
    const payload = {
      "cpf-beneficiario": this.cpf,
      "nome-beneficiario": this.nomeBeneficiario,
      "dataNascimento": this.data,
      "hora": this.hora,
    };

    this.http.post('http://localhost:9090/agendar-consulta', payload).subscribe(
      (response: any) => {
        this.mensagemSucesso = 'Consulta agendada com sucesso.';
      },
      (error) => {
        this.mensagemErro = 'Não foi possível realizar o agendamento. Tente novamente mais tarde.';
      }
    );
  }
}