package spinc.spmmvp.daggerExample.interfaceImpl;

public class HelloServiceManager implements HelloService {

    @Override

    public String greet(String userName) {

        return "Hello " + userName + "!";

    }

}