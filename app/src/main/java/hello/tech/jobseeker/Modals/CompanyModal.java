package hello.tech.jobseeker.Modals;

public class CompanyModal {
    private String CompanyName;
    private int image;
    private String openingType;
    private String companyType;

    public CompanyModal(String companyName, int image, String openingType, String companyType) {
        CompanyName = companyName;
        this.image = image;
        this.openingType = openingType;
        this.companyType = companyType;
    }

    public CompanyModal() {
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getOpeningType() {
        return openingType;
    }

    public void setOpeningType(String openingType) {
        this.openingType = openingType;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
}

