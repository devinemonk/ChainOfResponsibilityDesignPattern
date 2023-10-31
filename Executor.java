import java.util.ArrayList;
import java.util.List;

public class Executor {

    public static void main(String[] args){

        List<String> executionOrder = fetchListFromVault();

        Handler firstAlternativeHandler = createChainBasedOnExecutionOrder(executionOrder);

        String response = firstAlternativeHandler.handleRequest("request");

        if (response != null) {
            System.out.println("Response: " + response);
        } else {
            System.out.println("All alternatives failed to handle the request.");
        }
    }



    public static List<String> fetchListFromVault(){
        List<String> executionOrder = new ArrayList<>();
//        executionOrder.add("Rpacpc");
        executionOrder.add("Signzy");
        executionOrder.add("Rpacpc");
        executionOrder.add("Dummy");
        return executionOrder;
    }

    private static Handler createChainBasedOnExecutionOrder(List<String> executionOrder) {
        Handler firstAlternativeHandler = null;
        Handler previousHandler = null;
        for (String alternative : executionOrder) {
            Handler currentHandler = createHandlerByName(alternative);
            if (firstAlternativeHandler == null) {
                firstAlternativeHandler = currentHandler;
            }
            if (previousHandler != null) {
                previousHandler.nextHandler(currentHandler);
            }
            previousHandler = currentHandler;
        }
        return firstAlternativeHandler;
    }

    private static Handler createHandlerByName(String alternative) {
        if ("Rpacpc".equals(alternative)) {
            return new RpacpcHandler();
        } else if ("Signzy".equals(alternative)) {
            return new SignzyHandler();
        } else if ("Dummy".equals(alternative)) {
            return new DummyHandler();
        }
        return null;
    }
}
