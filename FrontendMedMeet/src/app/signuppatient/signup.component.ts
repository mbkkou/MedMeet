import { Component } from '@angular/core';
import { NgbCalendar, NgbDate, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { PatientServiceService } from '../patient-service.service';
import { Patient } from '../loginpatient/patient';
import { MatDialog } from '@angular/material/dialog';

import Swal from 'sweetalert2'


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  
  styleUrls: ['./signup.component.css'],
  styles: [
		`
			.custom-day {
				text-align: center;
				padding: 0.185rem 0.25rem;
				border-radius: 0.25rem;
				display: inline-block;
				width: 2rem;
			}
			.custom-day:hover,
			.custom-day.focused {
				background-color: #e6e6e6;
			}
			.weekend {
				background-color: #f0ad4e;
				border-radius: 1rem;
				color: white;
			}
			.hidden {
				display: none;
			}
		`,
	],

})
export class SignupComponent {
  
  urlimage1= "../../assets/images/14.png"
  model!: NgbDateStruct;
  today = this.calendar.getToday();
  model2 : any ={} 
  patient:Patient =new Patient();

  constructor(private calendar: NgbCalendar, private PatientService: PatientServiceService,public dialog: MatDialog) {}

	signup(){
		this.patient.birth_Patient = new Date(`${this.model.year}-${this.model.month}-${this.model.day}`)
		console.log(this.patient)
		return this.PatientService.signup(this.patient.email_Patient,this.patient.password_Patient,this.patient.nom_Patient,this.patient.prenom_Patient,this.patient.birth_Patient,this.patient.gender_Patient)
		.subscribe((res)=>Swal.fire({
			icon: 'success',
			title: 'Your account has been created succefully',
			showConfirmButton: true,
			timer: 1500
		  }),err=>{ Swal.fire({
			icon: 'error',
			title: 'this email already has an account',
			showConfirmButton: true,
			})
	}
		)
}
}
