package com.cognizant.junitmockitopractice;
public class MyService {
    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataById(Long id) {
        return externalApi.getDataById(id);
    }

    public void sendData(String data) {
        externalApi.sendData(data);
    }
}