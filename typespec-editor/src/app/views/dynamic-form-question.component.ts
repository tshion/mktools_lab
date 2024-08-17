import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ColorPickerModule } from 'ngx-color-picker';
import { QuestionBaseEntity } from '../models/question.base.entity';

@Component({
    standalone: true,
    selector: 'app-question',
    imports: [
        ColorPickerModule,
        CommonModule,
        MatFormFieldModule,
        MatInputModule,
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
                @case ('rgb') {
                    <!-- <input [formControlName]="question.key" [id]="question.key" type="color" /> -->
                    <!-- <input [formControlName]="question.key" [id]="question.key" [(colorPicker)]="color" [style.background]="color" [cpOutputFormat]="'hex'" [value]="color" /> -->
                    <input [formControlName]="question.key" [id]="question.key" type="color" />
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
    </div>

    <!--<mat-form-field [formGroup]="form">
        <mat-label [attr.for]="question.key">{{ question.label }}</mat-label>

        <div>
            @switch (question.formType) {
                @case ('integer') {
                    <input matInput [formControlName]="question.key" [id]="question.key" type="number" />
                }
                @case ('rgb') {
                    <input matInput [formControlName]="question.key" [id]="question.key" type="color" />
                }
                @case ('textbox') {
                    <input matInput [formControlName]="question.key" [id]="question.key" type="text" />
                }
                @case ('dropdown') {
                    <mat-select [id]="question.key" [formControlName]="question.key">
                    @for (opt of question.options; track opt) {
                        <option [value]="opt.key">{{ opt.value }}</option>
                    }
                    </mat-select>
                }
            }
        </div>
    </mat-form-field> -->`,
})
export class DynamicFormQuestionComponent {

    color: string = '';

    @Input() question!: QuestionBaseEntity<unknown>;

    @Input() form!: FormGroup;

    get isValid() {
        return this.form.controls[this.question.key].valid;
    }
}
