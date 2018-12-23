package com.sayhellostream.sayhellostream.domain;

import org.joda.time.DateTimeConstants;

public enum LessonDay {
    MONDAY(DateTimeConstants.MONDAY ),
    TUESDAY(DateTimeConstants.TUESDAY ),
    WEDNESDAY(DateTimeConstants.WEDNESDAY ),
    THURSDAY(DateTimeConstants.THURSDAY ),
    FRIDAY(DateTimeConstants.FRIDAY ),
    SATURDAY(DateTimeConstants.SATURDAY ),
    SUNDAY(DateTimeConstants.SUNDAY );

    private int dayNumber;

    LessonDay( int dayNumber ) {

        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {

        return dayNumber;
    }
}
