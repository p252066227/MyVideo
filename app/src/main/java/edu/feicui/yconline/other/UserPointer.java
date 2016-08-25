package edu.feicui.yconline.other;


import edu.feicui.yconline.bombapi.BombConst;

public class UserPointer extends Pointer {
    private String username;

    public UserPointer(String objectId) {
        super(BombConst.TABLE_USER, objectId);
    }
//
//    "createdAt": "2016-07-11 12:20:07",
//    "updatedAt": "2016-07-11 12:20:09",
//    "username": "飞翔的猪头"

    public String getUsername() {
        return username;
    }
}
