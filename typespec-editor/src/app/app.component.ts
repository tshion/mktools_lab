import { AsyncPipe } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { InputSchemaDto, inputSchemas } from '../input-schema';
import { FormComponent } from "./views/form.component";

@Component({
    selector: 'app-root',
    standalone: true,
    providers: [],
    imports: [
        AsyncPipe,
        FormComponent,
        RouterOutlet,
    ],
    template: `<app-form [schemas]="list" />`,
    styles: [],
})
export class AppComponent {

    list: InputSchemaDto[];


    constructor(
    ) {
        this.list = inputSchemas;
    }
}
