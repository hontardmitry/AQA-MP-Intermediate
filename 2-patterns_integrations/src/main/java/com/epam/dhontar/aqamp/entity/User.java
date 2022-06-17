package com.epam.dhontar.aqamp.entity;

public class User extends Person{
    private String userName;
    private String password;

    private User(Builder builder) {
        this.setId(builder.id);
        this.userName = builder.userName;
        this.password = builder.password;
    }

    private User() {
    }

    public Builder getBuilder(){
        return new Builder(this.getId(), this.userName, this.password);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {

        private int id;
        private String userName;
        private String password;

        public Builder(int id) {
            this.id = id;
        }

        public Builder(int id, String userName, String password) {
            this.id = id;
            this.userName = userName;
            this.password = password;
        }

        public Builder withName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
