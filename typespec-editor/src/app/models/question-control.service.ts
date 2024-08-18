import { Injectable } from '@angular/core';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { QuestionBaseEntity } from './question.base.entity';

@Injectable()
export class QuestionControlService {

    toFormGroup(
        questions: QuestionBaseEntity<unknown>[],
    ) {
        const group: any = {};
        questions.forEach((question) => {
            if (question.formType === 'text-array') {
                group[question.key] = new FormArray([]);
            } else {
                group[question.key] = new FormControl(question.value || '');
            }
        });
        return new FormGroup(group);
    }
}
