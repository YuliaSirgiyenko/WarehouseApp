package com.sirgiyenko.App_warehouse.exceptions;

import com.sirgiyenko.App_warehouse.enums.MessagesForDataFilling;

public class FilledDataException extends IllegalArgumentException {

    String exceptionMessage;

    public FilledDataException(MessagesForDataFilling exceptionMessage){
        this.exceptionMessage = exceptionMessage.getMessage();
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
