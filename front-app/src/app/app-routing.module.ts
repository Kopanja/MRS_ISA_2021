import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { AuthGuardService } from './services/auth-guard.service';


const routes: Routes = [
  {path: 'main-page', component: MainPageComponent, canActivate : [AuthGuardService], data: {expectedRole: 'ROLE_PATIENT'}},
  {path: 'signup-page', component: SignUpComponent},
  {path: 'login-page', component: LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
