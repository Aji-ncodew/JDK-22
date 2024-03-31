//Foreign Function & Memory API – JEP 456

void main() throws Throwable {
    int number=17;
    try {
        if(number<20)
            throw new NumberFormatException();
    } catch (NumberFormatException _) {
        System.err.println("Not a number");
    }
}
