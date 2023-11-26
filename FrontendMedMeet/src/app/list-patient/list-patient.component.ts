import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-patient',
  templateUrl: './list-patient.component.html',
  styleUrls: ['./list-patient.component.css']
})
export class ListPatientComponent implements OnInit {
  imageUrl: string = "../../assets/images/image.png";
  patients: any[] = [];
  

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    const doctorId = localStorage.getItem('idDocteur'); // Replace 2 with the desired doctor ID
    const url = `http://localhost:8080/rendezvous/docteur/${doctorId}`;
    
    this.http.get(url).subscribe((response: any) => {
      this.patients = response;
      console.log(this.patients);
    });
  }

  

  viewMedicalFolder(patient: any): void {
    console.log(patient.id_Patient);
    this.router.navigate(['/mediFolder', patient.id_Patient]);
  }
}
console.log( 'jjjj');
