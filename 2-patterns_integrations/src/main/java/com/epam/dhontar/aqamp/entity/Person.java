package com.epam.dhontar.aqamp.entity;

import java.lang.reflect.Field;

public abstract class Person {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String toJson() throws IllegalAccessException {
        Field[] declaredFields = this.getClass().getDeclaredFields();

        String result = "{\"id\":\"" + getId() + "\"";
        for (Field field : declaredFields){
            if(!"id".equals(field.getName())) {
                field.setAccessible(true);
                String value = field.get(this).toString();
                result += ",\"" + field.getName() + "\":\"" + value + "\"";
            }
        }

        result +=  "}";
        return result;

    }
}
