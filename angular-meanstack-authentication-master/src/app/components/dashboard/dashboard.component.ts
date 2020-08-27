import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from "@angular/forms";
import { AuthService } from './../../shared/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  matches=[];

  constructor( public authService: AuthService,
    public router: Router) {
    alert('sucessful...\n RESULTS\n points:10\n topthreewinners:\n 1.keerthi\n 2.sudha\n 3.swati\n');
   }

  ngOnInit() {
    this.loadMatches();
  }

  loadMatches(){
  
    this.authService.loadMatches().subscribe((response:any) => {
      if(response!=null){
   //this.matches=res;
   alert(response.data[0].match);
      }});
     ///this.router.navigate(['/dashboard']);
    }

}
