package com.project.job.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {

    private String api_version;

    private String date;

    private String status;

    @Builder.Default
    private String message;

    private T data;
}
