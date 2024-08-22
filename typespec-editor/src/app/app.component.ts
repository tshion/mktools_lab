import { AsyncPipe } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Observable } from 'rxjs';
import { InputSchemaDto, inputSchemas } from '../input-schema';
import { QuestionBaseEntity } from './models/question.base.entity';
import { QuestionService } from './models/question.service';
import { DynamicFormComponent } from './views/dynamic-form.component';
import { FormComponent } from "./views/form.component";

@Component({
    selector: 'app-root',
    standalone: true,
    providers: [QuestionService],
    imports: [
        AsyncPipe,
        DynamicFormComponent,
        FormComponent,
        RouterOutlet,
    ],
    template: `
    <h1>Welcome to {{title}}!</h1>

    <!-- <router-outlet /> -->
    <div>
      <h2>Job Application for Heroes</h2>
      <!-- <app-dynamic-form [questions]="questions$ | async"></app-dynamic-form> -->
       <app-form [schemas]="list" />
    </div>
  `,
    styles: [],
})
export class AppComponent {

    list: InputSchemaDto[];

    questions$: Observable<QuestionBaseEntity<any>[]>;

    title = 'typespec-editor';


    constructor(service: QuestionService) {
        this.list = inputSchemas;
        this.questions$ = service.getQuestions();
    }
}
