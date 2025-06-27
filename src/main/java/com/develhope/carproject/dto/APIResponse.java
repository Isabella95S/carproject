package com.develhope.carproject.dto;

import com.develhope.carproject.models.Car;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class APIResponse {

    private boolean success;
    private String messagge;
    private LocalDateTime currentTime = LocalDateTime.now();
    @Nullable
    private Object content;

    private List<String> errors = new ArrayList<>();
    public APIResponse(){
        this.success = true;
    }

    public APIResponse(Object content){
        this.success = true;
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public APIResponse(String message){
        this.success = false;
        this.messagge = message;
    }
    public APIResponse(Page<Car> car) {
    }

    public String getMessagge() {
        return messagge;
    }

    public void setMessagge(String messagge) {
        this.messagge = messagge;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    @Nullable
    public Object getContent() {
        return content;
    }

    public void setContent(@Nullable Object content) {
        this.content = content;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
