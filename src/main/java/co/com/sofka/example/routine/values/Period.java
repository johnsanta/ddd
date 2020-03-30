package co.com.sofka.example.routine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Period  implements ValueObject<Map<String, Date>> {

    private final Date dateStart;
    private final Date dateEnd;

    public Period(Date dateStart, Date dateEnd) {
        this.dateStart = Objects.requireNonNull(dateStart);
        this.dateEnd = Objects.requireNonNull(dateEnd);

        if(dateEnd.before(dateStart)){
            throw new IllegalArgumentException("the date end is before that start date");
        }
    }

    @Override
    public Map<String, Date> value() {
        return Map.of(
               "dateStart", dateStart,
               "dateEnd", dateEnd
        );
    }
}
