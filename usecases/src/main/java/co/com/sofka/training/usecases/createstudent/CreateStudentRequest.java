package co.com.sofka.training.usecases.createstudent;

import co.com.sofka.business.generic.UseCase;

public  class CreateStudentRequest implements UseCase.RequestValues {
    private String teamId;
    private String  name;
    private String  gender;
    private int  dateOfBirthDay;
    private int  dateOfBirthMonth;
    private int  dateOfBirthYear;

    public String getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    public int getDateOfBirthMonth() {
        return dateOfBirthMonth;
    }

    public int getDateOfBirthYear() {
        return dateOfBirthYear;
    }

    public static final class CreateStudentRequestBuilder {
        private String teamId;
        private String  name;
        private String  gender;
        private int  dateOfBirthDay;
        private int  dateOfBirthMonth;
        private int  dateOfBirthYear;

        private CreateStudentRequestBuilder() {
        }

        public static CreateStudentRequestBuilder aCreateStudentRequest() {
            return new CreateStudentRequestBuilder();
        }

        public CreateStudentRequestBuilder withTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public CreateStudentRequestBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CreateStudentRequestBuilder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public CreateStudentRequestBuilder withDateOfBirthDay(int dateOfBirthDay) {
            this.dateOfBirthDay = dateOfBirthDay;
            return this;
        }

        public CreateStudentRequestBuilder withDateOfBirthMonth(int dateOfBirthMonth) {
            this.dateOfBirthMonth = dateOfBirthMonth;
            return this;
        }

        public CreateStudentRequestBuilder withDateOfBirthYear(int dateOfBirthYear) {
            this.dateOfBirthYear = dateOfBirthYear;
            return this;
        }

        public CreateStudentRequest build() {
            CreateStudentRequest createStudentRequest = new CreateStudentRequest();
            createStudentRequest.dateOfBirthDay = this.dateOfBirthDay;
            createStudentRequest.dateOfBirthMonth = this.dateOfBirthMonth;
            createStudentRequest.dateOfBirthYear = this.dateOfBirthYear;
            createStudentRequest.name = this.name;
            createStudentRequest.gender = this.gender;
            createStudentRequest.teamId = this.teamId;
            return createStudentRequest;
        }
    }
}
