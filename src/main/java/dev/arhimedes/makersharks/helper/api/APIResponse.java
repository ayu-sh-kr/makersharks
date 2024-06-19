package dev.arhimedes.makersharks.helper.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {
    private String message;
    private Object data;
    @JsonProperty("time_stamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;


    public static APIResponse withMessage(String message){
        return APIResponse.builder()
                .message(message)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public static APIResponse withBody(String message, Object data){
        return APIResponse.builder()
                .message(message)
                .data(data)
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
