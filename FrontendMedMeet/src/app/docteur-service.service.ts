import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Rendezvous } from './dashboarddoctor/rendezvous';

@Injectable({
  providedIn: 'root'
})
export class DocteurServiceService {
  
  constructor(private http:HttpClient) { }
public deleteRendezVous(rendezvousId: number) {
    const url = `http://localhost:8080/rendezvous/${rendezvousId}`;
    return this.http.delete(url);
  }
  signup(adresse:String,password:String,nom:String,prenom:String,specialite:String,numeroTelephone:String){
    const url = 'http://localhost:8080/docteurs/signup';
    const body = {
      adresse: adresse,
      password: password,
      nom: nom,
      prenom: prenom,
      specialite: specialite,
      numeroTelephone:numeroTelephone
    };
    return this.http.post(url,body)
      
  }

  login(adresse:String,password:String){
    const url = 'http://localhost:8080/docteurs/login';
    const body = {
      adresse: adresse,
      password: password
    }
    
    return this.http.post(url,body)

  }
  isAuthenticated(): boolean {
    const value =localStorage.getItem("isAuthenticateddoctor")
    if (value==="true"){
      return true
    }
    return false; // Return the authentication status
  }
  setAuthenticated(status: boolean): void {
    localStorage.setItem("isAuthenticateddoctor",status.toString()) // Set the authentication status
  }
  logout():void {
    this.setAuthenticated(false)
    localStorage.clear()
    window.location.href = '/logindocteur';
  
  }
  updateRendezVousDescription(rendezvousId: any, rendezvous: Rendezvous): void {
    // Effectuez une requête HTTP PUT ou PATCH pour mettre à jour la description du rendez-vous dans la base de données
    // Utilisez une API ou un service approprié pour effectuer la mise à jour
    // Par exemple, vous pouvez utiliser HttpClient d'Angular pour envoyer une requête PUT ou PATCH
    // Remplacez l'URL et le corps de la requête par votre implémentation spécifique
  
    const updateUrl = `http://localhost:8080/rendezvous/${rendezvousId}`;
    
  
    // Utilisez HttpClient pour envoyer une requête PUT ou PATCH à votre API
    // Assurez-vous d'importer et d'injecter le service HttpClient dans votre composant
  
    this.http.put(updateUrl, rendezvous).subscribe(
      (response) => {
        console.log('La description du rendez-vous a été mise à jour avec succès dans la base de données.');
      },
      (error) => {
        console.error('Une erreur s\'est produite lors de la mise à jour de la description du rendez-vous :', error);
      }
    );
  }
  

}
