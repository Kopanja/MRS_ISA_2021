import { Component, OnInit } from '@angular/core';
import {PharmacyService} from '../services/pharmacy.service';
import { Pharmacy } from '../model/pharmacy.model';

@Component({
  selector: 'app-pharmacy-list',
  templateUrl: './pharmacy-list.component.html',
  styleUrls: ['./pharmacy-list.component.css']
})
export class PharmacyListComponent implements OnInit {
  
  public pharmacyList : Pharmacy[];
  
  constructor(private pharmacyService : PharmacyService) { 
    this.pharmacyList = [];
  }

  ngOnInit(): void {
    this.pharmacyService.getAll().subscribe(data=>{
      this.pharmacyList = data;
    })
  }

  moreButton(id : number){
    console.log(id);
  }

}
