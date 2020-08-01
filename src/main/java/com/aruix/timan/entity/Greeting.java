package com.aruix.timan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;
    private  String content;
    private  String remark;

//    public Greeting(long id, String content, String remark) {
//        this.id = id;
//        this.content = content;
//        this.remark = remark;
//    }
//
//    public long getId() {
//        return this.id;
//    }
//
//    public String getContent() {
//        return this.content;
//    }
//
//    public String getRemark() {
//        return this.remark;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == this)
//            return true;
//        if (!(o instanceof Greeting)) {
//            return false;
//        }
//        Greeting greeting = (Greeting) o;
//        return id == greeting.id && Objects.equals(content, greeting.content)
//                && Objects.equals(remark, greeting.remark);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, content, remark);
//    }
//
//    @Override
//    public String toString() {
//        return "{" + " id='" + getId() + "'" + ", content='" + getContent() + "'" + ", remark='" + getRemark() + "'"
//                + "}";
//    }

}
