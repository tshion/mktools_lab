import { FormType } from '../types/form.type';
import { QuestionBaseEntity } from './question.base.entity';

export class RgbQuestionEntity extends QuestionBaseEntity<string> {
    override formType: FormType = 'rgb';
}
