public class RpacpcHandler implements Handler  {
    Handler nextHandler;

    @Override
    public String handleRequest(String request){
        System.out.println("------ RPACPC HANDLER ------");
        if(fetchResponse()){
            return this.nextHandler.handleRequest(request);
        }
        return "Request sent successfully to RPACPC";
    }

    @Override
    public void nextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public boolean fetchResponse(){
        return true;
    }
}
