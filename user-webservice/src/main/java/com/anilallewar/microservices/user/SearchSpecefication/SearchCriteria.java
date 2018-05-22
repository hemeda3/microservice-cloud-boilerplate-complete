package com.anilallewar.microservices.user.SearchSpecefication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SearchCriteria {

    private final String key;
    private  final String operation;
    private  final Object value;

}