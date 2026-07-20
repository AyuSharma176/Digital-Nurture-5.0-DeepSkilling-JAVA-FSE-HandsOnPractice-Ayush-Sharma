import { Routes } from '@angular/router';
import { EmployeeListComponent } from './components/employee-list/employee-list';
import { EmployeeEditComponent } from './components/employee-edit/employee-edit';

export const routes: Routes = [
  { path: '',           redirectTo: 'employees', pathMatch: 'full' },
  { path: 'employees',  component: EmployeeListComponent },
  { path: 'edit/:id',   component: EmployeeEditComponent }
];
