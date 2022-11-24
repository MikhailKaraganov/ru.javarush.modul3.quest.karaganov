package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.jru.quest.karaganov.Repository;
import ru.jru.quest.karaganov.entitie.Action;
import ru.jru.quest.karaganov.entitie.Step;
import ru.jru.quest.karaganov.logic.Game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class GameTest {
    static ArrayList<Step> expectedList;
    static Game game;
    @Mock
    Repository repository;


    @BeforeAll
    public static void init(){
        game = new Game(new Repository(), new ObjectMapper());
        expectedList = new ArrayList<>();
        expectedList.add(new Step("TestQuestion1",1,true,false, new ArrayList<>
                (Arrays.asList(new Action("Action1", 2),new Action("Action2", 5)))));
        expectedList.add(new Step("TestQuestion2",2,true,false, new ArrayList<>
                (Arrays.asList(new Action("Action3", 3),new Action("Action4", 6)))));
    }

    @Test
    void readStepsTest (){
        Mockito.doReturn("src/test/resources/stepInfoForTesting.json").when(repository).getPathToJsonProp();
        ObjectMapper mapper = new ObjectMapper();
        String pathToJsonProp = repository.getPathToJsonProp();
        File file = new File(pathToJsonProp);
        ArrayList<Step> result = new ArrayList<>();
        try {
            result =  mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Step.class));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        assertEquals(expectedList, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void getStepById_returnStepClassTest(int i){
        Step step = game.getStepById(i);
        assertAll("step", ()-> assertEquals(Step.class, step.getClass()),
                ()-> assertEquals((int) step.getStepId(), i));
    }
}