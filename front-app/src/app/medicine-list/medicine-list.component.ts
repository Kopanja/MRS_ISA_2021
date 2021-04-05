import { Component, OnInit } from '@angular/core';
import {MedicineService} from '../services/medicine.service';
import { Medicine } from '../model/medicine.model';
@Component({
  selector: 'app-medicine-list',
  templateUrl: './medicine-list.component.html',
  styleUrls: ['./medicine-list.component.css']
})
export class MedicineListComponent implements OnInit {

  public medicineList : Medicine[];
  constructor(private medicineService : MedicineService) {
    this.medicineList = [];
   }

  ngOnInit(): void {
    this.medicineService.getAll().subscribe(data=>{
      this.medicineList = data;
    })
  }

  moreButton(id : number){
    console.log(id);
  }

}
