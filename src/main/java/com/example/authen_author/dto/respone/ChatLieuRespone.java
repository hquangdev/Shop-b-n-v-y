package com.example.authen_author.dto.respone;

import com.example.authen_author.dto.request.ChatLieuRequest;
import com.example.authen_author.entity.ChatLieu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatLieuRespone {
    private Integer idChatLieu;
    private String maChatLieu;
    private String tenChatLieu;
    private String moTa;

    public ChatLieuRespone(ChatLieu chatLieu) {
        this.idChatLieu = chatLieu.getIdChatLieu();
        this.maChatLieu = chatLieu.getMaChatLieu();
        this.tenChatLieu = chatLieu.getTenChatLieu();
        this.moTa = chatLieu.getMoTa();

    }

}
