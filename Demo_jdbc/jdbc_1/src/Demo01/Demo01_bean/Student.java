package Demo01.Demo01_bean;

/**
 * 创建按学生表接受数据
 *
 */
public class Student {
    /** 流水号 */
    private int flowId;
    /** 考试类型 */
    private int type;
    /** 身份证号 */
    private String IDcard;
    /** 准考证号 */
    private String examCard;
    /** 学生姓名 */
    private String name;
    /** 所在城市 */
    private String location;
    /** 成绩 */
    private int grade;


    public Student() {
    }

    public int getFlowId() {
        return flowId;
    }

    public Student(int flowId, int type, String IDcard, String examCard, String name, String location, int grade) {
        this.flowId = flowId;
        this.type = type;
        this.IDcard = IDcard;
        this.examCard = examCard;
        this.name = name;
        this.location = location;
        this.grade = grade;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getExamCard() {
        return examCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        System.out.println("--------------查询结果------------------");
        return info();
    }

    private String info(){
        return "流水号：" + flowId + "\n四/六级： "+ type +"\n身份证号：" + IDcard + "\n准考证号："+ examCard + "\n学生姓名："
                + name + "\n区域：" + location + "\n成绩：" + grade;
    }
}
