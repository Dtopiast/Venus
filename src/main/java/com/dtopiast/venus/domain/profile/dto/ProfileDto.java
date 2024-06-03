package com.dtopiast.venus.domain.profile.dto;

import java.util.List;

public record ProfileDto(String name, List<Long> users) {
}
