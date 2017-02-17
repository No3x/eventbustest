import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.inject.Inject;

/**
 * Created by No3x on 17.02.17.
 */
public class Display {

    @Inject
    public Display(final EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void updateView(CounterChangeEvent event) {
        System.out.println(event.getValue());
    }

}
