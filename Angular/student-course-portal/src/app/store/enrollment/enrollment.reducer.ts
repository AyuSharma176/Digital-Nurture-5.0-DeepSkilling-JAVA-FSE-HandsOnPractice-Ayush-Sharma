import { createReducer, on } from '@ngrx/store';
import { enrollInCourse, unenrollFromCourse } from './enrollment.actions';

export interface EnrollmentState {
  enrolledCourseIds: number[];
}

const initialState: EnrollmentState = { enrolledCourseIds: [] };

export const enrollmentReducer = createReducer(
  initialState,
  on(enrollInCourse, (state, { courseId }) => ({
    ...state,
    enrolledCourseIds: [...state.enrolledCourseIds, courseId]
  })),
  on(unenrollFromCourse, (state, { courseId }) => ({
    ...state,
    enrolledCourseIds: state.enrolledCourseIds.filter(id => id !== courseId)
  }))
);