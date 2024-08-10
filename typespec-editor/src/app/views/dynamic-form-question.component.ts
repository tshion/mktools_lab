import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { QuestionBaseEntity } from '../models/question.base.entity';

@Component({
    standalone: true,
    selector: 'app-question',
    imports: [
        CommonModule,
        MatFormFieldModule,
        MatInputModule,
        ReactiveFormsModule,
    ],
    template: `
    <mat-form-field [formGroup]="form">
        <mat-label [attr.for]="question.key">{{ question.label }}</mat-label>

        <div>
            @switch (question.formType) {
                @case ('integer') {
                    <input matInput [formControlName]="question.key" [id]="question.key" type="number" />
                }
                @case ('textbox') {
                    <input matInput [formControlName]="question.key" [id]="question.key" type="text" />
                }
                @case ('dropdown') {
                    <mat-select [id]="question.key" [formControlName]="question.key">
                    <!-- @for (opt of question.options; track opt) {
                        <option [value]="opt.key">{{ opt.value }}</option>
                    } -->
                    </mat-select>
                }
            }
        </div>
    </mat-form-field>`,
})
export class DynamicFormQuestionComponent {

    @Input() question!: QuestionBaseEntity<unknown>;

    @Input() form!: FormGroup;

    get isValid() {
        return this.form.controls[this.question.key].valid;
    }
}
