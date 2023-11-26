import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homepatient',
  templateUrl: './homepatient.component.html',
  styleUrls: ['./homepatient.component.css']
})
export class HomepatientComponent implements OnInit{
  ngOnInit(): void {
    console.log(localStorage.getItem("isAuthenticated"))
  }


  image1Url:string="../../assets/images/21.png";
  image2Url:string="../../assets/images/22.png";
  urlimage1:string="../../assets/images/12.png";
  urlimage2:string="../../assets/images/10.png";
  urlimage3:string="../../assets/images/11.png";
  urlimage4:string="../../assets/images/13.png";
  urlimage5:string="../../assets/images/14.png";
  urlimage6:string="../../assets/images/17.png";

}
