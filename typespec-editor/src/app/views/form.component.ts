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
                <div class="form-row">
                    <div [formGroup]="form">
                        <label [attr.for]="schema.key">{{ schema.label }}</label>
                        <div>
                            @switch (schema.inputType) {
                                @case ('checkbox') {
                                    <input [formControlName]="schema.key" [id]="schema.key" type="checkbox" />
                                }
                                @case ('color') {
                                    <input [formControlName]="schema.key" [id]="schema.key" type="color" />
                                }
                                @case ('number') {
                                    <input [formControlName]="schema.key" [id]="schema.key" type="number" step="1" />
                                }
                                @case ('select') {
                                    <select [formControlName]="schema.key" [id]="schema.key">
                                        @for (v of schema.options; track v) {
                                            <option [value]="v">{{ v }}</option>
                                        }
                                    </select>
                                }
                                @case ('textbox') {
                                    <input [formControlName]="schema.key" [id]="schema.key" type="text" />
                                }
                            }
                        </div>
                        @if (schema.isArray) {
                            <button class="pure-button" (click)="add(schema)">追加</button>
                            <button class="pure-button" (click)="remove(schema.key, 0)">削除</button>
                        }
                    </div>
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
            if (item.isArray) {
                const controls = item.value.map(x => new FormControl(x));
                group[item.key] = new FormArray(controls);
            } else {
                group[item.key] = new FormControl(item.value[0]);
            }
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

    public remove(key: string, index: number) {
        (this.form.controls[key] as FormArray).removeAt(index);
    }
}
