package com.yattsun.it_study.repository;

import com.yattsun.it_study.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategoryOrderByIdAsc(String category);

    @Query("SELECT DISTINCT q.category FROM Question q")
    List<String> findCategories();
}
