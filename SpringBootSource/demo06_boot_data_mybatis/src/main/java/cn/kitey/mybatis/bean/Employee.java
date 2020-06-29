package cn.kitey.mybatis.bean;

public class Employee {

    private Integer id;
    private String lastNmae;
    private Integer gender;
    private String email;
    private Integer dId;

    public Employee() {
    }

    public Employee(Integer id, String lastNmae, Integer gender, String email, Integer dId) {
        this.id = id;
        this.lastNmae = lastNmae;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastNmae() {
        return lastNmae;
    }

    public void setLastNmae(String lastNmae) {
        this.lastNmae = lastNmae;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastNmae='" + lastNmae + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                '}';
    }
}
