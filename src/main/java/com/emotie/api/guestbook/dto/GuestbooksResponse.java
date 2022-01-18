package com.emotie.api.guestbook.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class GuestbooksResponse {
    private final List<GuestbookResponse> guestbooks;

    @JsonCreator
    public GuestbooksResponse(@JsonProperty("guestbooks") List<GuestbookResponse> guestbooks) {
        this.guestbooks = guestbooks;
    }
}