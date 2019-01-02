package com.sayhellostream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendafoxApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void testSendMessage() throws InterruptedException {

		Group listOfStudents = new Group();

		listOfStudents.addRecipent(new Recipient("Dan", "", "+18327072323"));
		listOfStudents.addRecipent(new Recipient("Sara","", "+18329203060"));

		for (Recipient recipient : listOfStudents.recipients) {
			TwillioClient.send(recipient.phone, "+19252332108", "Hi " + recipient.firstName);

			// Saving to DB
		}

	}
}
