package com.sayhellostream.sayhellostream.repo;

import com.sayhellostream.sayhellostream.domain.TextMessage;

import org.joda.time.DateTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TextMessageRepo extends CrudRepository<TextMessage, Long> {

    List<TextMessage> findBySendDateLessThanEqual( DateTime sendDate );
}
