package com.example.authen_author.service;

import com.example.authen_author.dto.request.ChatLieuRequest;
import com.example.authen_author.dto.respone.ChatLieuRespone;
import com.example.authen_author.entity.ChatLieu;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieuRespone> getAll();
    ChatLieuRespone create(ChatLieuRequest chatLieuRequest);
    ChatLieuRespone update(ChatLieuRequest chatLieuRequest, Integer id);
    void delete(Integer id);
    ChatLieu findByChatLieuId(Integer id);
}
