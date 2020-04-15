package com.evol;

public enum SortEnum {
    //升序
    ASC(0, "升序"),
    //降序
    DESC(1, "降序");

    private int code;
    private String name;

    SortEnum(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }
}
