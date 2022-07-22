import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/Usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  usuario = {correo:'', password:''}

  constructor() { }
  ngOnInit(): void {}

  ingresar() {
    console.log(this.usuario);
  }
}
