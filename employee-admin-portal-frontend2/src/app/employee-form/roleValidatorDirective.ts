import { Directive, forwardRef } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl, ValidationErrors } from '@angular/forms';


@Directive({
  selector: '[appRoleValidator]',
  providers: [
    { provide: NG_VALIDATORS, useExisting: forwardRef(() => RoleValidatorDirective), multi: true }
  ]
})


export class RoleValidatorDirective implements Validator {
  validate(control: AbstractControl): ValidationErrors | null {
    const validRoles = ['ADMIN', 'USER'];
    return validRoles.includes(control.value) ? null : { invalidRole: true };
  }
}