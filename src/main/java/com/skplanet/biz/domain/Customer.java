package com.skplanet.biz.domain;

import javax.validation.constraints.AssertFalse;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 1002475 on 15. 4. 20..
 */

public class Customer implements java.io.Serializable {

    private int id;

    private String name;

    private String address;

    private String emailAddress;

    public Customer(String name, String address, String emailAddress) {
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
    }

    @AssertFalse(message = "{errors.ngemail}")
    public boolean isNgEmail() {
        // 도메인 이름이 ng.foo.baz이면 사용불가 주소로 본다
        return emailAddress.matches(".*@ng.foo.baz$");
    }

    public boolean isFreeEmail() {
        // 도메인 이름이 free.foo.baz이면 프리메일 주소로 본다
        return emailAddress.matches(".*@free.foo.baz$");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Customer() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer [id=%s, name=%s, address=%s, emailAddress=%s]",
                id, name, address, emailAddress);
    }

    private static final long serialVersionUID = 3428490997353904743L;
}
