package hello.proxy.pureproxy.concreteproxy.code;

public class ConcreteClient {
    private ConcreateLogic concreateLogic;

    public ConcreteClient(ConcreateLogic concreateLogic) {
        this.concreateLogic = concreateLogic;
    }

    public void execute() {
        concreateLogic.operation();
    }
}
