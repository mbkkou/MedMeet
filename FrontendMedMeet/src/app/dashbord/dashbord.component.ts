import { Component } from '@angular/core';
import { EventSettingsModel, View,} from '@syncfusion/ej2-angular-schedule';
import { DataManager, ODataV4Adaptor, Query } from '@syncfusion/ej2-data';
import { Rendezvous } from '../dashboarddoctor/rendezvous';
import { PatientServiceService } from '../patient-service.service';

@Component({
  selector: 'app-dashbord',
  templateUrl: './dashbord.component.html',
  styleUrls: ['./dashbord.component.css']
})
export class DashbordComponent {
  rendervous :Rendezvous =new Rendezvous()
  servicedocteur: any;
  constructor( private servicePatient:PatientServiceService){}
    public setView: View ="Month" 
    public readonly: boolean = true;
    public selectedDate: Date = new Date();
    private dataManager: DataManager = new DataManager({
      url: `http://localhost:8080/rendezvous/patient/${localStorage.getItem("idPatient")}`,
      adaptor: new ODataV4Adaptor,
      crossDomain: true
    });
    public eventSettings: EventSettingsModel = {
        allowEditing: false,
        allowDeleting:true,
        allowAdding:false,
      includeFiltersInQuery: true, dataSource: this.dataManager, fields: {
        id: 'Id',
        subject:  {
            name: 'description'},
        description: { name: 'ShipAddress' },
        startTime: { name: 'dateRendezVousStart' },
        endTime: { name: 'dateRendezVousEnd' },
      }
    };

   public onActionBegin(args: any): void {
    if (args.requestType === 'eventChange' && args.changedRecords.length > 0) {
     
      const updatedRecord = args.changedRecords[0];
      console.log(updatedRecord )
      this.rendervous.docteur=updatedRecord.docteur;
      this.rendervous.patient=updatedRecord.patient;
      this.rendervous.description=updatedRecord.description;
      this.rendervous.dateRendezVousStart=updatedRecord.dateRendezVousStart;
      console.log(updatedRecord.dateRendezVousEnd )
      this.rendervous.dateRendezVousEnd=updatedRecord.dateRendezVousEnd;

      const rendezvousId = updatedRecord.id;
      console.log(this.rendervous)


      this.servicePatient.updateRendezVousDescription(rendezvousId,this.rendervous)
      location.reload()
    }
    if (args.requestType === 'eventRemove' && args.data.length > 0) {
      const deletedRecord = args.data[0];
      
      const rendezvousId = deletedRecord.id;
      console.log(rendezvousId)
      this.servicePatient.deleteRendezVous(rendezvousId).subscribe(
        () => {
          console.log('Rendez-vous supprimé avec succès.');
          location.reload();
        },
        (error:any) => {
          console.error('Erreur lors de la suppression du rendez-vous :', error);
        }
      );
    }
  }
  
}
console.log(localStorage.getItem("idPatient"))
