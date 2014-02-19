import java.util.Scanner;

/**
 * Created by taras on 16.02.14.
 */
public class SearchFactory implements Factory {

    private final MetricSet<AsciiImage> saved;

    public SearchFactory(MetricSet<AsciiImage> saved) {
        this.saved = saved;
    }

    public Operation create(Scanner scanner) throws FactoryException {
        if(!scanner.hasNext()) {
            throw new FactoryException("INPUT MISMATCH");
        }
        String s = scanner.next();
        if(s.equals("pixelcount")) {
            return new SearchOperation(saved, new PixelCountMetric());
        }
        if(s.equals("uniquechars")) {
            return new SearchOperation(saved, new UniqueCharsMetric());
        }
        throw new FactoryException("INPUT MISMATCH");
    }

}



