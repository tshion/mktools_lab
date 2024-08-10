import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { QuestionBaseEntity } from './question.base.entity';
import { TextboxQuestionEntity } from './question-textbox.entity';
import { IntegerQuestionEntity } from './question-integer.entity';
import { RgbQuestionEntity } from './question-rgb.entity';

@Injectable()
export class QuestionService {
    // TODO: get from a remote source of question metadata
    getQuestions() {
        const questions: QuestionBaseEntity<unknown>[] = [
            // new DropdownQuestion({
            //     key: 'favoriteAnimal',
            //     label: 'Favorite Animal',
            //     options: [
            //         { key: 'cat', value: 'Cat' },
            //         { key: 'dog', value: 'Dog' },
            //         { key: 'horse', value: 'Horse' },
            //         { key: 'capybara', value: 'Capybara' },
            //     ],
            //     order: 3,
            // }),

            new IntegerQuestionEntity(
                'int',
                'integer1',
                0,
            ),
            new RgbQuestionEntity(
                'rgb',
                'rgb1',
                '',
            ),
            new TextboxQuestionEntity(
                'txt',
                'text1',
                '',
            ),
        ];
        return of(questions);
    }
}
