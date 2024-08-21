package dev.arhimedes.makersharks.helper.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {
    private String message;
    private T data;
    @JsonProperty("time_stamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;


    public static <T> APIResponse<T> withMessage(String message){
        return APIResponse.<T>builder()
                .message(message)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public static <T> APIResponse<T> withBody(String message, T data){
        return APIResponse.<T>builder()
                .message(message)
                .data(data)
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
