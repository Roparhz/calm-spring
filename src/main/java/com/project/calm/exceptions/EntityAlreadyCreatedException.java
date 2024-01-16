package com.project.calm.exceptions;

public class EntityAlreadyCreatedException extends RuntimeException{
    private final String entityName;
    public EntityAlreadyCreatedException(String msg, String entityName){
        super();
        this.entityName = entityName;
    }

    public String getEntity() {
        return entityName;
    }
}
