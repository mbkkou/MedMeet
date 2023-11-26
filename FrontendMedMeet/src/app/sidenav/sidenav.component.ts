import { Component } from '@angular/core';
import { PatientServiceService } from '../patient-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent {

  constructor( private patientService :PatientServiceService, private router :Router){}
  ngOnInit() {
    console.log(this.patientService.isAuthenticated())
    if (!this.patientService.isAuthenticated()) {
      this.router.navigate(['/loginpatient'])
    }
   
  }
  isSidebarOpen: boolean = false;

  toggleSidebar() {
    this.isSidebarOpen = !this.isSidebarOpen;
  }
  logout(){
    this.patientService.logout()
  }
}
``
