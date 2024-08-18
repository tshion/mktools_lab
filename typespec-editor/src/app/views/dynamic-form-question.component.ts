import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormArray, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
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
                    <input [formControlName]="question.key" [id]="question.key"
                        [colorPicker]="this.form.controls[question.key].getRawValue()"
                        [cpAlphaChannel]="'enabled'"
                        [cpOutputFormat]="'rgba'"
                        (colorPickerChange)="this.form.controls[question.key].setValue($event)" />
                    <!-- <input [formControlName]="question.key" [id]="question.key" type="color" /> -->
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
                @case ('text-array') {
                    <input [formControlName]="question.key" [id]="question.key" type="text" />
                    <button (click)="add(question.key)">追加</button>
                    <button (click)="remove(question.key, 0)">削除</button>
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

    @Input() question!: QuestionBaseEntity<unknown>;

    @Input() form!: FormGroup;

    get isValid() {
        return this.form.controls[this.question.key].valid;
    }


    public add(key: string) {
        (this.form.controls[key] as FormArray).push(new FormControl());
    }

    public remove(key: string, index: number) {
        (this.form.controls[key] as FormArray).removeAt(index);
    }
}
