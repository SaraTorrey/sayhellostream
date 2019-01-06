package com.sayhellostream.view;

public class SendTextView {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String textBody;

    private Boolean doSchedule;

    private String scheduleDateTime;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public Boolean getDoSchedule() {
        return doSchedule;
    }

    public void setDoSchedule(Boolean doSchedule) {
        this.doSchedule = doSchedule;
    }

    public String getScheduleDateTime() {
        return scheduleDateTime;
    }

    public void setScheduleDateTime(String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }
}
