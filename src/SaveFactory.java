import java.util.Scanner;

/**
 * Created by taras on 14.02.14.
 */
public class SaveFactory  implements Factory{

    private final MetricSet<AsciiImage> saved;
    public SaveFactory(MetricSet<AsciiImage> saved) {
        this.saved = saved;
    }

    public Operation create(Scanner scanner) throws FactoryException {
        return new SaveOperation(saved);
    }
}
