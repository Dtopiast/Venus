package com.dtopiast.venus.dto.profile;

import java.util.List;

public record ProfileDto(String name, List<Long> users) {
}
