import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { InputSchemaDto } from '../../input-schema';

@Component({
    standalone: true,
    selector: 'app-form',
    imports: [
        CommonModule,
        ReactiveFormsModule,
    ],
    template: `
    <div>
        <form (ngSubmit)="onSubmit()" [formGroup]="form" class="pure-form pure-form-aligned">
            @for (schema of schemas; track schema) {
                <div class="pure-control-group" [formGroup]="form">
                    <p>{{ schema.key }}</p>
                    @for (cntl of getControls(schema.key).controls; track cntl) {
                        @switch (schema.inputType) {
                            @case ('checkbox') {
                                <label [attr.for]="schema.key" class="pure-checkbox">
                                    <input type="checkbox" [formControlName]="schema.key" [id]="schema.key" />
                                    <span class="pure-form-message-inline">{{ schema.label }}</span>
                                </label>
                            }
                            @case ('number') {
                                <label [attr.for]="schema.key">{{ schema.label }}</label>
                                <input type="number" step="1" [formControlName]="schema.key" [id]="schema.key" />
                            }
                        }
                    }
                    <button class="pure-button" type="button" (click)="reset(schema)">Reset</button>
                </div>
            }
            <div class="form-row">
                <button class="pure-button pure-button-primary" type="submit" [disabled]="!form.valid">Save</button>
            </div>
        </form>

        @if (payLoad) {
            <div class="form-row">
                <strong>Saved the following values</strong><br>{{ payLoad }}
            </div>
        }
    </div>`,
})
export class FormComponent implements OnInit {

    form!: FormGroup;

    payLoad = '';

    @Input() schemas: InputSchemaDto[] | null = [];


    ngOnInit(): void {
        const group: any = {};
        this.schemas?.forEach(item => {
            const controls = item.value.map(x => new FormControl(x));
            group[item.key] = new FormArray(controls);
        });
        this.form = new FormGroup(group);
    }


    onSubmit() {
        const a = this.form;
        const b = a.getRawValue();
        this.payLoad = JSON.stringify(this.form.getRawValue());
    }


    public add(data: InputSchemaDto) {
        (this.form.controls[data.key] as FormArray).push(new FormControl());
    }

    public getControls(key: string) {
        return this.form.controls[key] as FormArray;
    }

    public remove(key: string, index: number) {
        (this.form.controls[key] as FormArray).removeAt(index);
    }

    public reset(item: InputSchemaDto) {
        const controls = item.value.map(x => new FormControl(x));
        this.form.controls[item.key] = new FormArray(controls);
    }
}
