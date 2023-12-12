package com.example.storyboard_generator.entities;

public class User {

    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String phone;
    private String identifier;
    private String key;

    public User(){}
    public User(String name, String email, String password, String phone){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public User(int id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", identifier='").append(identifier).append('\'');
        sb.append(", key='").append(key).append('\'');
        sb.append('}');
        return sb.toString();
    }

    ////////////////////SETTER/////////////////////
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setIdentifier(String identifier) {this.identifier = identifier;}
    public void setKey(String key) {this.key = key;}
    //////////////////////GETTERS//////////////////
    public int getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getPhone() {return phone;}
    public String getIdentifier() {return identifier;}
    public String getKey() {return key;}
}

