package com.dtopiast.venus.domain.response.model;

import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.user.model.User;
import com.dtopiast.venus.domain.base.MyModel;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Represents a response to a topic in the forum.
 */
@Table(name = "response")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response extends MyModel {

    /**
     * The message content of the response.
     */
    private String message;

    /**
     * The solution content of the response.
     */
    private String solution;

    /**
     * The creation date of the response.
     */
    private LocalDate creationDate;

    /**
     * The author of the response.
     */
    @ManyToOne
    private User author;
    /**
     * The topic associated with the response.
     */
    @ManyToOne
    private Topic topic;
    private boolean isEdited;

    public Response updateMessage(String newMessage){
        this.message = newMessage;
        this.isEdited = true;
        return  this;
    }
    public Response updateSolution(String newMessage){
        this.message = newMessage;
        return  this;
    }

    public Response setAuthor(User user) {
        this.author = user;
        return this;
    }
}
