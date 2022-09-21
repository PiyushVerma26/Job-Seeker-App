package hello.tech.jobseeker.Modals;

public class HiringModal {
    private String name;
    private  int image;
    private String EmployeeName;
    private String salary;
    private String year;

    public HiringModal(String name, int image, String employeeName, String salary, String year) {
        this.name = name;
        this.image = image;
        EmployeeName = employeeName;
        this.salary = salary;
        this.year = year;
    }

    public HiringModal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
