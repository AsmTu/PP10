
public class SearchOperation implements Operation {

    private final MetricSet<AsciiImage> saved;
    private final Histogram<AsciiImage> metric;

    public SearchOperation(MetricSet<AsciiImage> saved, Histogram<AsciiImage> m) {
        this.saved = saved;
        this.metric = m;
    }
    public AsciiImage execute(AsciiImage img) throws OperationException {
        if(saved == null || saved.isEmpty()) {
            throw new OperationException("OPERATION FAILED");
        }
        return saved.search(img, metric).iterator().next();
    }
}
