public class DummyHandler implements Handler{
    Handler handler;

    @Override
    public String handleRequest(String request){
        System.out.println("------ DUMMY HANDLER ------");
        return "Request sent successfully to Dummy";
    }

    @Override
    public void nextHandler(Handler handler) {
        this.handler = handler;
    }


}
