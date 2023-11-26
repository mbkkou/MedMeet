import { Component } from '@angular/core';
import { Docteur } from '../logindocteur/docteur';
import { DocteurServiceService } from '../docteur-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signupdocteur',
  templateUrl: './signupdocteur.component.html',
  styleUrls: ['./signupdocteur.component.css']
})
export class SignupdocteurComponent {

  constructor( private docteurService: DocteurServiceService,) {}
  
  urlimage1= "../../assets/images/100.jpg"
 docteur :Docteur= new Docteur()

 signup(){
  
  console.log(this.docteur)
  return this.docteurService.signup(this.docteur.adresse,this.docteur.password,this.docteur.nom,this.docteur.prenom,this.docteur.specialite,this.docteur.numeroTelephone)
  .subscribe((res)=>Swal.fire({
    icon: 'success',
    title: 'Motif Patient added succefully',
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
