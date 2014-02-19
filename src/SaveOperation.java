/**
 * Created by taras on 15.02.14.
 */
public class SaveOperation implements  Operation {

    private final MetricSet<AsciiImage> saved;


    public SaveOperation(MetricSet<AsciiImage> saved) {
        this.saved = saved;
    }


    public AsciiImage execute(AsciiImage img) throws OperationException {
        if(img != null) {
            saved.add(img);
        }

        return AsciiImage.copy2(img);
    }

    public MetricSet<AsciiImage> getSaved() {
        return saved;
    }
}
