package ru.jru.quest.karaganov.entitie;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Step  {
    private String currentQuestion;
    private Integer stepId;
    private Boolean hasNextStep;
    private Boolean isWin;
    private List<Action> answersForCurrentQuestion;
}