package com.Quickstart.ApiData.topics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
   @Autowired
    private TopicRepository topicRepository;

   private List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("spring","SprintFramework","Description of SpringFramework"),
                new Topic("java","Java frame","Description of Java"),
                new Topic("C++","C plus plusFramework","Description of c++")
   ));

   public List<Topic> getAllTopics(){
       List<Topic> topics = new ArrayList<>();
       topicRepository.findAll()
              .forEach(topics::add);
        return topics;
   }

   public Topic getTopic(String id){
      return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
   }

    public void addTopic(Topic topic) {
       //topics.add(topic);
       // topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
       for (int i=0; i<=topics.size(); i++){
           Topic t = topics.get(i);
           if (t.getId().equals(id)){
               topics.set(i,topic);
               return;
           }

       }
    }

    public void deleteTopic(String id) {
       topics.removeIf(t -> t.getId().equals(id));
    }
}
