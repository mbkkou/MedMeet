import { Component } from '@angular/core';
import { DocteurServiceService } from '../docteur-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-nav-doctor',
  templateUrl: './side-nav-doctor.component.html',
  styleUrls: ['./side-nav-doctor.component.css']
})
export class SideNavDoctorComponent {
  constructor( private docteurService:DocteurServiceService,private router:Router){}
  isSidebarOpen: boolean = false;
  ngOnInit() {
    console.log(this.docteurService.isAuthenticated())
    if (!this.docteurService.isAuthenticated()) {
      this.router.navigate(['/logindocteur'])
    }
  }
  toggleSidebar() {
    this.isSidebarOpen = !this.isSidebarOpen;
  }
  logout(){
    this.docteurService.logout()
  }


}
