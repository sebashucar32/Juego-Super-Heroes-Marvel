import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxPaginationModule } from 'ngx-pagination';

// Modulos
import { FormsModule } from '@angular/forms';
import { AgregarTarjetasComponent } from './agregar-tarjetas/agregar-tarjetas.component';
import { ListarTarjetasComponent } from './listar-tarjetas/listar-tarjetas.component';
import { AppRoutingModule } from '../app-routing.module';
import { PinComponent } from './pin/pin.component';
import { JuegoComponent } from './juego/juego.component';

@NgModule({
  declarations: [
    ListarTarjetasComponent,
    AgregarTarjetasComponent,
    PinComponent,
    JuegoComponent
  ],
  exports: [
    ListarTarjetasComponent,
    AgregarTarjetasComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    AppRoutingModule,
    NgxPaginationModule
  ]
})
  
export class PagesModule { }
