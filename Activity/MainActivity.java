package com.example.dell.quarterhour.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.bean.AdvertisingBean;
import com.example.dell.quarterhour.bean.ChangeBean;
import com.example.dell.quarterhour.bean.CollectBean;
import com.example.dell.quarterhour.bean.FavoriteBean;
import com.example.dell.quarterhour.bean.GrBean;
import com.example.dell.quarterhour.bean.Hot1Bean;
import com.example.dell.quarterhour.bean.LoginBean;
import com.example.dell.quarterhour.bean.RecommendBean;
import com.example.dell.quarterhour.bean.TextBean;
import com.example.dell.quarterhour.bean.VCRBean;
import com.example.dell.quarterhour.persenter.UpFilePresenter;
import com.example.dell.quarterhour.view.IView;
import com.example.dell.quarterhour.view.custom.DrawableSwitch;
import com.example.dell.quarterhour.view.custom.ThemeManager;
import com.example.dell.quarterhour.view.fragment.Crosstalk;
import com.example.dell.quarterhour.view.fragment.Recommend;
import com.example.dell.quarterhour.view.fragment.Video;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.io.File;
import java.io.FileOutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends BaseActivity<UpFilePresenter> implements IView ,ThemeManager.OnThemeChangeListener{


    private BottomTabBar mBoottomTabBar;
    private SimpleDraweeView simple;
    private int width;
    private int height;
    private int statusBarHeight;
    private final static int DAY_THEME = 1;
    private int theme = R.style.AppTheme;
    private TabLayout tabLayout;
    private ImageView simple_touxiang;
    private DrawerLayout drawerlayout;
    private ImageView set;
    private LinearLayout left;
    private RelativeLayout collect;
    private DrawableSwitch imageView;
    private SharedPreferences chenggong;
    private boolean isLogin;
    private String token;
    private MultipartBody.Part part;
    private ActionBar supportActionBar;
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private AlertDialog dialog;
    /**
     * 夜间模式
     */
    private final static int NIGHT_THEME = 2;
    private String pic_path = Environment.getExternalStorageDirectory() + "/head1.jpg";
    private String crop_icon_path = Environment.getExternalStorageDirectory() + "/head_icon.jpg";
    private ImageView issue;
    private RelativeLayout relativeLayout;
    private LinearLayout zi;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
        setContentView(R.layout.activity_main);
        mBoottomTabBar = findViewById(R.id.boottomTabBar);
        simple = findViewById(R.id.simple);
        supportActionBar = getSupportActionBar();
        mBoottomTabBar.init(getSupportFragmentManager())
                .setImgSize(70, 70)
                .setFontSize(10)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.BLUE, Color.DKGRAY)
                .addTabItem("推荐", R.drawable.recommend, Recommend.class)
                .addTabItem("段子", R.drawable.crosstalk, Crosstalk.class)
                .addTabItem("视频", R.drawable.video, Video.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
        initview();

    }

    private void initview() {
        relativeLayout = findViewById(R.id.relativeLayout);
        tabLayout = findViewById(R.id.tabLayout);
        simple_touxiang = findViewById(R.id.simple_touxiang);
        drawerlayout = findViewById(R.id.drawerlayout);
        simple = findViewById(R.id.simple);
        set = findViewById(R.id.set);
        tv1 = findViewById(R.id.main_tv1);
        tv2 = findViewById(R.id.main_tv2);
        tv3 = findViewById(R.id.main_tv3);
        tv4 = findViewById(R.id.main_tv4);
        tv5 = findViewById(R.id.main_tv5);
        tv6 = findViewById(R.id.main_tv6);
        tv7 = findViewById(R.id.main_tv7);
        collect = findViewById(R.id.collect);
        imageView = findViewById(R.id.imageView1);
        left = findViewById(R.id.left);
        issue = findViewById(R.id.issue);
        zi = findViewById(R.id.zi);
        ThemeManager.registerThemeChangeListener(this);
        issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IssuesActivity.class);
                startActivity(intent);

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetActivity.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemeManager.setThemeMode(ThemeManager.getThemeMode() == ThemeManager.ThemeMode.DAY
                        ? ThemeManager.ThemeMode.NIGHT : ThemeManager.ThemeMode.DAY);
            }
        });
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CollectActivity.class);
                startActivity(intent);
            }
        });
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerlayout.openDrawer(Gravity.LEFT);
            }
        });


        simple_touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chenggong = getSharedPreferences("chenggong", MODE_PRIVATE);
                String token = chenggong.getString("token", "");

                if(chenggong==null){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);

                }else{
                    final AlertDialog.Builder normalDialog =
                            new AlertDialog.Builder(MainActivity.this);

                    normalDialog.setMessage("请选择");
                    normalDialog.setPositiveButton("相机",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    paiZhao();
                                }
                            });
                    normalDialog.setNegativeButton("相册",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    XiangCe();
                                }
                            });
                    // 显示
                    normalDialog.show();


                }

            }
        });


    }

    private void XiangCe() {
        Intent intent = new Intent();
        //指定选择/获取的动作...PICK获取,拿
        intent.setAction(Intent.ACTION_PICK);
        //指定获取的数据的类型
        intent.setType("image/*");

        startActivityForResult(intent, 3000);
    }

    private void paiZhao() {
        Intent intent = new Intent();
        //指定动作...拍照的动作 CAPTURE...捕获
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        //给相机传递一个指令,,,告诉他拍照之后保存..MediaStore.EXTRA_OUTPUT向外输出的指令,,,指定存放的位置
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(pic_path)));

        //拍照的目的是拿到拍的图片
        startActivityForResult(intent, 1000);
    }

    private void crop(Uri uri) {
        Intent intent = new Intent();

        //指定裁剪的动作
        intent.setAction("com.android.camera.action.CROP");

        //设置裁剪的数据(uri路径)....裁剪的类型(image/*)
        intent.setDataAndType(uri, "image/*");

        //执行裁剪的指令
        intent.putExtra("crop", "true");
        //指定裁剪框的宽高比
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        //指定输出的时候宽度和高度
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);

        //设置取消人脸识别
        intent.putExtra("noFaceDetection", false);
        //设置返回数据
        intent.putExtra("return-data", true);

        //
        startActivityForResult(intent, 2000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1000 && resultCode == RESULT_OK) {

            //拍照保存之后进行裁剪....根据图片的uri路径
            crop(Uri.fromFile(new File(pic_path)));
        }


        //获取相册图片
        if (requestCode == 3000 && resultCode == RESULT_OK) {
            //获取的是相册里面某一张图片的uri地址
            Uri uri = data.getData();
            Log.d("data------",data+"");
            //根据这个uri地址进行裁剪
            crop(uri);
        }
        if(requestCode == 2000 && resultCode == RESULT_OK){
            Bitmap bitmap = data.getParcelableExtra("data");
            File saveIconFile = new File(crop_icon_path);
            if (saveIconFile.exists()) {
                saveIconFile.delete();
            }
            try {
                saveIconFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(saveIconFile);
                //把bitmap通过流的形式压缩到文件中
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.flush();
                fos.close();
                //通过file对象创建一个请求体
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), saveIconFile);
                //通过请求体对象 构建MultipartBody.Part对象
                //"file" 接口里面参数的名
                part = MultipartBody.Part.createFormData("file", saveIconFile.getName(), requestFile);
                //保存到sd卡中之后再去把文件上传到服务器


                BasePresenter.loadDataServer("10240", part,"EB52D99F972FFFA5BB57D4C1B3397877");
                Log.e("file=====", part.body()+"");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void initData() {
       BasePresenter.loadDataServerGr("10240");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected UpFilePresenter setPresenter() {
        return new UpFilePresenter();


    }
    @Override
    public void chenggong(AdvertisingBean bean) {

    }

    @Override
    public void shibai(String msg) {

    }

    @Override
    public void chengong1(RecommendBean bean) {

    }

    @Override
    public void shibai1(String msg) {

    }

    @Override
    public void chenggonglogin(LoginBean loginBean) {

    }

    @Override
    public void shibailogin(LoginBean msg) {

    }

    @Override
    public void chenggongchange(ChangeBean Bean) {

    }

    @Override
    public void shibaichange(String msg) {

    }

    @Override
    public void onSuccess(TextBean t) {

    }

    @Override
    public void onErr(String errMsg) {

    }

    @Override
    public void chenggongfile(GrBean bean) {
        Glide.with(this).load(bean.getData().getIcon()).asBitmap().centerCrop().into(new BitmapImageViewTarget(simple_touxiang) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(MainActivity.this.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                simple_touxiang.setImageDrawable(circularBitmapDrawable);

            }
        });
        Toast.makeText(this,"个人中心",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void shibaifile(String msg) {

    }

    @Override
    public void chenggongcollect(CollectBean bean) {

    }

    @Override
    public void shibaicollect(String msg) {

    }

    @Override
    public void chenggonghot(Hot1Bean bean) {

    }

    @Override
    public void shibaihot(String msg) {

    }

    @Override
    public void chenggongfavorite(FavoriteBean bean) {

    }

    @Override
    public void shibaifavorite(String msg) {

    }

    @Override
    public void onSuccessVCR(VCRBean t) {

    }

    @Override
    public void onErrVCR(String msg) {

    }

    @Override
    public void onThemeChanged() {
        initTheme();
    }
    public void initTheme() {

        tv1.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        tv2.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        tv3.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        tv4.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        tv5.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        tv6.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        tv7.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));

       // imageView.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        relativeLayout.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.backgroundColor)));
        zi.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.backgroundColor)));
        // 设置标题栏颜色
        if(supportActionBar != null){
            supportActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.colorPrimary))));
        }
        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.colorPrimary)));
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ThemeManager.unregisterThemeChangeListener(this);
    }
}
