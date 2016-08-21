import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

public class Suppliers {

    public static <T> Supplier<T> memoize(Supplier<T> delegate, Predicate<T> condition) {
        return (delegate instanceof MemoizingSupplier)
                ? delegate
                : new MemoizingSupplier<T>(checkNotNull(delegate), checkNotNull(condition));
    }

    public static <T> Supplier<T> memoizeCareFree(Supplier<T> delegate, Predicate<T> condition) {
        return (delegate instanceof MemoizingCareFreeSupplier)
                ? delegate
                : new MemoizingCareFreeSupplier<T>(checkNotNull(delegate), checkNotNull(condition));
    }

    private static class MemoizingCareFreeSupplier<T> implements Supplier<T>, Serializable {

        private static final long serialVersionUID = 1;

        final Supplier<T> delegate;
        final Predicate<T> condition;
        transient volatile boolean initialized;
        transient T value;

        MemoizingCareFreeSupplier(Supplier<T> delegate, Predicate<T> condition) {
            this.delegate = delegate;
            this.condition = condition;
        }

        @Override
        public T get() {
            if (!initialized) {
                T t = delegate.get();
                value = t;
                if (condition.apply(t)) {
                    initialized = true;
                }

                return t;
            }

            return value;
        }

        @Override
        public String toString() {
            return "Suppliers.memoize(" + delegate + ")";
        }
    }

    private static class MemoizingSupplier<T> extends MemoizingCareFreeSupplier<T> {

        MemoizingSupplier(Supplier<T> delegate, Predicate<T> condition) {
            super(delegate, condition);
        }

        @Override
        public T get() {
            if (!initialized) {
                synchronized (this) {
                    super.get();
                }
            }

            return value;
        }
    }

}
