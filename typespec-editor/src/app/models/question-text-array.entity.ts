import { FormType } from '../types/form.type';
import { QuestionBaseEntity } from './question.base.entity';

export class TextArrayQuestionEntity extends QuestionBaseEntity<string[]> {
    override formType: FormType = 'text-array';
}
