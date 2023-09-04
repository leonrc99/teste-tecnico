import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BeneficiariosComponent } from './beneficiarios/beneficiarios.component';
import { ConsultaComponent } from './consulta/consulta.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'beneficiarios',
    component: BeneficiariosComponent,
    children: [
      { path: 'cadastro', component: BeneficiariosComponent }
    ]
  },
  {
    path: 'consultas',
    component: ConsultaComponent,
    children: [
      { path: 'cadastro', component: ConsultaComponent }
    ]
  },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
