public interface Handler {

    String handleRequest(String request);

    void nextHandler(Handler handler);

}
