import java.util.Scanner;

/**
 * Created by taras on 20.01.14.
 */
public class FilterFactory implements Factory {

    public FilterFactory(){

    }

    public Operation create(Scanner scanner) throws FactoryException {
        String tempInput=scanner.next();
        if(tempInput.equals("median")){
            return  new MedianOperation();
        }
        else if(tempInput.equals("average")){
            return new AverageOperation();
        }else{
            throw new FactoryException("UNKNOWN OPERATION");
        }
    }
}
