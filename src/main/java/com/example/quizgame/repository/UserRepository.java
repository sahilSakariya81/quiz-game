package com.example.quizgame.repository;

import com.example.quizgame.model.QuestionModel;
import com.example.quizgame.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserModel,String> {

    @Query(value = "SElECT username from user where username = ?1",nativeQuery = true)
    String checkUser(String name);

    @Query(value = "select username from user_questions_record where username = ?1 AND q_id = ?2 ",nativeQuery = true)
    String checkQuestion(String name,int q);

    @Query(value = """
    SELECT *
    FROM questions
    WHERE question_id NOT IN (
    SELECT q_id 
    FROM user_questions_record 
    WHERE username = ?1
    )
    ORDER BY RAND()
    LIMIT 1
    """, nativeQuery = true)
    QuestionModel getRandomQuestion(String username);

    @Query(value = "SELECT count(username) from user_questions_record WHERE username = ?1",nativeQuery = true)
    int countAttemptedQuestion(String name);

    @Query(value = "SELECT correct_answer FROM user where username = ?1",nativeQuery = true )
    String getUserScore(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET question_attended = ?2 where username = ?1",nativeQuery = true)
    void updateAttemptedQuestion(String username,int qes);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET correct_answer = correct_answer+1 where username = ?1",nativeQuery = true)
    void updateScoreQuestion(String username);

    @Query(value = "SELECT is_submit from user_questions_record where username = ?1 AND q_id = ?2",nativeQuery = true)
    boolean isSubmited(String name,int qid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user_questions_record SET is_submit = true where username = ?1 AND q_id = ?2",nativeQuery = true)
    int updateSubmit(String name,int qid);
}
