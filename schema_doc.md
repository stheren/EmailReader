## core_mail
Type: `object`

&#36;schema: [https://json-schema.org/draft/2019-09/schema](https://json-schema.org/draft/2019-09/schema)

**_Properties_**

- <b id="#/properties/_id">_id</b> `required`
    - _uid RFC4122_
    - Type: `string`
    - <i id="#/properties/_id">path: #/properties/_id</i>
    - String format must be a "uuid"
- <b id="#/properties/metadata">metadata</b> `required`
    - Type: `object`
    - <i id="#/properties/metadata">path: #/properties/metadata</i>
    - **_Properties_**
        - <b id="#/properties/metadata/properties/sender">sender</b> `required`
            - Type: `object`
            - <i id="#/properties/metadata/properties/sender">path: #/properties/metadata/properties/sender</i>
            - **_Properties_**
                - <b id="#/properties/metadata/properties/sender/properties/name">name</b> `required`
                    - Type: `string`
                    - <i id="#/properties/metadata/properties/sender/properties/name">path: #/properties/metadata/properties/sender/properties/name</i>
                - <b id="#/properties/metadata/properties/sender/properties/lastName">lastName</b> `required`
                    - Type: `string`
                    - <i id="#/properties/metadata/properties/sender/properties/lastName">path: #/properties/metadata/properties/sender/properties/lastName</i>
                - <b id="#/properties/metadata/properties/sender/properties/account">account</b> `required`
                    - Type: `string`
                    - <i id="#/properties/metadata/properties/sender/properties/account">path: #/properties/metadata/properties/sender/properties/account</i>
                - <b id="#/properties/metadata/properties/sender/properties/mail">mail</b> `required`
                    - Type: `string`
                    - <i id="#/properties/metadata/properties/sender/properties/mail">path: #/properties/metadata/properties/sender/properties/mail</i>
                    - String format must be a "email"
        - <b id="#/properties/metadata/properties/receiver">receiver</b> `required`
            - Type: `string`
            - <i id="#/properties/metadata/properties/receiver">path: #/properties/metadata/properties/receiver</i>
            - String format must be a "email"
        - <b id="#/properties/metadata/properties/subject">subject</b> `required`
            - Type: `string`
            - <i id="#/properties/metadata/properties/subject">path: #/properties/metadata/properties/subject</i>
        - <b id="#/properties/metadata/properties/categories">categories</b>
            - Type: `array`
            - <i id="#/properties/metadata/properties/categories">path: #/properties/metadata/properties/categories</i>
                - **_Items_**
                - Type: `string`
                - <i id="#/properties/metadata/properties/categories/items">path: #/properties/metadata/properties/categories/items</i>
        - <b id="#/properties/metadata/properties/date">date</b> `required`
            - _ISO8601_
            - Type: `string`
            - <i id="#/properties/metadata/properties/date">path: #/properties/metadata/properties/date</i>
            - String format must be a "date-time"
- <b id="#/properties/content">content</b> `required`
    - Type: `string`
    - <i id="#/properties/content">path: #/properties/content</i>
- <b id="#/properties/history">history</b>
    - Type: `string`
    - <i id="#/properties/history">path: #/properties/history</i>
    - String format must be a "uuid"
- <b id="#/properties/extentions">extentions</b>
    - Type: `array`
    - <i id="#/properties/extentions">path: #/properties/extentions</i>
        - **_Items_**
        - Type: `object`
        - <i id="#/properties/extentions/items">path: #/properties/extentions/items</i>
        - **_Properties_**
            - <b id="#/properties/extentions/items/properties/name">name</b> `required`
                - Type: `string`
                - <i id="#/properties/extentions/items/properties/name">path: #/properties/extentions/items/properties/name</i>
            - <b id="#/properties/extentions/items/properties/_id">_id</b> `required`
                - Type: `string`
                - <i id="#/properties/extentions/items/properties/_id">path: #/properties/extentions/items/properties/_id</i>
                - String format must be a "uuid"
            - <b id="#/properties/extentions/items/properties/reference">reference</b> `required`
                - Type: `object`
                - <i id="#/properties/extentions/items/properties/reference">path: #/properties/extentions/items/properties/reference</i>
                - **_Properties_**
            - <b id="#/properties/extentions/items/properties/version">version</b> `required`
                - Type: `string`
                - <i id="#/properties/extentions/items/properties/version">path: #/properties/extentions/items/properties/version</i>
            