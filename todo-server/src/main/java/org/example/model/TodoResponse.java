package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {

    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url; //API 스펙

    //이후의 코드 작성을 편리하게 하기 위해서
    //Todo Entity를 파라미터로 받는 생성자 입력
    public TodoResponse(TodoEntity todoEntity) {
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.order = todoEntity.getOrder();
        this.completed = todoEntity.getCompleted();

        //url의 경우 TodoEntity에 없는 것이므로 임의로 작성, id로 해당 아이템 조회 api
        this.url = "http://localhost:8080/" + this.id;
        //config나 property로 지정해줌. (하드코딩은 원래 안좋음!)
    }
}
