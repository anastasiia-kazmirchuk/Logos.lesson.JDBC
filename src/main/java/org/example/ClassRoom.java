package org.example;

public class ClassRoom {
    private  Long id;
    private  Long studentNumber;
    private Long rppmNumber;

    public ClassRoom(Long id, Long studentNumber, Long rppmNumber) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.rppmNumber = rppmNumber;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", studentNumber=" + studentNumber +
                ", rppmNumber=" + rppmNumber +
                '}';
    }

    public ClassRoom() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setRppmNumber(Long rppmNumber) {
        this.rppmNumber = rppmNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public Long getRppmNumber() {
        return rppmNumber;
    }
}
