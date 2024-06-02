package com.dtopiast.venus.model;

/**
 * Enumeration representing the status of a topic in a forum.
 */
public enum TopicStatus {
    OPEN,       // The topic is open and active
    CLOSED,     // The topic is closed but still visible
    ARCHIVED,   // The topic is archived and not visible for new comments
    DELETED     // The topic has been deleted and is not visible to users
}

