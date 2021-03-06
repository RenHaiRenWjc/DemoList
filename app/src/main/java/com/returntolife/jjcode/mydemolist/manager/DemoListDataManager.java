package com.returntolife.jjcode.mydemolist.manager;

import android.content.Intent;

import com.returntolife.jjcode.mydemolist.AppApplication;
import com.returntolife.jjcode.mydemolist.R;
import com.returntolife.jjcode.mydemolist.bean.DemoListBean;
import com.returntolife.jjcode.mydemolist.demo.function.changetheme.ChangeThemeActivity;
import com.returntolife.jjcode.mydemolist.demo.function.mycontentprovider.MyContentProvider;
import com.returntolife.jjcode.mydemolist.demo.function.resumedownload.ResumeDownloadActivity;
import com.returntolife.jjcode.mydemolist.demo.image.InvertedImageActivity;
import com.returntolife.jjcode.mydemolist.demo.image.PickingPictureActivity;
import com.returntolife.jjcode.mydemolist.demo.widget.BottomSheetActivity;
import com.returntolife.jjcode.mydemolist.demo.widget.CoordinatorlayoutActivity;
import com.returntolife.jjcode.mydemolist.demo.widget.DemoBottomSheetDialogFragment;
import com.returntolife.jjcode.mydemolist.demo.widget.FloatingActionButtonActivity;
import com.returntolife.jjcode.mydemolist.demo.widget.drawlockscreen.DrawLockScreenActivity;
import com.returntolife.jjcode.mydemolist.demo.widget.putorefresh.PutoRefreshActivity;
import com.returntolife.jjcode.mydemolist.demo.widget.recyclerview.CardLayoutActivity;
import com.returntolife.jjcode.mydemolist.demo.widget.scaleview.ScaleViewActivity;


import java.util.ArrayList;
import java.util.List;

/*
 * Create by JiaJun He on 2019/4/16$
 * Email:1021661582@qq.com
 * des:
 * version:1.0.0
 */
public class DemoListDataManager {

    private volatile  static DemoListDataManager instance;


    private List<DemoListBean> demoListBeanList;

    private DemoListDataManager(){
        initDemoListData();
    }

    public static DemoListDataManager getInstance(){
        if(instance==null){
            synchronized (DemoListDataManager.class){
                if(instance==null){
                    instance=new DemoListDataManager();
                }
            }

        }
        return instance;
    }


    public List<DemoListBean> getDemoListBeanList(){
        return demoListBeanList;
    }


    private void initDemoListData() {
        demoListBeanList=new ArrayList<>();

        //image
        demoListBeanList.add(new DemoListBean("图片倒影","图片倒影处理","2017-08-12", R.drawable.bg_md_test,DemoListBean.TYPE_IMAGE,new Intent(AppApplication.pAppContext, InvertedImageActivity.class)));
        demoListBeanList.add(new DemoListBean("图片取色","图片取色并融入背景色效果","2018-08-21", R.drawable.bg_md_test,DemoListBean.TYPE_IMAGE,new Intent(AppApplication.pAppContext, PickingPictureActivity.class)));

        //function
        demoListBeanList.add(new DemoListBean("断点续传","采用多线程和数据库实现断点续传","2017-08-20", R.drawable.bg_md_test,DemoListBean.TYPE_FUNCTION,new Intent(AppApplication.pAppContext, ResumeDownloadActivity.class)));
        demoListBeanList.add(new DemoListBean("内置主题换肤","使用内置的自定义attr实现换肤","2019-02-20", R.drawable.bg_md_test,DemoListBean.TYPE_FUNCTION,new Intent(AppApplication.pAppContext, ChangeThemeActivity.class)));
        demoListBeanList.add(new DemoListBean("ContentProvider","ContentProvider的基本使用案例","2019-02-21", R.drawable.bg_md_test,DemoListBean.TYPE_FUNCTION,new Intent(AppApplication.pAppContext, MyContentProvider.class)));

        //widget
        demoListBeanList.add(new DemoListBean("下拉刷新","自定义listview的下拉刷新","2017-08-9", R.drawable.bg_md_test,DemoListBean.TYPE_FUNCTION,new Intent(AppApplication.pAppContext, PutoRefreshActivity.class)));
        demoListBeanList.add(new DemoListBean("Bottomsheet","material desgin控件","2018-10-08", R.drawable.bg_md_test,DemoListBean.TYPE_WIDGET,new Intent(AppApplication.pAppContext, BottomSheetActivity.class)));
        demoListBeanList.add(new DemoListBean("Coordinatorlayout","material desgin控件","2018-09-30", R.drawable.bg_md_test,DemoListBean.TYPE_WIDGET,new Intent(AppApplication.pAppContext, CoordinatorlayoutActivity.class)));
        demoListBeanList.add(new DemoListBean("BottomSheetDialogFragment","material desgin控件","2018-10-08", R.drawable.bg_md_test,DemoListBean.TYPE_WIDGET,new Intent(AppApplication.pAppContext, DemoBottomSheetDialogFragment.class)));
        demoListBeanList.add(new DemoListBean("FloatingActionButton","material desgin控件","2018-10-08", R.drawable.bg_md_test,DemoListBean.TYPE_WIDGET,new Intent(AppApplication.pAppContext, FloatingActionButtonActivity.class)));
        demoListBeanList.add(new DemoListBean("仿探探卡片滑动","自定义recyclerview的layoutmanager","2019-04-08", R.drawable.bg_md_test,DemoListBean.TYPE_WIDGET,new Intent(AppApplication.pAppContext, CardLayoutActivity.class)));
        demoListBeanList.add(new DemoListBean("MyScaleView","自定义波浪刻度调频控件","2019-04-12", R.drawable.bg_md_test,DemoListBean.TYPE_WIDGET,new Intent(AppApplication.pAppContext, ScaleViewActivity.class)));
        demoListBeanList.add(new DemoListBean("绘制锁屏","自定义控件","2017-08-14", R.drawable.bg_md_test,DemoListBean.TYPE_WIDGET,new Intent(AppApplication.pAppContext, DrawLockScreenActivity.class)));
    }




    //获取widget列表
    public List<DemoListBean> getWidgetDemoList(){
        List<DemoListBean> data=null;

        if(demoListBeanList!=null&&demoListBeanList.size()>0){
            for (DemoListBean demoListBean : demoListBeanList) {
                if(demoListBean.getType()==DemoListBean.TYPE_WIDGET){
                    if(data==null){
                        data=new ArrayList<>();
                    }
                    data.add(demoListBean);
                }
            }
        }

        return data;
    }


    //获取功能列表
    public List<DemoListBean> getFunctionDemoList(){
        List<DemoListBean> data=null;

        if(demoListBeanList!=null&&demoListBeanList.size()>0){
            for (DemoListBean demoListBean : demoListBeanList) {
                if(demoListBean.getType()==DemoListBean.TYPE_FUNCTION){
                    if(data==null){
                        data=new ArrayList<>();
                    }
                    data.add(demoListBean);
                }
            }
        }

        return data;
    }


    //获取图片处理列表
    public List<DemoListBean> getImageDemoList(){
        List<DemoListBean> data=null;

        if(demoListBeanList!=null&&demoListBeanList.size()>0){
            for (DemoListBean demoListBean : demoListBeanList) {
                if(demoListBean.getType()==DemoListBean.TYPE_IMAGE){
                    if(data==null){
                        data=new ArrayList<>();
                    }
                    data.add(demoListBean);
                }
            }
        }

        return data;
    }
}
