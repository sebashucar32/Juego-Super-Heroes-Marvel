import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  usuario = {correo:'', password:''}

  constructor(private authService: AuthService) { }

  ngOnInit(): void {}

  ingresar() {
    console.log(this.usuario);
    const { correo, password } = this.usuario;
    this.authService.register(correo, password).then(res => {
      console.log("Se registro el usuario: ", res);
    });
  }

  ingresarCongoogle() {
    console.log(this.usuario);
    const { correo, password } = this.usuario;
    this.authService.loginWithGoogle(correo, password).then(res => {
      console.log("Se registro el usuario: ", res);
    });
  }
}
