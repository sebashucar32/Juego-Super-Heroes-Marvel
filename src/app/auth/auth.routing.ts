import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { NoAuthGuard } from '../guards/no-auth.guard';

const routes: Routes = [
    { path: 'login', component: LoginComponent, canActivate:[NoAuthGuard] },
    { path: 'register', component: RegisterComponent, canActivate:[NoAuthGuard] }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class AuthRoutingModule {}