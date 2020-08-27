import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from "@angular/forms";
import { AuthService } from './../../shared/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})

export class SigninComponent implements OnInit {
  signinForm: FormGroup;

 userEmail:String='';
 userPassword:String='';
  constructor(
    public fb: FormBuilder,
    public authService: AuthService,
    public router: Router
  ) {
    this.signinForm = this.fb.group({
      email: [''],
      password: ['']
    })
  }

  ngOnInit() { }

  registerUser() {
    this.authService.signIn(this.signinForm.value).subscribe((res) => 
      //if (res.result) {
        console.log(res));
        //this.signupForm.reset()
        this.router.navigate(['/dashboard']);
      //}
    
  }

  loginUser(){
    alert(this.userEmail);
    this.authService.logIn(this.userEmail,this.userPassword).subscribe((res) => {
      this.router.navigate(['/dashboard']);
    },(error)=>{
      alert('invalid credentials..');
    });
        //this.signupForm.reset()
       
       
      //}
  }
}
