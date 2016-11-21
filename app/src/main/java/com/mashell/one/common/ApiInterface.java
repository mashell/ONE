package com.mashell.one.common;

import com.mashell.one.base.BaseResult;

import com.mashell.one.module.home.model.OneDetail;
import com.mashell.one.module.home.model.OneListByMonth;
import com.mashell.one.module.movie.model.MovieDetail;
import com.mashell.one.module.movie.model.MovieStory;
import com.mashell.one.module.movie.model.MovieItem;
import com.mashell.one.module.music.model.MusicDetail;
import com.mashell.one.module.music.model.MusicItem;
import com.mashell.one.module.read.model.EssayDetail;
import com.mashell.one.module.read.model.EssayItem;
import com.mashell.one.module.read.model.QuestionDetail;
import com.mashell.one.module.read.model.QuestionItem;
import com.mashell.one.module.read.model.ReadArticleList;
import com.mashell.one.module.read.model.ReadBanner;
import com.mashell.one.module.read.model.ReadBannerDetail;
import com.mashell.one.module.read.model.SerialDetail;
import com.mashell.one.module.read.model.SerialItem;

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

    String HOST = "http://v3.wufazhuce.com:8000/api";

    /**
     * 首页图文接口
     */

    //首页图文ID列表
    @GET("hp/idlist/{date}")
    Observable<BaseResult<List<String>>> getOneIdList(@Path("date") String date);

    //根据ID获取图片详细列表
    @GET("hp/detail/{date}")
    Observable<BaseResult<OneDetail>> getOneDetail(@Path("date")String date);

    //根据年份获取图文详细列表
    @GET("hp/bymonth/{month}")
    Observable<BaseResult<OneListByMonth>> getOneByMonth(@Path("month")String month);

    /**
     * 阅读模块接口
     */

    //阅读模块顶部banner
    @GET("reading/carousel")
    Observable<BaseResult<ReadBanner>> getReadBanner();

    //阅读模块banner的item详情
    @GET("reading/carousel/{id}")
    Observable<BaseResult<List<ReadBannerDetail>>> getReadBannerDetail();

    //阅读模块获取最新文章列表
    @GET("reading/index")
    Observable<BaseResult<ReadArticleList>> getReadArticleList();

    //根据年份获取短文列表
    @GET("essay/bymonth/{month}")
    Observable<BaseResult<List<EssayItem>>> getEssayItemList(@Path("month")String month);

    //根据ID获取短文详细信息
    @GET("essay/{id}")
    Observable<BaseResult<EssayDetail>> getEssayDetail(@Path("id")String id);

    //根据年份获取连载文章列表
    @GET("serialcontent/bymonth/{month}")
    Observable<BaseResult<List<SerialItem>>> getSerialItemList(@Path("month")String month);

    //根据ID获取连载文章详细信息
    @GET("serialcontent/{id}")
    Observable<BaseResult<SerialDetail>> getSerialDetail(@Path("id")String id);

    //根据年份获取问答文章列表
    @GET("question/bymonth/{month}")
    Observable<BaseResult<List<QuestionItem>>> getQuestItemList(@Path("month")String month);

    //根据ID获取问答文章详细信息
    @GET("question/{id}")
    Observable<BaseResult<QuestionDetail>> getQuestDetail(@Path("id")String id);

    /**
     * 音乐模块接口
     */

    //获取音乐id列表
    @GET("music/idlist/0")
    Observable<BaseResult<List<String>>> getMusicIdList();

    //根据ID获取音乐详情
    @GET("music/detail/{id}")
    Observable<BaseResult<MusicDetail>> getMusicDetail(@Path("id")String id);

    //根据月份获取音乐列表
    @GET("music/bymonth/{month}")
    Observable<BaseResult<List<MusicItem>>> getMusicItemList(@Path("month")String month);

    /**
     * 电影模块接口
     */

    //获取电影简略列表
    @GET("movie/list/{id}")
    Observable<BaseResult<MovieItem>> getMovieItemList(@Path("id")String id);

    //获取电影故事信息
    @GET("movie/{id}/story/1/0")
    Observable<BaseResult<MovieStory>> getMovieStory(@Path("id")String id);

    //获取电影详细信息
    @GET("movie/detail/{id}")
    Observable<BaseResult<MovieDetail>> getMovieDetail(@Path("id")String id);

    /**
     * 根据类型请求评论接口
     */
}
