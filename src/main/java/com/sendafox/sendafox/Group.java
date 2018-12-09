package com.sayhellostream.sayhellostream;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Recipient> recipients = new ArrayList<>();

    public void addRecipent(Recipient e) {
        recipients.add(e);
    }

}
