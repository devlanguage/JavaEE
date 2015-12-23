package org.cxftest.user.dao;

import org.cxftest.user.vo.UserVo;

public class UserManager {

    private static UserManager instance;

    private UserManager() {

    }

    public synchronized final static UserManager getInstance() {

        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public UserVo createUser() {

        return new UserVo("Test-01");
    }
}
