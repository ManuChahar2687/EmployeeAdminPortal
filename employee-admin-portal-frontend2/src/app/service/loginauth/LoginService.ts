import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { API_URL } from "src/app/app.constants";

export const TOKEN = 'token'
export const AUTHENTICATED_USER = 'authenticatedUser'

@Injectable({
    providedIn: 'root'
})

export class LoginService {

    loginUrl: string = 'http://localhost:8080/auth/login';

    constructor(
        private http: HttpClient
    ) { }


    login(email: string, password: string): Observable<any> {
        const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        const body = JSON.stringify({ email, password });
        return this.http.post<any>(this.loginUrl, body, { headers });
      }
      

    jwtAuthenticate(email: string, password: string): Observable<any> {

        let basicAuthHeaderString = 'Basic ' + window.btoa(email + ':' + password)
        let headers = new HttpHeaders({
            authorization: basicAuthHeaderString
        })

        return this.http.post<AuthenticationBean>(this.loginUrl, { headers })
        .pipe(
            map(
                data => {
                    sessionStorage.setItem(AUTHENTICATED_USER,email);
                    sessionStorage.setItem(TOKEN,basicAuthHeaderString);
                    return data;
                }
            )
        )
    }

    getAuthenticatedUser() {
        return sessionStorage.getItem(AUTHENTICATED_USER)
    }

    getAuthenticatedToken() {
        if (this.getAuthenticatedUser())
            return sessionStorage.getItem(TOKEN)
        return null
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem(AUTHENTICATED_USER)
        return !(user === null)
    }


    logout() {
        sessionStorage.removeItem(AUTHENTICATED_USER)
        sessionStorage.removeItem(TOKEN)
    }

}



export class AuthenticationBean {
    constructor(public message: string) { }
}