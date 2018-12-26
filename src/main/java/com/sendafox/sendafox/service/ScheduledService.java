package com.sayhellostream.sayhellostream.service;


public interface ScheduledService extends BaseService {

    void checkForMessagesToSend();
}