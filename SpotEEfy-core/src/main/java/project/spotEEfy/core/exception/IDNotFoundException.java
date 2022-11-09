package project.spotEEfy.core.exception;

public class IDNotFoundException extends Exception{
    public IDNotFoundException(String entity_name){
        super(entity_name + " not found");
    }
}
