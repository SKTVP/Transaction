package com.example.banks.ApiResponse;

import java.time.LocalTime;

public class ApiResponse {
private boolean sucess;
private String Message;

    public ApiResponse(boolean sucess, String message) {
        this.sucess = sucess;
        Message = message;
    }

    public boolean isSucess() {
        return sucess;
    }

    public String getMessage() {
        return Message;
    }

    public String getTimestamp(){
        return LocalTime.now().toString();
    }
}
