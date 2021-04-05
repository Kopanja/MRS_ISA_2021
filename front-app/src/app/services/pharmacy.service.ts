import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Pharmacy} from '../model/pharmacy.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PharmacyService {
  private readonly path = "http://localhost:8080/api/pharmacies";
  constructor(private http : HttpClient) { }

  getAll():Observable<Pharmacy[]>{
    return this.http.get<Pharmacy[]>(this.path);
    
  }
}
