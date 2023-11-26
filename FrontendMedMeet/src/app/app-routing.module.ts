import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirsthomeComponent } from './firsthome/firsthome.component';
import { LoginComponent } from './loginpatient/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SignupComponent } from './signuppatient/signup.component';

import { HomepatientComponent } from './homepatient/homepatient.component';


import { MediFolderComponent } from './medi-folder/medi-folder.component';
import { DashbordComponent } from './dashbord/dashbord.component';

import { MediTestComponent } from './medi-test/medi-test.component';
import { HistoryPatientComponent } from './history-patient/history-patient.component';
import { FavorisComponent } from './favoris/favoris.component';
import { ListPatientComponent } from './list-patient/list-patient.component';
import { NotificationPatientComponent } from './notification-patient/notification-patient.component';
import { TestComponent } from './test/test.component';
import { LogindocteurComponent } from './logindocteur/logindocteur.component';
import { SignupdocteurComponent } from './signupdocteur/signupdocteur.component';
import { DashboarddoctorComponent } from './dashboarddoctor/dashboarddoctor.component';



import { PatientListComponent } from './patient-list/patient-list.component';
import { DocumentpatientComponent } from './documentpatient/documentpatient.component';


const routes: Routes  = [
  { path: '', component: FirsthomeComponent },
  { path: 'test', component: TestComponent },
  { path: 'loginpatient', component: LoginComponent },
  { path: 'logindocteur', component: LogindocteurComponent },
  { path: 'signuppatient', component: SignupComponent },
  { path: 'signupdocteur', component: SignupdocteurComponent },
  { path: 'contact', component: NavbarComponent },
  { path: 'homepatient', component: HomepatientComponent },
  { path: 'mediFolder/:id', component: MediFolderComponent },
  {path: 'dashboard', component: DashbordComponent},
  { path: 'mediTest', component: MediTestComponent },
  { path: 'listPatient', component: ListPatientComponent }, 
  { path: 'listFavoris', component: FavorisComponent },
  { path: 'historyPatient', component: HistoryPatientComponent },
  { path: 'notificationPatient', component: NotificationPatientComponent },
  { path: 'listPatient', component: PatientListComponent },
  { path: 'dashborddoctor', component: DashboarddoctorComponent },
  {path:"documents", component:DocumentpatientComponent}
 

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
