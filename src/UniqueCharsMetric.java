/**
 * Created by taras on 14.02.14.
 */
public class UniqueCharsMetric implements Histogram<AsciiImage> {
    public int distance(AsciiImage o1, AsciiImage o2) {
        if(o1.getUniqueChars()>=o2.getUniqueChars()){
            return o1.getUniqueChars()-o2.getUniqueChars();
        }else{
            return o2.getUniqueChars()-o1.getUniqueChars();
        }
    }
}
