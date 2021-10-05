package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //null 허용 안함
    private String title;

    @Column(name = "todoOrder", nullable = false)//order가 예약어라 다시 name지정
    private Long order;

    @Column(nullable = false)
    private Boolean completed;


}
