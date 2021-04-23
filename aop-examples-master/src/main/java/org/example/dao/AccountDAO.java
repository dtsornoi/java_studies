package org.example.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private int accName;
    public void addAccount(){
        System.out.println(getClass() + " : is adding an account to DB");
    }

    public int getAccName() {
        return accName;
    }

    public void setAccName(int accName) {
        this.accName = accName;
    }
}
