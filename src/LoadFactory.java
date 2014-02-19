

import java.util.Scanner;

/**
 * Created by taras on 20.01.14.
 */
public class LoadFactory implements  Factory {
    public LoadFactory(){
    }
    @Override
    public Operation create(Scanner scanner) throws FactoryException {
            String input="";
            String flag=scanner.next();
        while(scanner.hasNext()){
           String next=scanner.next();
            if(next.equals(flag)) break;
            input+=next;
        }
        return new LoadOperation(input);
    }
}
