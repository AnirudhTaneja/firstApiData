package com.Quickstart.ApiData;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TopicRepository extends CrudRepository <Topic, String> {

}
