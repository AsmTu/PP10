/**
 * Created by taras on 28.01.14.
 */
public abstract class FilterOperation implements Operation {
    FilterOperation(){

    }

    public AsciiImage execute(AsciiImage img) throws OperationException {
        return new MedianOperation().execute(img);
    }

    public abstract   int filter(int[] valuers);

}
