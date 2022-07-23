import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { Router } from '@angular/router';
import firebase from 'firebase/compat/app';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  constructor(private router: Router, private afauth: AngularFireAuth) { }

  async register(email: string, password: string) {
    try {
      await this.afauth.createUserWithEmailAndPassword(email, password);
      localStorage.setItem("correo", email);
      this.router.navigateByUrl('/');
      return;
    } catch (error) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'al parecer el usuario ya existe pruebe con otro'
      })
      return null;
    }
  }

  async login(email: string, password: string) {
    try {
      await this.afauth.signInWithEmailAndPassword(email, password);
      localStorage.setItem("correo", email);
      this.router.navigateByUrl('/');
      return;
    } catch (error) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Usuario o contraseña incorrecta'
      })

      return null;
    }
  }

  async loginWithGoogle() {
    try {
      await this.afauth.signInWithPopup(new firebase.auth.GoogleAuthProvider());
      this.router.navigateByUrl('/');
      return;
    } catch (error) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No se pudo loguear con la cuenta de google'
      })

      return null;
    }
  }

  getUserLogger() {
    return this.afauth.authState;
  }

  logout() {
    this.afauth.signOut();
  }
}
