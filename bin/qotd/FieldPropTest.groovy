package qotd

class FieldPropTest{
    // Groovy will not auto generate getter / setter when an access modifier is used
    public String thisIsAField

    // No access modifier here, so getter / setter and an internal private variable are auto generated
    String thisIsAProperty
}