import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/Usuario';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  //usuario = {correo:'', password:''}

  public loginForm = this.fb.group({
    email: [localStorage.getItem('email') || '', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });

  constructor(private router: Router, private authService: AuthService, private fb: FormBuilder) { }

  ngOnInit(): void {}

  ingresar() {
    let email = this.loginForm.controls.email.value;
    let password = this.loginForm.controls.password.value;

    if(email === null) { email = '' }
    if(password === null) { password = '' }
    
    this.authService.login(email, password).catch(err => {
      console.error("No se pudo loguear al aplicativo");
    });
  }

  ingresarCongoogle() {
    this.authService.loginWithGoogle().then(res => {
      console.log("Se logueo el usuario con google: ", res);
    }); 
  }
}
