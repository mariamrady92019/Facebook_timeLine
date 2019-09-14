package com.example.facebook_timeline.facebook_timeline;

public class data {

  String name ;
  String discription ;
  int account_Photo ;
  int post_photo ;

    public data(String name, String discription, int account_Photo, int post_photo) {
        this.name = name;
        this.discription = discription;
        this.account_Photo = account_Photo;
        this.post_photo = post_photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getAccount_Photo() {
        return account_Photo;
    }

    public void setAccount_Photo(int account_Photo) {
        this.account_Photo = account_Photo;
    }

    public int getPost_photo() {
        return post_photo;
    }

    public void setPost_photo(int post_photo) {
        this.post_photo = post_photo;
    }
}
