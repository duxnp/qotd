package qotd

class SimpleTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def simple = { attrs, body ->

    }

    /**
     * Renders the body with an emoticon.
     *
     * @attr happy whether to show a happy emoticon ('true') or
     * a sad emoticon ('false')
     */
    def emoticon = { attrs, body ->
       out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")
    }

    /**
     * Creates a new password field.
     *
     * @attr name REQUIRED the field name
     * @attr value the field value
     */
    def passwordField = { attrs ->
        attrs.type = "password"
        attrs.tagName = "passwordField"
        fieldImpl(out, attrs)
    }

    def repeat = { attrs, body ->
        def var = attrs.var ?: "num"
        attrs.times?.toInteger()?.times { num ->
            // raw() will output unescaped values
            out << raw(body((var):num))
        }
    }
}
