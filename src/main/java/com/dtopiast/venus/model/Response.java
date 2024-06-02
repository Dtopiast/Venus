package com.dtopiast.venus.model;

import com.dtopiast.venus.model.base.MyModel;
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
}
