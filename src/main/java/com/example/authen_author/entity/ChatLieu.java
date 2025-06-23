package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChatLieu")
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_chat_lieu")
    private Integer idChatLieu;
    @Column(name = "ma_chat_lieu")
    private String maChatLieu;
    @Column(name = "ten_chat_lieu")
    private String tenChatLieu;
    @Column(name = "mo_ta")
    private String moTa;

    
}
