import { FormType } from '../types/form.type';
import { QuestionBaseEntity } from './question.base.entity';

export class IntegerQuestionEntity extends QuestionBaseEntity<number> {
    override formType: FormType = 'integer';
}
