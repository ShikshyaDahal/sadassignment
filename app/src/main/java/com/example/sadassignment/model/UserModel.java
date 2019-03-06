package com.example.sadassignment.model;

public class UserModel {
    private String email, password, name, address, phone;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    private UserModel(){}

    public static class Builder{
        private String email, password, name, address, phone;

        public Builder(){}

        public Builder writeEmail(String email){
            this.email=email;
            return this;
        }

        public Builder writePassword(String password){
            this.password=password;
            return this;
        }

        public Builder writeName(String name){
            this.name=name;
            return this;
        }

        public Builder writeAddress(String address){
            this.address=address;
            return this;
        }

        public Builder writePhone(String phone){
            this.phone=phone;
            return this;
        }
        public UserModel build(){

            UserModel userModel=new UserModel();
            userModel.email=this.email;
            userModel.address=this.address;
            userModel.password=this.password;
            userModel.name=this.name;
            userModel.phone=this.phone;
            return userModel;
        }
    }
}
