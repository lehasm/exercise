
import com.google.common.base.Supplier;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class SharedState {

    private ExecutorService executorService = Executors.newFixedThreadPool(15);

    private final AtomicBoolean aborted = new AtomicBoolean(false);

    public void load(int count) {
        Supplier<Boolean> supplier = Suppliers.memoizeCareFree(this::remoteCheck, input -> input);
        for (int i = 0; i < count; i++) {
            executorService.submit((Callable<Object>) () -> {
                if (supplier.get()) {
                    return "";
                }

                doLoad();

                return null;
            });
        }

    }

    public /*synchronized*/ boolean check() {
        if (aborted.get()) {
            System.out.println(Thread.currentThread().getName() + " missed");
            return true;
        }

        if (remoteCheck()) {
            aborted.set(true);
            System.out.println(Thread.currentThread().getName() + " checked " + aborted);
        }

        return aborted.get();
    }

    public boolean remoteCheck() {
        return false;
    }

    public void doLoad() {
        System.out.println(Thread.currentThread().getName() + " load");
    }

}
