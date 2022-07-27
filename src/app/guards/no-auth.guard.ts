import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class NoAuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      const session = localStorage.getItem('correo');  // Devuelve null cuando no hay dato en el localeStorage

      if(session === null) {
        return true;
      } else {
        this.router.navigateByUrl('/dashboard');
        return false;
      }
  }
  
}
