import { Injectable } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { QuestionBaseEntity } from './question.base.entity';

@Injectable()
export class QuestionControlService {

    toFormGroup(
        questions: QuestionBaseEntity<unknown>[],
    ) {
        const group: any = {};
        questions.forEach((question) => {
            group[question.key] = new FormControl(question.value || '');
        });
        return new FormGroup(group);
    }
}
