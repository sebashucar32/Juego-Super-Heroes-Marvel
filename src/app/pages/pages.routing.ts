import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { ListarTarjetasComponent } from './listar-tarjetas/listar-tarjetas.component';
import { AgregarTarjetasComponent } from './agregar-tarjetas/agregar-tarjetas.component';
import { LoginComponent } from '../auth/login/login.component';

const routes: Routes = [
    {
        path: 'dashboard',
        children: [
            { path: '', component: LoginComponent },
            { path: 'listar', component: ListarTarjetasComponent },
            { path: 'crear', component: AgregarTarjetasComponent }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
  
export class PagesRoutingModule {}