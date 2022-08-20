package com.example.mystore.event;

import org.springframework.context.ApplicationEvent;

public class InitializationEvent extends ApplicationEvent {

    public InitializationEvent(Object source) {
        super(source);
    }

}
