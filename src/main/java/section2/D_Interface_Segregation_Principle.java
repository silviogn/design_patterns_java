package section2;

// recommendation of how segregate interfaces
// not put moore than the client is expecting


public class D_Interface_Segregation_Principle {
}


class Document {}

interface Machine {
    void print(Document d);
    void fax(Document d) throws Exception;
    void scan(Document d);
}

class MultiFunctionPrinter implements Machine{

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OldFashionPrinter implements Machine {

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) throws Exception {
        throw new Exception("");
    }

    @Override
    public void scan(Document d) {

    }
}
/////// ------------------------------------
// This is the solution provided by the author.
// Split the machine interface in many interfaces as possible

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

// yagni = You ain't going to need it

class JustPrinterInterface implements Printer{
    @Override
    public void print(Document d) {

    }
}


class PhotoCopier implements Printer, Scanner {

    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultiFunctionDevice extends Printer, Scanner {
}

class MultiFunctionMachine implements MultiFunctionDevice {

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}











