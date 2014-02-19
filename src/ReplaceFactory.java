import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by taras on 20.01.14.
 */
public class ReplaceFactory  implements  Factory{

    public ReplaceFactory() {

    }

    private List getTempArguments(String str) {

        int index = str.indexOf(" ");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.substring(index + 1).split(" ")));
        return list;
    }


    public Operation create(Scanner scanner) throws FactoryException {
        List listWArg = getTempArguments(scanner.nextLine());
        if(listWArg.size()<2){
            throw new FactoryException("INPUT MISMATCH");
        }
        return new ReplaceOperation(listWArg.get(0).toString().charAt(0),
                                    listWArg.get(1).toString().charAt(0));
    }
}

