import "@typespec/json-schema";
import "./color.tsp";

using TypeSpec.JsonSchema;

@jsonSchema
namespace Schemas;

model Schema {
    /** 色リスト */
    items: Color[] = [];
}
