import { Component } from '@angular/core';
import { Docteur } from './docteur';
import { DocteurServiceService } from '../docteur-service.service';
import { Router } from '@angular/router';

import Swal from 'sweetalert2';


@Component({
  selector: 'app-logindocteur',
  templateUrl: './logindocteur.component.html',
  styleUrls: ['./logindocteur.component.css']
})
export class LogindocteurComponent {

  ngOnInit() {
    if (this.docteurService.isAuthenticated()) {
      this.router.navigate(['/dashborddoctor']);
    }
   // console.log(localStorage.getItem("isAuthenticated"))

  }
  constructor(private docteurService: DocteurServiceService,private router: Router){}
 docteur :Docteur= new Docteur()
 urlimage1= "../../assets/images/imgdoc.png"
 login(){
  console.log(this.docteur.adresse)
  return this.docteurService.login(this.docteur.adresse,this.docteur.password).subscribe((res:any)=>{
    console.log("hh")
    this.docteurService.setAuthenticated(true)
    
    console.log(this.docteurService.isAuthenticated())
    localStorage.setItem("idDocteur", res.docteur.id_docteur)
    localStorage.setItem("nomDocteur", res.docteur.nom)
    localStorage.setItem("prenomDocteur", res.docteur.prenom)
    localStorage.setItem("Docteur",res.docteur)
    

    localStorage.setItem("isAuthenticateddoctor",this.docteurService.isAuthenticated().toString())
    this.router.navigate(['/dashborddoctor']);
  },err=>{ Swal.fire({
    icon: 'error',
    title: 'mot de passe incorrect',
    showConfirmButton: true,
    })})
}

 
}
