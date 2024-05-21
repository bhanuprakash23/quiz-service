package com.bhanu.quizservice.service;


import com.bhanu.quizservice.dao.QuizDao;
import com.bhanu.quizservice.feign.QuizInterface;
import com.bhanu.quizservice.model.QuestionWrapper;
import com.bhanu.quizservice.model.Quiz;
import com.bhanu.quizservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//       Optional<Quiz> quiz =  quizDao.findById(id);
//       List<Questions> questionsFromDB = quiz.get().getQuestions();
//       System.out.println(questionsFromDB);
       List<QuestionWrapper> questionForUser = new ArrayList<>();

//       for(Questions q : questionsFromDB)
//       {
//           QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//           questionForUser.add(qw);
//       }

       return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Questions> questions = quiz.get().getQuestions();
        int right =0;
//        int i=0;
//        for(Response response: responses)
//        {
//            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
//            {
//                right++;
//            }
//            i++;
//        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
