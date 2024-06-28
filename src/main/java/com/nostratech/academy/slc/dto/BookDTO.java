package com.nostratech.academy.slc.dto;

import java.io.Serializable;

public record BookDTO(Long id, String title, String description) implements Serializable{

}
