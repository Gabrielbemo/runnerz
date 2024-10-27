package com.gabriel.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> finById(Integer id){
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update (Run run, Integer id){
        Optional<Run> existingRun = finById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1,
                "Segunda",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                3,
                Location.INDOOR));

        runs.add(new Run(2,
                "Quarta",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(60),
                6,
                Location.INDOOR));
    }
}
