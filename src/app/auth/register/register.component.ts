import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  usuario = {correo : '', password:''};

  constructor(private authService: AuthService) { }

  ngOnInit(): void {}

  registrarUsuario() {
    console.log(this.usuario);
    const { correo, password } = this.usuario;
    this.authService.register(correo, password);
  }
}