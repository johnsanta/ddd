package co.com.sofka.example.routine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Map;
import java.util.Objects;

public class Challenge implements ValueObject<Map<String, String>> {

    private static final String URL_REGEX = "https?:\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+[/#?]?.*$";

    private final String description;
    private final String url;
    private final String urlSolution;

    public Challenge(String description, String urlSolution, String url){
        this.description = Objects.requireNonNull(description);
        this.urlSolution = Objects.requireNonNull(urlSolution);
        if(this.description.isBlank()){
            throw new IllegalArgumentException("the description is not allow");
        }

        if (!this.urlSolution.matches(URL_REGEX)){
            throw new IllegalArgumentException("URL of the solution cannot is allow");
        }

        if(!Objects.isNull(url) && !url.matches(URL_REGEX)){
                throw new IllegalArgumentException("URL of the solution cannot is allow");
        } else {
            this.url = "";
        }
    }

    @Override
    public Map<String, String> value() {
        return Map.of(
                "description", description,
                "url", url,
                "urlSolution", urlSolution
        );
    }
}
