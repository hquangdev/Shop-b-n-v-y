package com.example.authen_author.service.Impl;

import com.example.authen_author.dto.request.ChatLieuRequest;
import com.example.authen_author.dto.respone.ChatLieuRespone;
import com.example.authen_author.entity.ChatLieu;
import com.example.authen_author.repository.ChatLieuRepository;
import com.example.authen_author.service.ChatLieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatLieuServiceImpl implements ChatLieuService {
    private final ChatLieuRepository chatLieuRepository;
    @Override
    public List<ChatLieuRespone> getAll() {
        return chatLieuRepository.findAll().stream().map(ChatLieuRespone::new).toList();
    }
    protected ChatLieuRespone save(ChatLieu chatLieu) {
        ChatLieu chatLieuSaved = chatLieuRepository.save(chatLieu);
        return new ChatLieuRespone(chatLieuSaved);
    }

    @Override
    public ChatLieuRespone create(ChatLieuRequest chatLieuRequest) {
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setMaChatLieu(chatLieuRequest.getMaChatLieu());
        chatLieu.setTenChatLieu(chatLieuRequest.getTenChatLieu());
        chatLieu.setMoTa(chatLieuRequest.getMoTa());
        return save(chatLieu);
    }

    @Override
    public ChatLieuRespone update(ChatLieuRequest chatLieuRequest, Integer id) {
        ChatLieu chatLieu = chatLieuRepository.findById(id).orElseThrow(() -> new RuntimeException("Chat lieu not found"));
        chatLieu.setMaChatLieu(chatLieuRequest.getMaChatLieu());
        chatLieu.setTenChatLieu(chatLieuRequest.getTenChatLieu());
        chatLieu.setMoTa(chatLieuRequest.getMoTa());
        return save(chatLieu);
    }

    @Override
    public void delete(Integer id) {

        chatLieuRepository.deleteById(id);
    }

    //detail
    @Override
    public ChatLieu findByChatLieuId(Integer id) {
        return chatLieuRepository.findById(id).orElseThrow(()-> new RuntimeException("Chat lieu not found"));
    }
}
