package com.sirgiyenko.App_warehouse.enums;

public enum MessagesForDataFilling {

    EMPTY_NAME ("First Name and Last Name should be filled"),
    SUCCESS_OWNER_ADD ("Product owner is added successfully"),
    DUPLICATE_OWNER ("Submit is impossible. \n " +
            "Product owner with such First and Last names has already existed.");

    private String message;

    MessagesForDataFilling(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
