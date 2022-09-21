package hello.tech.jobseeker.Modals;

import android.hardware.biometrics.BiometricManager;

public class JobModal {

    private  String company;
    private  String location;
    private String salary;
    private String type;
    private String workType;

    public JobModal()
    {

    }


    public JobModal(String company, String location, String salary, String type, String workType) {
        this.company = company;
        this.location = location;
        this.salary = salary;
        this.type = type;
        this.workType = workType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
}
