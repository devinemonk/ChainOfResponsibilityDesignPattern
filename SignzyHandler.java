public class SignzyHandler implements Handler{
    Handler nextHandler;

    @Override
    public String handleRequest(String request){
        System.out.println("------ SIGNZY HANDLER ------");
        if(fetchResponse()){
           return  this.nextHandler.handleRequest(request);
        }
        return "Request sent successfully to Signzy";
    }

    @Override
    public void nextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public boolean fetchResponse(){
        return true;
    }

}
