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
        <form (ngSubmit)="onSubmit()" [formGroup]="form" class="pure-form pure-form-stacked">
            @for (schema of schemas; track schema) {
                <div [formArrayName]="schema.key">
                    <h2>
                        {{ schema.key }}
                        @if (hasChange(schema)) {
                            <span style="color: red;">※変更中</span>
                        }
                    </h2>
                    @if (schema.isArray) {
                        <button type="button" class="pure-button" (click)="addControl(schema)">追加</button>
                    }
                    <ng-container *ngFor="let _ of getControls(schema).controls; let i = index">
                        @switch (schema.inputType) {
                            @case ('checkbox') {
                                <label for="{{ schema.key }}-{{ i }}" class="pure-checkbox">
                                    <input type="checkbox" id="{{ schema.key }}-{{ i }}" [formControlName]="i" />
                                    <span class="pure-form-message-inline">{{ schema.label }}</span>
                                </label>
                            }
                            @case ('color') {
                                <label for="{{ schema.key }}-{{ i }}">{{ schema.label }}</label>
                                <input type="color" id="{{ schema.key }}-{{ i }}" [formControlName]="i" />
                                <span class="pure-form-message-inline">{{ getControls(schema).controls[i].getRawValue() }}</span>
                            }
                            @case ('number') {
                                <label for="{{ schema.key }}-{{ i }}">{{ schema.label }}</label>
                                <input type="number" step="1" id="{{ schema.key }}-{{ i }}" [formControlName]="i" />
                            }
                            @case ('select') {
                                <label for="{{ schema.key }}-{{ i }}">{{ schema.label }}</label>
                                <select id="{{ schema.key }}-{{ i }}" [formControlName]="i">
                                    @for (opt of schema.options; track opt) {
                                        <option [value]="opt">{{ opt }}</option>
                                    }
                                </select>
                            }
                            @case ('textbox') {
                                <label for="{{ schema.key }}-{{ i }}">{{ schema.label }}</label>
                                <input type="text" id="{{ schema.key }}-{{ i }}" [formControlName]="i" />
                            }
                        }
                        @if (schema.isArray) {
                            <button type="button" class="pure-button" (click)="removeControl(schema, i)">削除</button>
                        }
                    </ng-container>
                </div>
                <button class="pure-button" type="button" (click)="resetControls(schema)">リセット</button>
            }
            <div>
                <button class="pure-button pure-button-primary" type="submit" [disabled]="!form.valid">Save</button>
            </div>
        </form>

        @if (payLoad) {
            <div>
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


    public addControl(data: InputSchemaDto, value?: any) {
        this.getControls(data).push(new FormControl(value));
    }

    public getControls(data: InputSchemaDto) {
        return this.form.controls[data.key] as FormArray;
    }

    public hasChange(data: InputSchemaDto) {
        const input = this.getControls(data).getRawValue();
        return input.length !== data.value.length
            || !input.every(x => data.value.includes(x));
    }

    public removeControl(data: InputSchemaDto, index: number) {
        this.getControls(data).removeAt(index);
    }

    public resetControls(data: InputSchemaDto) {
        this.getControls(data).clear();
        data.value.forEach(x => this.addControl(data, x));
    }
}
