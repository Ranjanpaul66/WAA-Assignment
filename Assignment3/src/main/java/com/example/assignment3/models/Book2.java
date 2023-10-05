package com.example.assignment3.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book2 {
    private int isvn;
    private String title;
    private String author;
    private String edition;
}
