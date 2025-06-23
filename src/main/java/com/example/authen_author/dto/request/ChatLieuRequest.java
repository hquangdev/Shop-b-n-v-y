package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatLieuRequest {
    private Integer idChatLieu;
    private String maChatLieu;
    private String tenChatLieu;
    private String moTa;

}
