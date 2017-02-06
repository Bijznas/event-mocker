package com.event.mocker.enums;

/**
 * Created by sanjib on 2/5/17.
 */
public enum ProcessType {
    SYSTEM("System"), USER("User");

    private String value;

    ProcessType(String value) { this.value = value; }

    public String getValue() { return value; }
}
