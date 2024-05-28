package hello.proxy.pureproxy.concreteproxy;

import hello.proxy.pureproxy.concreteproxy.code.ConcreateLogic;
import hello.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import hello.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {
    @Test
    void noProxy() {
        ConcreateLogic concreateLogic = new ConcreateLogic();
        ConcreteClient client = new ConcreteClient(concreateLogic);

        client.execute();
    }

    @Test
    void addProxy() {
        ConcreateLogic concreateLogic = new ConcreateLogic();
        TimeProxy timeProxy = new TimeProxy(concreateLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
