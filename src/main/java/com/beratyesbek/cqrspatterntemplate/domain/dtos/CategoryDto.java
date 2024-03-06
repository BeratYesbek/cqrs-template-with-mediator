package com.beratyesbek.cqrspatterntemplate.domain.dtos;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record CategoryDto(String name) implements Serializable {
}
