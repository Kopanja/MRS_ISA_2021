import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Medicine} from '../model/medicine.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  private readonly path = "http://localhost:8080/api/medicine";
  constructor(private http : HttpClient) { }


  getAll():Observable<Medicine[]>{
    return this.http.get<Medicine[]>(this.path);
    
  }
}
