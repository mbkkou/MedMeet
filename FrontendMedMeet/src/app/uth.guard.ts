import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { PatientServiceService } from './patient-service.service';
 // Your authentication service

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: PatientServiceService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isAuthenticated()) {
        console.log(this.authService.isAuthenticated())
      return true; // User is authenticated, allow access
    } else {
      this.router.navigate(['/loginpatient']); // Navigate to login page if user is not authenticated
      return false; // Block access
    }
  }
}
