import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

// Modulos
import { FormsModule } from '@angular/forms';
import { AgregarTarjetasComponent } from './agregar-tarjetas/agregar-tarjetas.component';
import { ListarTarjetasComponent } from './listar-tarjetas/listar-tarjetas.component';
import { AppRoutingModule } from '../app-routing.module';
import { PinComponent } from './pin/pin.component';

@NgModule({
  declarations: [
    ListarTarjetasComponent,
    AgregarTarjetasComponent,
    PinComponent
  ],
  exports: [
    ListarTarjetasComponent,
    AgregarTarjetasComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    AppRoutingModule
  ]
})
  
export class PagesModule { }
