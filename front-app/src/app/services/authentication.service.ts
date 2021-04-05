import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import {LogedInUser} from "../model/loged-in-user.model";
import { JwtUtilService } from './jwt-util.service';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly signUpPath = 'http://localhost:8080/api/auth/sign-up';
  private readonly loginPath = 'http://localhost:8080/api/auth/log-in';
  public isLogedIn = new Subject<boolean>();
  public logedInUser = new Subject<LogedInUser>();

  constructor(private http: HttpClient, private jwtUtilService: JwtUtilService) { }


  signUp(email: string, password: string){
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.signUpPath, JSON.stringify({email, password}), {headers});

}

login(email: string, password: string): Observable<boolean> {
  console.log(email);
  console.log(password);
  var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  return this.http.post(this.loginPath, JSON.stringify({ email, password }), { headers }).pipe(
    map((res: any) => {
      let token = res && res['accessToken'];
      console.log(res);
      if (token) {
        console.log("USAO");
        localStorage.setItem('currentUser', JSON.stringify({
          email: email,
          roles: this.jwtUtilService.getRoles(token),
          token: res['accessToken']
        }));
        this.logedInUser.next(this.getCurrentUser());
        console.log(this.getCurrentUser());
        this.isLogedIn.next(true);
        
        return true;
      }
      else {
        return false;
      }
    }));
}
getToken(): string {
    
  let currentUser = JSON.parse(JSON.parse(JSON.stringify(localStorage.getItem('currentUser'))));
  let token = "";
  if(currentUser){
    token = currentUser.token;
  }
  console.log(token);
  return token;
}

logout(): void {
  localStorage.removeItem('currentUser');
  this.logedInUser.next(undefined);
  this.isLogedIn.next(true);
}

isLoggedIn(): boolean {
  if (this.getToken() != "") {
    return true
  }
  else {
    this.isLogedIn.next();
    return false
  };
}

getCurrentUser() {
  if (localStorage.currentUser) {
    return JSON.parse(localStorage.currentUser);
  }
  else {
    return undefined;
  }
}

isAuthenticated():boolean{
  return this.jwtUtilService.isAuthenticated(this.getToken());
}

getCurrentUserRoles(){
  return this.jwtUtilService.getRoles(this.getToken());
}

}
