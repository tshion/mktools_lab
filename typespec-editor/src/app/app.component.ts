import { AsyncPipe } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { QuestionService } from './models/question.service';
import { DynamicFormComponent } from './views/dynamic-form.component';
import { QuestionBaseEntity } from './models/question.base.entity';
import { Observable } from 'rxjs';

@Component({
    selector: 'app-root',
    standalone: true,
    providers: [QuestionService],
    imports: [
        AsyncPipe,
        DynamicFormComponent,
        RouterOutlet,
    ],
    template: `
    <h1>Welcome to {{title}}!</h1>

    <!-- <router-outlet /> -->
    <div>
      <h2>Job Application for Heroes</h2>
      <app-dynamic-form [questions]="questions$ | async"></app-dynamic-form>
    </div>
  `,
    styles: [],
})
export class AppComponent {

    questions$: Observable<QuestionBaseEntity<any>[]>;

    title = 'typespec-editor';


    constructor(service: QuestionService) {
        this.questions$ = service.getQuestions();
    }
}
