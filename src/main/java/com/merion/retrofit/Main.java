package com.merion.retrofit;

import com.merion.retrofit.request.PostCreateRequest;
import com.merion.retrofit.request.PostUpdateRequest;
import com.merion.retrofit.response.PostResponse;
import retrofit2.Response;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");

        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().api();

        System.out.println("GET/posts ----------");

        Response<List<PostResponse>> postResponse = api.posts(null).execute();

        System.out.println(postResponse.isSuccessful());
        System.out.println(postResponse.code());
        System.out.println(postResponse.headers());

        List<PostResponse> posts = postResponse.body();

        System.out.println(posts);

        System.out.println(" POST/posts ----------");
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("create");
        createRequest.setTitle("create");
        createRequest.setUserId(1);
        PostResponse postResponseCreate = api.create(createRequest).execute().body();
        System.out.println(postResponseCreate);

        System.out.println(" Put/posts ----------");
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("1");
        updateRequest.setTitle("Update");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        PostResponse postResponseUpdate = api.update(1, updateRequest).execute().body();
        System.out.println(postResponseUpdate);

        Integer code = api.delete(1).execute().code();
        System.out.println(code);











    }
}
