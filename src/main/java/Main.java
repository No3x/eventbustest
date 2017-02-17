import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by No3x on 17.02.17.
 */
public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppConfig());
        injector.getInstance(App.class).run();
    }

}
