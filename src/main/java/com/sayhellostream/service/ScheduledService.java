package com.sayhellostream.service;


public interface ScheduledService extends BaseService {

    void checkForMessagesToSend();
}