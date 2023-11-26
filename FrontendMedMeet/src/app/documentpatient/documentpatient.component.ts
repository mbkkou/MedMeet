import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-documentpatient',
  templateUrl: './documentpatient.component.html',
  styleUrls: ['./documentpatient.component.css']
})
export class DocumentpatientComponent implements OnInit{
   
    imageUrl: string = "../../assets/images/image.png";
    consultations: any[] = [];
    
  
    constructor(private http: HttpClient, private router: Router) { }
  
    ngOnInit(): void {
      const patientId = localStorage.getItem('idPatient'); // Replace 2 with the desired doctor ID
     
      this.http.get<any[]>('http://localhost:8080/consultation/patient/' + patientId + '/consultations').subscribe((response: any) => {
        this.consultations = response;
        console.log(this.consultations);
    
      });
    }
  
    
  
    viewMedicalFolder(patient: any): void {
      console.log(patient.id_Patient);
      this.router.navigate(['/mediFolder', patient.id_Patient]);
    }
  }
  console.log( 'jjjj');
  

