import { FormType } from '../types/form.type';
import { QuestionBaseEntity } from './question.base.entity';

export class TextboxQuestionEntity extends QuestionBaseEntity<string> {
    override formType: FormType = 'textbox';
}
