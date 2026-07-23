import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Employee } from '../../models/employee.model';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-employee-edit',
  standalone: true,
  imports: [FormsModule, RouterModule],
  templateUrl: './employee-edit.html',  // ✅ matches generated filename
  styleUrl: './employee-edit.css'
})
export class EmployeeEditComponent implements OnInit {
  employee: Employee = {
    id: 0, name: '', designation: '',
    department: '', email: '', phone: ''
  };
  isLoading = true;
  errorMessage = '';
  successMessage = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.employeeService.getEmployeeById(id).subscribe({
      next: (data) => {
        this.employee = data;
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage = `Could not load employee with ID ${id}.`;
        this.isLoading = false;
        console.error(err);
      }
    });
  }

  onSave(): void {
    this.successMessage = `Employee "${this.employee.name}" updated successfully!`;
    setTimeout(() => this.router.navigate(['/employees']), 1500);
  }

  onCancel(): void {
    this.router.navigate(['/employees']);
  }
}
