import "@typespec/json-schema";

using TypeSpec.JsonSchema;

@jsonSchema
namespace Schemas;

/** Respresent an address */
model Address {
    street: string;
    city: string;
    country: string;
}
