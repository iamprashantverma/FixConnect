package com.fixconnect.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class APIResponse<T> {
    private  T data;
    private  APIError error;
    private LocalDateTime timeStamp;
    APIResponse(){
        timeStamp = LocalDateTime.now();
    }

    APIResponse(T data) {
        this();
        this.data = data;
    }

    APIResponse(APIError error) {
        this();
        this.error = error;
    }
}
