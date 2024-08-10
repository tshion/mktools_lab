import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { QuestionBaseEntity } from '../models/question.base.entity';
import { DynamicFormQuestionComponent } from './dynamic-form-question.component';
import { QuestionControlService } from '../models/question-control.service';

@Component({
    standalone: true,
    selector: 'app-dynamic-form',
    providers: [
        QuestionControlService,
    ],
    imports: [
        CommonModule,
        DynamicFormQuestionComponent,
        ReactiveFormsModule,
    ],
    template: `
    <div>
        <form (ngSubmit)="onSubmit()" [formGroup]="form">
            @for (question of questions; track question) {
                <div class="form-row">
                    <app-question [question]="question" [form]="form"></app-question>
                </div>
            }
            <div class="form-row">
                <button type="submit" [disabled]="!form.valid">Save</button>
            </div>
        </form>

        @if (payLoad) {
            <div class="form-row">
                <strong>Saved the following values</strong><br>{{ payLoad }}
            </div>
        }
    </div>`,
})
export class DynamicFormComponent implements OnInit {

    @Input() questions: QuestionBaseEntity<unknown>[] | null = [];

    form!: FormGroup;

    payLoad = '';

    constructor(
        private readonly qcs: QuestionControlService,
    ) {
    }


    ngOnInit() {
        this.form = this.qcs.toFormGroup(this.questions as QuestionBaseEntity<unknown>[]);
    }


    onSubmit() {
        this.payLoad = JSON.stringify(this.form.getRawValue());
    }
}
