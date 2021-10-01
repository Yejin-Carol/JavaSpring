package com.carol.jpa02.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Data //lombok
@AllArgsConstructor
@Entity
public class Board {

    public Board(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Size(min=2, max=30, message = "제목은 2이상 30이하여야 합니다.")
    //@Column 생략가능
    private String title;
    private String content;
    private String date;

    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="board_id")
    private List<BoardTail> boardTailList;
}
