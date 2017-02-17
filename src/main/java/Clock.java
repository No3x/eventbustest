import com.google.common.eventbus.EventBus;
import de.no3x.countercascade.Counter;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

/**
 * Created by No3x on 17.02.17.
 */
public class Clock implements Runnable {

    private final EventBus eventBus;
    private final Counter counter;
    private volatile boolean stopped = false;

    @Inject
    public Clock(final EventBus eventBus,final Counter counter) {
        this.eventBus = eventBus;
        this.counter = counter;
        eventBus.register(this);
    }

    @Override
    public void run() {
        while (!stopped) {
            synchronized (counter) {
                eventBus.post(new CounterChangeEvent( counter.increment() ) );
            }
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.stopped = true;
    }
}

