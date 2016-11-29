package com.mashell.one.module.main.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mashell.one.C;
import com.mashell.one.R;
import com.mashell.one.base.BaseActivity;
import com.mashell.one.module.home.view.fragment.HomeFragment;
import com.mashell.one.module.main.presenter.MainPresenter;
import com.mashell.one.module.movie.view.fragment.MovieFragment;
import com.mashell.one.module.music.view.fragment.MusicFragment;
import com.mashell.one.module.read.view.fragment.ReadFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mashell on 16/11/13.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MainActivity extends BaseActivity<MainPresenter> implements View.OnClickListener{

    //记录当前选择的fragment
    private int currentFragment = C.T_HOME;
    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private ReadFragment mReadFragment;
    private MusicFragment mMusicFragment;
    private MovieFragment mMovieFragment;

    @BindView(R.id.mainTitle)
    TextView mainTitle;
    @BindView(R.id.imgHome)
    ImageView imgHome;
    @BindView(R.id.imgRead)
    ImageView imgRead;
    @BindView(R.id.imgMovie)
    ImageView imgMovie;
    @BindView(R.id.imgMusic)
    ImageView imgMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setTabStatus(C.T_HOME);
    }

    @OnClick({R.id.imgHome, R.id.imgRead, R.id.imgMusic, R.id.imgMovie})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgHome:
                setTabStatus(C.T_HOME);
                break;
            case R.id.imgRead:
                setTabStatus(C.T_READ);
                break;
            case R.id.imgMusic:
                setTabStatus(C.T_MUSIC);
                break;
            case R.id.imgMovie:
                setTabStatus(C.T_MOVIE);
                break;
            default:
                break;
        }
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    /**
     * 更改整个页面tab按钮状态以及fragment页面切换
     *
     * @param position
     */
    private void setTabStatus(int position) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        recoveryButtonStatus(currentFragment);
        switch (position) {
            case C.T_HOME:
                changeStatus(C.T_HOME);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
                transaction.replace(R.id.fragmentContainer, mHomeFragment);
                break;

            case C.T_READ:
                changeStatus(C.T_READ);
                if (mReadFragment == null) {
                    mReadFragment = new ReadFragment();
                }
                transaction.replace(R.id.fragmentContainer, mReadFragment);
                break;

            case C.T_MUSIC:
                changeStatus(C.T_MUSIC);
                if (mMusicFragment == null) {
                    mMusicFragment = new MusicFragment();
                }
                transaction.replace(R.id.fragmentContainer, mMusicFragment);
                break;

            case C.T_MOVIE:
                changeStatus(C.T_MOVIE);
                if (mMovieFragment == null) {
                    mMovieFragment = new MovieFragment();
                }
                transaction.replace(R.id.fragmentContainer, mMovieFragment);
                break;

            default:
                break;
        }

        transaction.commit();
    }

    /**
     * 还原底部tab按钮状态
     */
    private void recoveryButtonStatus(int index) {
        switch (index) {
            case C.T_HOME:
                imgHome.setImageResource(R.mipmap.home);
                break;

            case C.T_READ:
                imgRead.setImageResource(R.mipmap.read);
                break;

            case C.T_MUSIC:
                imgMusic.setImageResource(R.mipmap.music);
                break;

            case C.T_MOVIE:
                imgMovie.setImageResource(R.mipmap.movie);
                break;

            default:
                break;
        }

    }

    /**
     * 更改按下的tab按钮状态和toolbar的title
     *
     * @param index
     */
    private void changeStatus(int index) {
        switch (index) {
            case C.T_HOME:
                mainTitle.setText(getString(R.string.tab_home));
                imgHome.setImageResource(R.mipmap.home_active);
                currentFragment = C.T_HOME;
                break;

            case C.T_READ:
                mainTitle.setText(getString(R.string.tab_read));
                imgRead.setImageResource(R.mipmap.read_active);
                currentFragment = C.T_READ;
                break;

            case C.T_MUSIC:
                mainTitle.setText(getString(R.string.tab_music));
                imgMusic.setImageResource(R.mipmap.music_active);
                currentFragment = C.T_MUSIC;
                break;

            case C.T_MOVIE:
                mainTitle.setText(getString(R.string.tab_movie));
                imgMovie.setImageResource(R.mipmap.movie_active);
                currentFragment = C.T_MOVIE;
                break;

            default:
                break;
        }
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

}
