package com.example.project;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;


@Dao
public interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Question> questions);

    @Query("SELECT * FROM questions WHERE language = :language")
    List<Question> getQuestionsByLanguage(String language);

    @Query("SELECT * FROM questions WHERE id = :id LIMIT 1")
    Question getQuestionById(String id);

    @Query("SELECT hint FROM questions WHERE id = :id LIMIT 1")
    String getHintByQuestionId(String id);

    @Query("SELECT answer FROM questions WHERE id = :id LIMIT 1")
    String getAnswerByQuestionId(String id);

    @Query("SELECT * FROM questions")
    List<Question> getAllQuestions();
}