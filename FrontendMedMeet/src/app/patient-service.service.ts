import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { Rendezvous } from './dashboarddoctor/rendezvous';




@Injectable({
  providedIn: 'root'
})
export class PatientServiceService {

  
  updateRendezVousDescription(rendezvousId: any, rendervous: Rendezvous) {
     // Effectuez une requête HTTP PUT ou PATCH pour mettre à jour la description du rendez-vous dans la base de données
    // Utilisez une API ou un service approprié pour effectuer la mise à jour
    // Par exemple, vous pouvez utiliser HttpClient d'Angular pour envoyer une requête PUT ou PATCH
    // Remplacez l'URL et le corps de la requête par votre implémentation spécifique
  
    const updateUrl = `http://localhost:8080/rendezvous/${rendezvousId}`;
    
  
    // Utilisez HttpClient pour envoyer une requête PUT ou PATCH à votre API
    // Assurez-vous d'importer et d'injecter le service HttpClient dans votre composant
   
    this.http.put(updateUrl, rendervous).subscribe(
      (response) => {
        console.log('La description du rendez-vous a été mise à jour avec succès dans la base de données.');
      },
      (error) => {
        console.error('Une erreur s\'est produite lors de la mise à jour de la description du rendez-vous :', error);
      }
    );
  }

  private isAuthenticateda  = false;
  constructor(private http:HttpClient) {}
   
 
  signup(email_Patient:String,password_Patient:String,nom_Patient:String,prenom_Patient:String,birth_Patient:Date,gender_Patient :String){
    const url = 'http://localhost:8080/patient/signup';
    const body = {
      email_Patient: email_Patient,
      password_Patient: password_Patient,
      nom_Patient: nom_Patient,
      prenom_Patient: prenom_Patient,
      birth_Patient: birth_Patient,
      gender_Patient:gender_Patient
    };
    return this.http.post(url,body)
      
  }

  public deleteRendezVous(rendezvousId: number) {
    const url = `http://localhost:8080/rendezvous/${rendezvousId}`;
    return this.http.delete(url);
  }



  login(email_Patient:String,password_Patient:String){
    const url = 'http://localhost:8080/patient/login';
    const body = {
      email_Patient: email_Patient,
      password_Patient: password_Patient
    }
    
    return this.http.post(url,body)

  }
  isAuthenticated(): boolean {
    const value =localStorage.getItem("isAuthenticated")
    if (value==="true"){
      return true
    }
    return false; // Return the authentication status
  }
  setAuthenticated(status: boolean): void {
    localStorage.setItem("isAuthenticated",status.toString()) // Set the authentication status
  }
  logout():void {
    this.setAuthenticated(false)
    localStorage.removeItem("isAuthenticated")
    localStorage.getItem("isAuthenticated")
    console.log(localStorage.getItem("isAuthenticated"))
    window.location.href = '/loginpatient';

  }
}
