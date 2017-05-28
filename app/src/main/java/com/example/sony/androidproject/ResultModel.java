package com.example.sony.androidproject;

import com.firebase.client.Firebase;

/**
 * Created by Sony on 2017-05-28.
 */

public class ResultModel {

        private int count;
        private String mail;
        public ResultModel() {}
        public ResultModel(String mail, int count) {
            this.mail = mail;
            this.count = count;
        }
        public long getCount() {
            return count;
        }
        public String getMail() {
            return mail;
        }

}
