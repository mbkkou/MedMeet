import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Docteur } from '../logindocteur/docteur';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-medi-folder',
  templateUrl: './medi-folder.component.html',
  styleUrls: ['./medi-folder.component.css']
})
export class MediFolderComponent {
  profileUrl: string = "../../assets/images/Profile-patient.png";
  medifoldeUrl: string = "../../assets/images/MediFolder.png";
 
  showCompteRendu: boolean = true;
  showCompteRenduDetails: boolean = false;
  showTraitement: boolean = true;
  showTraitementDetails: boolean = false;
  uploadedFiles: File[] = [];
  patient: any;
  compteRenduText: string = '';
  docteur: any;
  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const idDoctor= localStorage.getItem("idDocteur");

      const patientId = params.get('id');
      const consultationId= localStorage.getItem("idDocteur")!.toString()+patientId!.toString()
      console.log(consultationId)
      console.log(patientId); // Vérifiez la valeur de patientId dans la console
      if (patientId !== null) {
        this.fetchPatientDetails(patientId);
      }
      this.http.get<any>(`http://localhost:8080/docteurs/${idDoctor}` ).subscribe(docteur => {
        console.log(docteur)
        this.docteur = docteur;
    })
    });
  }
  
  
  
  

  fetchPatientDetails(patientId: string): void {
    console.log('je console');
    this.http.get<any>('http://localhost:8080/patient/' + patientId).subscribe(patient => {
      this.patient = patient;
    });
  }

  onFileSelected(event: any) {
    const files: File[] = event.target.files;
    for (const file of files) {
      this.uploadedFiles.push(file);
    }
  }

  uploadFiles() {
    // Implement your logic to save/upload the files to your desired location
    // You can use services or APIs to handle the upload process
  }

  removeFile(file: File) {
    const index = this.uploadedFiles.indexOf(file);
    if (index !== -1) {
      this.uploadedFiles.splice(index, 1);
    }
  }

  toggleCompteRendu() {
    this.showCompteRenduDetails = true;
    this.showCompteRendu = false;
  }

  toggleCompteRenduDetails() {
    this.showCompteRenduDetails = false;
    this.showCompteRendu = true;
  }

  toggleTraitement() {
    this.showTraitementDetails = true;
    this.showTraitement = false;
  }

  toggleTraitementDetails() {
    this.showTraitementDetails = false;
    this.showTraitement = true;
  }
  
  saveConsultation (){
    
    console.log(localStorage.getItem("Docteur"))
  
    const consultationData = {
      patient: this.patient,
      doctor: this.docteur,
      compte_rendu: this.compteRenduText,
      traitementFichier: [] as any[]  // Initialisez le champ traitementFichier à null pour le moment
    };
    const consultationId= localStorage.getItem("idDocteur")!.toString()+this.patient.id_Patient!.toString()
    console.log(consultationId)
    const url = `http://localhost:8080/consultation/${consultationId}`;
  
    // Lire le fichier et convertir son contenu en un tableau de bytes
    const reader = new FileReader();
    reader.onloadend = () => {
      const fileContent = reader.result as ArrayBuffer;
      const byteArray = new Uint8Array(fileContent);
      consultationData.traitementFichier = Array.from(byteArray);
  
      // Envoyer la requête PUT avec les données mises à jour
      this.http.put(url, consultationData).subscribe(response => {
        console.log(response);
        Swal.fire({
          icon: 'success',
          title: 'Motif Patient added succefully',
          showConfirmButton: true,
          timer: 1500
          })
      });
    };
    reader.readAsArrayBuffer(this.uploadedFiles[0]);
  }
}
