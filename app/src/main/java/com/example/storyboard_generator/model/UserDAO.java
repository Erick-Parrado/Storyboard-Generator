package com.example.storyboard_generator.model;

import android.view.View;
import android.widget.Toast;

import com.example.storyboard_generator.api.ServiceLogin;
import com.example.storyboard_generator.api.ServiceUsers;
import com.example.storyboard_generator.entities.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;

public class UserDAO extends DAO {

    public UserDAO(){
        super();
    }

    public void login(String email, String password,ResponseTaker responseTaker) throws Exception{
        String pass = md5(password);
        LogerApi loger = new LogerApi();
        loger.setUser_email(email);
        loger.setUser_pass(pass);
        ServiceLogin service = retrofit.create(ServiceLogin.class);
        Call<ResponseObj> call = service.accessLogin(loger);
        calling(call,responseTaker);
    }


    public void register(User user,ResponseTaker responseTaker) throws  Exception{
        UserApi userBody = new UserApi();
        String[] completeName = user.getName().split(" ");
        String name = completeName[0];
        String lastName = completeName[1];
        userBody.setUser_name(name);
        userBody.setUser_lastName(lastName);
        userBody.setUser_email(user.getEmail());
        userBody.setUser_pass(md5(user.getPassword()));
        userBody.setUser_phone(user.getPhone());
        ServiceUsers service = retrofit.create(ServiceUsers.class);
        Call<ResponseObj> call = service.postUser(userBody);
        calling(call,responseTaker);
    }

    private static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2) h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
