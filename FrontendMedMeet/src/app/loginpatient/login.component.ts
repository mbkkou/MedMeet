import { Component,OnInit } from '@angular/core';
import { PatientServiceService } from '../patient-service.service';
import { Patient } from './patient';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {

  patient:Patient= new Patient()
  constructor(private PatientService: PatientServiceService,private router: Router){}
  ngOnInit() {
    if (this.PatientService.isAuthenticated()) {
      this.router.navigate(['/homepatient']);
    }
   // console.log(localStorage.getItem("isAuthenticated"))

  }
  module :any ={}
  urlimage1= "../../assets/images/imgpatient.png"
  calculateAge(birthDate: Date): number {
    const today = new Date();
    let age = today.getFullYear() - birthDate.getFullYear();
    
    // Check if the birthday has already occurred this year
    const hasBirthdayOccurred = (today.getMonth() > birthDate.getMonth()) || 
                                (today.getMonth() === birthDate.getMonth() && today.getDate() >= birthDate.getDate());
    
    // Subtract 1 from the age if the birthday hasn't occurred yet this year
    if (!hasBirthdayOccurred) {
      age--;
    }
    
    return age;
  }
  login(){
    console.log(this.patient.email_Patient)
    return this.PatientService.login(this.patient.email_Patient,this.patient.password_Patient).subscribe((res:any)=>{
      console.log(res)
      this.PatientService.setAuthenticated(true)
      Date =res.patient.birth_Patient
      console.log(this.PatientService.isAuthenticated())
      localStorage.setItem("idPatient", res.patient.id_Patient)
      localStorage.setItem("nomPatient", res.patient.nom_Patient)
      localStorage.setItem("prenomPatient", res.patient.prenom_Patient)
      

      localStorage.setItem("isAuthenticated",this.PatientService.isAuthenticated().toString())
     // console.log(localStorage.setItem("isAuthenticated",this.PatientService.isAuthenticated().toString()))
      this.router.navigate(['/homepatient'])
    },err=>{ Swal.fire({
			icon: 'error',
			title: 'mot de passe incorrect',
			showConfirmButton: true,
			})

  }
    )
}

}
