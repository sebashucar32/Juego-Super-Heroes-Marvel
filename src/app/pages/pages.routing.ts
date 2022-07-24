import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { ListarTarjetasComponent } from './listar-tarjetas/listar-tarjetas.component';
import { AgregarTarjetasComponent } from './agregar-tarjetas/agregar-tarjetas.component';
import { PinComponent } from './pin/pin.component';
import { JuegoComponent } from './juego/juego.component';
import { AuthGuard } from '../guards/auth.guard';

const routes: Routes = [
    {
        path: 'dashboard',
        canActivate: [AuthGuard],
        children: [
            { path: '', component: ListarTarjetasComponent },
            { path: 'listar', component: ListarTarjetasComponent },
            { path: 'crear', component: AgregarTarjetasComponent },
            { path: 'pin', component: PinComponent },
            { path: 'juego', component: JuegoComponent },
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
  
export class PagesRoutingModule {}