package com.cognizant.junitmockitopractice;

public interface ExternalApi {
    String getData();
    void sendData(String data);
    String getDataById(Long id);
}
