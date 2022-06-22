package com.example.academicsearch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    Long userId;
    String accessToken;
}
