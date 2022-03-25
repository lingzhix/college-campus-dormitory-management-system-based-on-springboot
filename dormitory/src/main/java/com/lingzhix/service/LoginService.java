package com.lingzhix.service;

import com.lingzhix.setingModel.Setingmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    BaiduAIFace faceapi;
    @Autowired
    Setingmodel setingmodel;
    public Map<String,Object> searchface(String imagebase64) throws IOException {
        String substring = imagebase64.substring(imagebase64.indexOf(",")+1);
        setingmodel.setImgpath(substring);
        setingmodel.setGroupID("123");
        System.out.println(substring);
        Map map = faceapi.FaceSearch(setingmodel);
        return map;

    }
}
