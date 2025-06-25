package com.exception.application.enums;

public enum EnumMapper {
    GET_USER("/polaki/ganehs"),
    POST_USERS("/polaki/KUmar"),
    OTHER_USER("/polaki/tester");


    private final String path;


    public String getPath() {
        return path;
    }
    EnumMapper(String path) {
        this.path=path;
    }

    //ToFind Enum Type By path
    public static EnumMapper getByPath(String path){
        for(EnumMapper emType:values()){
                if(emType.path.equalsIgnoreCase(path)){
                    return emType;
                }
        }
        throw new IllegalArgumentException("definitely messed up !!");
    }
}
