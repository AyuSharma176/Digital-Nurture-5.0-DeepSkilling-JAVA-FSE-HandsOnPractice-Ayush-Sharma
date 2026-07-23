import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

const isLoggedIn = true;

export const authGuard: CanActivateFn = () => {
  const router = inject(Router);
  if (isLoggedIn) return true;
  router.navigate(['/']);
  return false;
};