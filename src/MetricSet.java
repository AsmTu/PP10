import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by taras on 14.02.14.
 */
public class MetricSet<E> extends LinkedHashSet<E> {

    public MetricSet(){
        super();
    }
    public MetricSet(Collection<? extends E> c){
        super(c);
    }

    public MetricSet<E> search(E e, Histogram<? super E> m){
        MetricSet<E> returnSet = new MetricSet<E>();
        int distance = 0;
        Iterator<E> iter = iterator();

        while(iter.hasNext()) {
            E next = iter.next();
            if(returnSet.isEmpty()|| distance>m.distance(e,next)) {
                returnSet = new MetricSet<E>();
                returnSet.add(next);
                distance = m.distance(e,next);
            } else {
                returnSet.add(next);
            }
        }



        return returnSet;
    }

}
