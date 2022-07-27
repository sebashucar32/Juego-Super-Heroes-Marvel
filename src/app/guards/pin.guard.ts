import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class PinGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
  
    const sessionPin = localStorage.getItem('pin');  // Devuelve null cuando no hay dato en el localeStorage

    if(sessionPin === null) {
      this.router.navigateByUrl('dashboard/pin');
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No puede entrar a una sala de juego si no crea o entra a una sala por medio del PIN'
      })
      return false;
    } else {
      return true;
    }
  }
  
}
