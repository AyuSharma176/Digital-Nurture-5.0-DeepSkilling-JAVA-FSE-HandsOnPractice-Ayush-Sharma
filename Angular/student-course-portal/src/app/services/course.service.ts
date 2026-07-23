import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, tap, retry } from 'rxjs/operators';
import { Course } from '../models/course.model';

@Injectable({ providedIn: 'root' })
export class CourseService {
  private apiUrl = 'http://localhost:3000/courses';

  private courses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Angular Basics', code: 'WEB201', credits: 3, gradeStatus: 'pending' },
    { id: 3, name: 'Database Design', code: 'DB301', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'Machine Learning', code: 'AI401', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Cloud Computing', code: 'CC501', credits: 2, gradeStatus: 'pending' }
  ];

  constructor(private http: HttpClient) {}

  getCourses(): Course[] { return this.courses; }

  getCourseById(id: number): Course | undefined {
    return this.courses.find(c => c.id === id);
  }

  addCourse(course: Course): void { this.courses.push(course); }

  getCourses$(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      tap(c => console.log('Courses loaded:', c.length)),
      map(courses => courses.filter(c => c.credits > 0)),
      retry(2),
      catchError(err => throwError(() => new Error('Failed to load courses.')))
    );
  }

  getCourseById$(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`);
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(this.apiUrl, course);
  }

  updateCourse(id: number, course: Partial<Course>): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}/${id}`, course);
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}