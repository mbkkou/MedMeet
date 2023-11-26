import { Docteur } from "../logindocteur/docteur";
import { Patient } from "../loginpatient/patient";

export class Rendezvous {

    
    patient!:Patient;
    docteur!:Docteur;
    description!:String;
    dateRendezVousStart!: Date;
    dateRendezVousEnd!: Date


}
