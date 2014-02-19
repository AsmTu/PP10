import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


class AsciiShop {
    public static void main(String[] args) throws OperationException, FactoryException {
        Scanner scan = new Scanner(System.in);
        AsciiStack stack = new AsciiStack();

        MetricSet<AsciiImage> saved = new MetricSet<AsciiImage>();


        Map<String,Factory> pipeline = new HashMap<String, Factory>(){{
            put("load", new LoadFactory());
            put("replace",new ReplaceFactory());
            put("filter",new FilterFactory());
            put("clear", new ClearFactory());
            put("load", new LoadFactory());
            put("binary", new BinaryFactory());
            put("create",new CreateFactory());
        }
        };

        pipeline.put("save", new SaveFactory(saved));
        pipeline.put("search", new SearchFactory(saved));


     if(scan.next().equals("create")){
            stack.push(AsciiImage.createNewInstance(scan.nextInt(), scan.nextInt(), scan.nextLine()));
        while(scan.hasNext()){
            String input=scan.next();
            if(pipeline.containsKey(input)){
               Factory toDo = pipeline.get(input);
               stack.push(toDo.create(scan).execute(stack.peek()));
            }else{
                if(input.equals("print")){
                    stack.peek().print();
                }else if(input.equals("undo")){
                    stack.pop();
                }else if(input.equals("printsaved")){
                    if(saved.isEmpty()){
                        System.out.println("NO SAVED IMAGES");
                    }else{
                        Iterator<AsciiImage> iterator = saved.iterator();
                        while(iterator.hasNext()) {
                            iterator.next().print();
                        }

                    }
                }
                else{
                throw new OperationException("UNKNOWN COMMAND");
                }
            }

        }
     }else{
         throw new OperationException("INPUT MISMATCHgg");
     }
    }
}

