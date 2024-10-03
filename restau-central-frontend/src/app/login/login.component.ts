// import { Component } from '@angular/core';
// import { Router } from '@angular/router';
// import { AuthService } from 'src/app/services/auth.service';

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })
// export class LoginComponent {
//   email: string = '';
//   password: string = '';
//   errorMessage: string = '';

//   constructor(private authService: AuthService, private router: Router) { }

//   onSubmit() {
//     this.authService.login(this.email, this.password).subscribe({
//       next: (response) => {
//         this.authService.saveToken(response.token);
//         this.router.navigate(['/dashboard']);  // Redirection après connexion réussie
//       },
//       error: (err) => {
//         this.errorMessage = 'Invalid username or password';
//       }
//     });
//   }
// }

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Role } from '../Model/enum/Role';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  errorMessage: string | null = null;

  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  submitForm(form: FormGroup): void {
    if (form.invalid) {
      return;
    }
  
    const { email, password } = form.value;
    this.service.login(email, password).subscribe(
      (response: { token: string }) => {
        this.service.saveToken(response.token);
        console.log(email , password);
        const role = this.service.getRole();
        const userId = this.service.getUserId(); // Retrieve userId from localStorage
  
        console.log('User ID:', userId); // Check userId in console
        if (role) {
          const dashboardRoute = `/dashboard/${role}`;
          this.router.navigate([dashboardRoute]);
        } else {
          console.error('Role is null or undefined.');
          this.errorMessage = 'Login failed due to an unknown role.';
        }
      },
      (error: any) => {
        console.error('Login failed', error);
        this.errorMessage = 'Login failed. Please check your email and password.';
      }
    );
  }
  
  
}