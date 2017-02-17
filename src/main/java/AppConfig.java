import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;

/**
 * Created by No3x on 17.02.17.
 */
public class AppConfig extends AbstractModule {
    @Override
    protected void configure() {
        bind(EventBus.class).asEagerSingleton();
    }
}
