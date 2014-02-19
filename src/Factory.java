

import java.util.Scanner;

/**
 * Created by taras on 17.01.14.
 */
interface Factory {

    public Operation create (Scanner scanner) throws FactoryException;
}
