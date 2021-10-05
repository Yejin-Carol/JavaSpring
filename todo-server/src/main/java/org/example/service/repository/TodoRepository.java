package org.example.service.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository도 이미 많은 것들을 상속하고.. 더 자세히 알려면 클릭~
//JpaRepository 상속하는 인터페이스, 제네릭으로 DB와 연결될 TodoEntity와 id 타입 입력
//TdoRequest-Response는 DB 저장 굳이 필요없으므로 생략
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
