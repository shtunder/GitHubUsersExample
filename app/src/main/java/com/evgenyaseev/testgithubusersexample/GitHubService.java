package com.evgenyaseev.testgithubusersexample;

import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;

public interface GitHubService {

  @GET("users")
  Single<List<User>> listUser();
}