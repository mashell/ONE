package com.mashell.one.common;

import com.mashell.one.base.BaseResult;
import com.mashell.one.module.home.bean.OneDetail;
import com.mashell.one.module.home.bean.OneMonth;
import com.mashell.one.module.main.bean.Comment;
import com.mashell.one.module.movie.bean.MovieDetail;
import com.mashell.one.module.movie.bean.MovieItem;
import com.mashell.one.module.movie.bean.MovieStory;
import com.mashell.one.module.music.bean.MusicDetail;
import com.mashell.one.module.music.bean.MusicMonth;
import com.mashell.one.module.read.bean.EssayDetail;
import com.mashell.one.module.read.bean.EssayItem;
import com.mashell.one.module.read.bean.QuestionDetail;
import com.mashell.one.module.read.bean.QuestionItem;
import com.mashell.one.module.read.bean.ReadArticleList;
import com.mashell.one.module.read.bean.ReadBanner;
import com.mashell.one.module.read.bean.ReadBannerDetail;
import com.mashell.one.module.read.bean.SerialDetail;
import com.mashell.one.module.read.bean.SerialItem;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by mashell on 16/11/17.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public interface ApiInterface {

    String HOST = "http://v3.wufazhuce.com:8000";

    /**
     * 首页图文接口
     */

    //首页图文ID列表
    @GET("api/hp/idlist/0")
    Observable<BaseResult<List<String>>> getOneIdList();

    //根据ID获取图片详细列表
    @GET("api/hp/detail/{date}")
    Observable<BaseResult<OneDetail>> getOneDetail(@Path("date")String date);

    //根据年份获取图文详细列表
    @GET("api/hp/bymonth/{month}")
    Observable<BaseResult<List<OneMonth>>> getOneByMonth(@Path("month")String month);

    /**
     * 阅读模块接口
     */

    //阅读模块顶部banner
    @GET("api/reading/carousel")
    Observable<BaseResult<List<ReadBanner>>> getReadBanner();

    //阅读模块banner的item详情
    @GET("api/reading/carousel/{id}")
    Observable<BaseResult<List<ReadBannerDetail>>> getReadBannerDetail(@Path("id")String id);

    //阅读模块获取最新文章列表
    @GET("api/reading/index")
    Observable<BaseResult<ReadArticleList>> getReadArticleList();

    //根据年份获取短文列表
    @GET("api/essay/bymonth/{month}")
    Observable<BaseResult<List<EssayItem>>> getEssayItemList(@Path("month")String month);

    //根据ID获取短文详细信息
    @GET("api/essay/{id}")
    Observable<BaseResult<EssayDetail>> getEssayDetail(@Path("id")String id);

    //根据年份获取连载文章列表
    @GET("api/serialcontent/bymonth/{month}")
    Observable<BaseResult<List<SerialItem>>> getSerialItemList(@Path("month")String month);

    //根据ID获取连载文章详细信息
    @GET("api/serialcontent/{id}")
    Observable<BaseResult<SerialDetail>> getSerialDetail(@Path("id")String id);

    //根据年份获取问答文章列表
    @GET("api/question/bymonth/{month}")
    Observable<BaseResult<List<QuestionItem>>> getQuestItemList(@Path("month")String month);

    //根据ID获取问答文章详细信息
    @GET("api/question/{id}")
    Observable<BaseResult<QuestionDetail>> getQuestDetail(@Path("id")String id);

    /**
     * 音乐模块接口
     */

    //获取音乐id列表
    @GET("api/music/idlist/0")
    Observable<BaseResult<List<String>>> getMusicIdList();

    //根据ID获取音乐详情
    @GET("api/music/detail/{id}")
    Observable<BaseResult<MusicDetail>> getMusicDetail(@Path("id")String id);

    //根据月份获取音乐列表
    @GET("api/music/bymonth/{month}")
    Observable<BaseResult<List<MusicMonth>>> getMusicItemList(@Path("month")String month);

    /**
     * 电影模块接口
     */

    //获取电影简略列表
    @GET("api/movie/list/{id}")
    Observable<BaseResult<MovieItem>> getMovieItemList(@Path("id")String id);

    //获取电影故事信息
    @GET("api/movie/{id}/story/1/0")
    Observable<BaseResult<MovieStory>> getMovieStory(@Path("id")String id);

    //获取电影详细信息
    @GET("api/movie/detail/{id}")
    Observable<BaseResult<MovieDetail>> getMovieDetail(@Path("id")String id);

    /**
     * 根据类型请求评论接口
     */
    @GET("api/comment/praiseandtime/{type}/{id}/{index}")
    Observable<BaseResult<Comment>> getComment(@Path("type")String type, @Path("id")String id, @Path("index")String index);
}
