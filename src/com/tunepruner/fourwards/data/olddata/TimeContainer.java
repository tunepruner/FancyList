package com.tunepruner.fourwards.data.olddata;

import com.tunepruner.fourwards.data.general.Topic;
import com.tunepruner.fourwards.data.daylist.*;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder={"topicName"})
public class TimeContainer {
    @XmlElement(name = "topic", type = Topic.class)
    private Topic topic;/*must get from list of Topics*/
    private Day day;/*must get from list of Days*/
    public static final String TOPIC_NAME="topicName";

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic){
        this.topic = topic;
    }

    public TimeContainer(){}

    public TimeContainer(String topicName) {
        this.topic = new Topic(topicName);
    }
}
