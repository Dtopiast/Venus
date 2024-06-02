package com.dtopiast.venus.model;

import com.dtopiast.venus.model.base.MyModel;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a topic in the forum.
 */
@Table(name = "topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic extends MyModel {

    /**
     * The title of the topic.
     */
    private String title;

    /**
     * The message content of the topic.
     */
    private String message;

    /**
     * The status of the topic.
     */
    private TopicStatus status;

    /**
     * The creation date of the topic.
     */
    private LocalDate creationDate;

    /**
     * The author of the topic.
     */
    @ManyToOne
    private User author;

    /**
     * The responses associated with the topic.
     */
    @OneToMany
    private List<Response> responses;
}

