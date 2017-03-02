package spinc.spmmvp.rxAndroidExample.net;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import spinc.spmmvp.rxAndroidExample.model.PostModel;
import spinc.spmmvp.rxAndroidExample.model.WeatherData;

interface ApiManagerService {
    @GET("/weather")
    WeatherData getWeather(@Query("q") String place, @Query("units") String units);

    @GET("/posts")
    public Observable<List<PostModel>> getPosts();

    @GET("/posts/{id}")
    public Observable<PostModel> getPost(@Path("id") int postId);

    @GET("/comments")
    public Observable<List<Comment>> getComments(@Query("postId") int postId);

    @POST("/posts")
    public Observable<PostModel> postPost(PostModel post);
}