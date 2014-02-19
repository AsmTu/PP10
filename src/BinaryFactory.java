
import java.util.Scanner;
/**
 * Created by taras on 21.01.14.
 */
public class BinaryFactory implements  Factory {
    public BinaryFactory(){
    }

    public Operation create(Scanner scanner) throws FactoryException {

        if(scanner.hasNext()){
           char charToPassT=scanner.next().charAt(0);
            return new BinaryOperation(charToPassT);
        }
        return null;
    }
}
