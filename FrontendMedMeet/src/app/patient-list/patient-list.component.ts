import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {
  imageUrl: string = "../../assets/images/image.png";
  patients: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchPatients();
  }

  fetchPatients(): void {
    this.http.get<any[]>('http://localhost:8080/patient').subscribe(patients => {
      this.patients = patients;
    });
  }
}
