package com.example.abhatripathi.serverappfoodcubo.Remote;

import com.example.abhatripathi.serverappfoodcubo.model.DataMessage;
import com.example.abhatripathi.serverappfoodcubo.model.MyResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorisation:key=AAAAcomtHlQ:APA91bHEA5V7XlHkNuMg3CXemd60rlFoNOIKb--7kBsuvZKhlc5pXN9nHgYbNLE7h4bXcn8S4n47J54blm_ySGxqa4toBKPFLnqRykE4Bwi_5fxeo0aUKYUeWL-CFmvcSa_c_ne5kXa9BAygmsBbY9iAUGBSTHopGg"

            }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body DataMessage body);

}


