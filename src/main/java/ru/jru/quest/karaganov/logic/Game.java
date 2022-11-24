package ru.jru.quest.karaganov.logic;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;
import ru.jru.quest.karaganov.Repository;
import ru.jru.quest.karaganov.entitie.Step;
import java.io.File;
import java.util.*;


@Getter
public class Game {
    private final ArrayList<Step> steps;
    private final Repository repository;
    private final ObjectMapper mapper;

    public Game(Repository repository, ObjectMapper mapper){
        this.mapper = mapper;
        this.repository = repository;
        steps = readSteps();
    }

    @SneakyThrows
    private ArrayList<Step> readSteps() {
        String pathToJsonProp = repository.getPathToJsonProp();
        File file = new File(pathToJsonProp);
        ArrayList<Step> result;
        result =  mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Step.class));
        return result;
    }

    public Step getStepById(Integer id){
            Optional<Step> optionalStep = steps.stream().filter(step -> Objects.equals(step.getStepId(), id))
                    .findAny();
            return optionalStep.orElse(null);
    }
}