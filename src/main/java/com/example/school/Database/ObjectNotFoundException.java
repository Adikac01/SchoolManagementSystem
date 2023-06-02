package com.example.school.Database;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(Integer id, String objectType){
        super("Could not find " + objectType + " of id " + id);
    }
}
