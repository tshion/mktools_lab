import { Component, Input } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { QuestionBaseEntity } from '../models/question.base.entity';

@Component({
    standalone: true,
    selector: 'app-question',
    imports: [
        CommonModule,
        ReactiveFormsModule,
    ],
    template: `
    <div [formGroup]="form">
        <label [attr.for]="question.key">{{ question.label }}</label>

        <div>
            @switch (question.formType) {
                @case ('integer') {
                    <input [formControlName]="question.key" [id]="question.key" type="number" />
                }
                @case ('textbox') {
                    <input [formControlName]="question.key" [id]="question.key" type="text" />
                }
                @case ('dropdown') {
                    <select [id]="question.key" [formControlName]="question.key">
                    <!-- @for (opt of question.options; track opt) {
                        <option [value]="opt.key">{{ opt.value }}</option>
                    } -->
                    </select>
                }
            }
        </div>
    </div>`,
})
export class DynamicFormQuestionComponent {

    @Input() question!: QuestionBaseEntity<unknown>;

    @Input() form!: FormGroup;

    get isValid() {
        return this.form.controls[this.question.key].valid;
    }
}
