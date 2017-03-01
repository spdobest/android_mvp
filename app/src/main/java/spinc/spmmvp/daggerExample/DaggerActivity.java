package spinc.spmmvp.daggerExample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import spinc.spmmvp.R;
import spinc.spmmvp.daggerExample.interfaceImpl.HelloService;

/**
 * Created by webwerks on 28/2/17.
 */

public class DaggerActivity extends AppCompatActivity {

//    https://dzone.com/articles/an-introduction-to-dagger-2-android-di-part-1-3

    //DAGGER MODULE

    //A dagger module provides the way that constructs the objects which will be injected.
    // In order to define a dagger module, create a class and annotate it with @Module annotation
    // and define the provider methods that return the instances. Provider methods have to be annotated by
    // @Provider annotation as shown below.

    //Component
//    A dagger component can be seen as an intermediate object which allows
// accessing to objects defined in Dagger modules.

    @Inject
    HelloService helloService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}