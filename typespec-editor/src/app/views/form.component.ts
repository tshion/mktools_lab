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
        <form class="pure-form">
            <label for="file">ファイル：</label>
            <input type="file" id="fileSelector" name="file" (change)="fileChanged($event)">
        </form>

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
                <button class="pure-button pure-button-primary" type="submit" [disabled]="!form.valid">保存</button>
                @if (dlUrl) {
                    <a class="pure-button pure-button-primary" download="sample.json" [href]="dlUrl">ファイル保存</a>
                }
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

    dlUrl: string | undefined;

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


    fileChanged(event: Event) {
        const dom = event.target as HTMLInputElement;
        const file = dom?.['files']?.[0];
        if (file?.type !== 'application/json') {
            return;
        }

        const reader = new FileReader();
        reader.addEventListener('load', e => {
            if (file?.type !== 'application/json') {
                return;
            }

            const result = reader.result;
            if (!result) {
                return;
            }

            const data: [string, any][] = JSON.parse(result.toString());
            Object.entries(data).forEach(([k, v]) => {
                const s = this.schemas?.find(x => x.key === k);
                if (s) {
                    this.getControls(s).clear();
                    if (s.isArray) {
                        v.forEach(x => this.addControl(s, x));
                    } else {
                        this.addControl(s, v);
                    }
                }
            });
        }, false);
        reader.readAsText(file, 'UTF-8');
    }

    onSubmit() {
        const rawValue: [string, Array<any>][] = this.form.getRawValue();
        const saveData: any = {};
        for (const [k, v] of Object.entries(rawValue)) {
            const target = this.schemas?.find(x => x.key === k);
            if (!target) {
                continue;
            }

            // FIXME: 無効な値の取り扱い
            saveData[k] = target.isArray
                ? v.filter(x => !!x)
                : v[0];
        }
        this.payLoad = JSON.stringify(saveData, null, 4);

        const blob = new Blob([this.payLoad], { type: 'application/json' });
        this.dlUrl = window.URL.createObjectURL(blob);
    }


    public addControl(data: InputSchemaDto, value?: any) {
        let v = value;
        if (!value) {
            switch (data.inputType) {
                case 'checkbox':
                    v = false;
                    break;
                case 'number':
                    v = 0;
                    break
                case 'color':
                    v = '#FFFFFF'
                    break;
                case 'select':
                    v = data.options?.[0];
                    break;
                case 'textbox':
                    v = '';
                    break;
            }
        }
        this.getControls(data).push(new FormControl(v));
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
