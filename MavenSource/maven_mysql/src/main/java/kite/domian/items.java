package kite.domian;

public class items  {

    private Integer id;
    private String bookname;

    public items() {
    }

    public items(Integer id, String bookname) {
        this.id = id;
        this.bookname = bookname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "items{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                '}';
    }
}
