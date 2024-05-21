package com.bhanu.quizservice.controller;

import com.bhanu.quizservice.model.QuestionWrapper;
import com.bhanu.quizservice.model.Response;
import com.bhanu.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
    {
        //System.out.println(numQ + " " + title + " " + category);
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
            return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        return quizService.calculateResult(id,responses);
    }

}
