import java.util.Scanner;

/**
 * Created by taras on 13.02.14.
 */
public class CreateFactory implements Factory {

    public CreateFactory(){

    }

    public Operation create(Scanner scanner) throws FactoryException {
        return new CreateOperation(scanner.hasNextInt()?scanner.nextInt():0,
                scanner.hasNextInt()?scanner.nextInt():0,
                scanner.hasNextLine()?scanner.nextLine():"");
    }
}
