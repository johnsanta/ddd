package co.com.sofka.example.routine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Map;
import java.util.Objects;

public class Exercise implements ValueObject<Map<String, Object>> {

    private final String goal;
    private final Short level;

    public Exercise(String goal, Short level) {
        this.goal = Objects.requireNonNull(goal);
        this.level = Objects.requireNonNull(level);
        if(this.level < 0){
            throw new IllegalArgumentException("the level cannot allow");
        }
    }

    @Override
    public Map<String, Object> value() {
        return Map.of(
             "goal", goal,
             "level", level
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(goal, exercise.goal) &&
                Objects.equals(level, exercise.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goal, level);
    }
}
