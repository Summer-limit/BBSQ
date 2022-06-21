package com.nwnujsj.classtable.domain;

import java.io.Serializable;

public class InfoBean
  implements Serializable {
  private String studentcareer;
  private String studentclass;
  private String studentid;
  private String studentname;

  public String getStudentcareer() {
    return studentcareer;
  }

  public void setStudentcareer(String studentcareer) {
    this.studentcareer = studentcareer;
  }

  public String getStudentclass() {
    return studentclass;
  }

  public void setStudentclass(String studentclass) {
    this.studentclass = studentclass;
  }

  public String getStudentid() {
    return studentid;
  }

  public void setStudentid(String studentid) {
    this.studentid = studentid;
  }

  public String getStudentname() {
    return studentname;
  }

  public void setStudentname(String studentname) {
    this.studentname = studentname;
  }
}

