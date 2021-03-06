import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
 
@Injectable({
  providedIn: 'root'
})
 
export class AuthService {
  endpoint: string = 'http://localhost:3000/api';
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  currentUser = {};
 
  constructor(
    private http: HttpClient,
    public router: Router
  ) {
  }
 
  // Sign-up
  signUp(user: User): Observable<any> {
    console.log(user.name);
    let api = `http://localhost:3000/signup`;
    return this.http.post(api, user);
      //.pipe(
       // catchError(this.handleError)
      //)
  }
 
 // Sign-in
 signIn(user: User) {
  //return this.http.post<any>(`${this.endpoint}/signin`, user)
    console.log(user.name);
    let api= `http://localhost:3000/signin`;
    return this.http.post(api, user);
    
}

logIn(email:String,password:String) {
  let api= 'http://localhost:3000/api/signin?email='+email+'&password='+password;
    return this.http.post(api,null);
}

loadMatches() {
  let api= 'http://localhost:3000/api/match';
    return this.http.get(api);
}
 
  getToken() {
    return localStorage.getItem('access_token');
  }
 
  get isLoggedIn(): boolean {
    let authToken = localStorage.getItem('access_token');
    return (authToken !== null) ? true : false;
  }
 
  doLogout() {
    let removeToken = localStorage.removeItem('access_token');
    if (removeToken == null) {
      this.router.navigate(['log-in']);
    }
  }
 
  // User profile
  getUserProfile(id): Observable<any> {
    let api = `${this.endpoint}/user-profile/${id}`;
    return this.http.get(api, { headers: this.headers }).pipe(
      map((res: Response) => {
        return res || {}
      }),
      catchError(this.handleError)
    )
  }
 
  // Error 
  handleError(error: HttpErrorResponse) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      msg = error.error.message;
    } else {
      // server-side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(msg);
  }
}