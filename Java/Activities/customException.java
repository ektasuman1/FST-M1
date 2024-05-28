package Activities;


public class customException extends Exception{

    private String message = null;
    public customException(String message){
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }


}
