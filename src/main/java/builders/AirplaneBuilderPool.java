package builders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AirplaneBuilderPool implements  Iterable<Class<? extends AirplaneBuilder>> {
    private final List<Class<? extends AirplaneBuilder>> builderPool;
    {
        builderPool = new ArrayList<>();
        builderPool.add(AirplaneCargoBuilder1.class);
        builderPool.add(AirplaneCargoBuilder2.class);
        builderPool.add(AirplanePassengerBuilder1.class);
        builderPool.add(AirplanePassengerBuilder2.class);
    }

    public int getPoolSize() {
        return builderPool.size();
    }

    public Class<? extends AirplaneBuilder> getCertainBuilder(int index) {
        return builderPool.get(index);
    }

    @Override
    public Iterator<Class<? extends AirplaneBuilder>> iterator() {
        return builderPool.iterator();
    }
}
