import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service'; // Adjust the path as needed
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.login(this.username, this.password).subscribe({
      next: (response) => {
        // Handle successful login
        console.log('Login successful', response);
        this.router.navigate(['/home']); // Redirect to a home or dashboard route
      },
      error: (error) => {
        // Handle error
        console.error('Login failed', error);
      }
    });
  }
}
