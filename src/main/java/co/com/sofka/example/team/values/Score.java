package co.com.sofka.example.team.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Score implements ValueObject<Map<String, Object>> {

    private final int point;
    private final Date lastDate;

    public Score(int point){
        this.point = point;
        if(point < 0){
            throw new IllegalArgumentException("No allow the negative value");
        }
        this.lastDate = Calendar.getInstance().getTime();
    }

    @Override
    public Map<String, Object> value() {
        return Map.of("point", point, "lastDate", lastDate.getTime());
    }

}
