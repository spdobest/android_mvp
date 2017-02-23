package spinc.spmmvp.mvp_pattern.register;

/**
 * Created by webwerks on 15/2/17.
 */

public interface RegisterInteractorInterface {

    void doLogin( );
    void doRegister(String name , String email,String password);

}
