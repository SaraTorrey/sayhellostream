package com.sayhellostream.view;

import com.sayhellostream.converter.DateTimeFormatter;
import org.joda.time.DateTime;

public class SendTextView {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String textBody;

    private Boolean doSchedule;

    private DateTime scheduleDateTime;

    public static SendTextView newInstance() {

        SendTextView view = new SendTextView();
        view.setScheduleDateTime(DateTime.now());

        return view;
    }

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

    public DateTime getScheduleDateTime() {
        return scheduleDateTime;
    }

    public void setScheduleDateTime(DateTime scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }
}
