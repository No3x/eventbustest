import com.google.common.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by czoeller on 17.02.17.
 */
public class App {

    private final EventBus eventBus;
    private final Clock clock;
    private final Display display;

    @Inject
    public App(EventBus eventBus, Clock clock, Display display) {
        this.eventBus = eventBus;
        this.clock = clock;
        this.display = display;
    }

    void run() {
        new Thread(clock).start();
        new Thread(clock).start();
    }
}
