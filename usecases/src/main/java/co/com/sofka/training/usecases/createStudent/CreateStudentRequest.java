package co.com.sofka.training.usecases.createStudent;

import co.com.sofka.business.generic.UseCase;

public  class CreateStudentRequest implements UseCase.RequestValues {
    private String teamId;
    private String  name;
    private String  gender;
    private int  dateOfBirthDay;
    private int  dateOfBirthMonth;
    private int  dateOfBirthYear;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    public void setDateOfBirthDay(int dateOfBirthDay) {
        this.dateOfBirthDay = dateOfBirthDay;
    }

    public int getDateOfBirthMonth() {
        return dateOfBirthMonth;
    }

    public void setDateOfBirthMonth(int dateOfBirthMonth) {
        this.dateOfBirthMonth = dateOfBirthMonth;
    }

    public int getDateOfBirthYear() {
        return dateOfBirthYear;
    }

    public void setDateOfBirthYear(int dateOfBirthYear) {
        this.dateOfBirthYear = dateOfBirthYear;
    }


    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }


    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
