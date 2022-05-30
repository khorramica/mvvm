package ir.finto.mvvmproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.adapter.SliderAdapter;
import ir.finto.mvvmproject.databinding.ActivityPart07ViewPagerBinding;
import ir.finto.mvvmproject.model.Slider;

public class Part07ViewPagerActivity extends AppCompatActivity {

    ActivityPart07ViewPagerBinding binding;
    static SliderAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_part07_view_pager);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_part07_view_pager);

        binding.setViewPagerActivity(this);
        binding.setFragmentManager(getSupportFragmentManager());
    }

    @BindingAdapter("SET_VIEWPAGER")
    public static void SetViewPager(ViewPager viewPager, Part07ViewPagerActivity context) {
        List<Slider> listSlider = new ArrayList<>();
        listSlider.add(new Slider("Top Learn", "https://toplearn.com/img/course/img-course-%D8%AF%D9%88-%D8%B4%D9%86%D8%A8%D9%87-%DB%B2%DB%B5-%D9%81%D8%B1%D9%88%D8%B1%D8%AF%DB%8C%D9%86-%DB%B1%DB%B3%DB%B9%DB%B9-82836702-1292.jpg"));
        listSlider.add(new Slider("Top Learn", "https://toplearn.com/img/course/img-course-%D8%AF%D9%88-%D8%B4%D9%86%D8%A8%D9%87-%DB%B2%DB%B5-%D9%81%D8%B1%D9%88%D8%B1%D8%AF%DB%8C%D9%86-%DB%B1%DB%B3%DB%B9%DB%B9-82836702-1292.jpg"));
        listSlider.add(new Slider("Top Learn", "https://toplearn.com/img/course/img-course-%D8%AF%D9%88-%D8%B4%D9%86%D8%A8%D9%87-%DB%B2%DB%B5-%D9%81%D8%B1%D9%88%D8%B1%D8%AF%DB%8C%D9%86-%DB%B1%DB%B3%DB%B9%DB%B9-82836702-1292.jpg"));
        listSlider.add(new Slider("Top Learn", "https://toplearn.com/img/course/img-course-%D8%AF%D9%88-%D8%B4%D9%86%D8%A8%D9%87-%DB%B2%DB%B5-%D9%81%D8%B1%D9%88%D8%B1%D8%AF%DB%8C%D9%86-%DB%B1%DB%B3%DB%B9%DB%B9-82836702-1292.jpg"));
        listSlider.add(new Slider("Top Learn", "https://toplearn.com/img/course/img-course-%D8%AF%D9%88-%D8%B4%D9%86%D8%A8%D9%87-%DB%B2%DB%B5-%D9%81%D8%B1%D9%88%D8%B1%D8%AF%DB%8C%D9%86-%DB%B1%DB%B3%DB%B9%DB%B9-82836702-1292.jpg"));
        listSlider.add(new Slider("Top Learn", "https://toplearn.com/img/course/img-course-%D8%AF%D9%88-%D8%B4%D9%86%D8%A8%D9%87-%DB%B2%DB%B5-%D9%81%D8%B1%D9%88%D8%B1%D8%AF%DB%8C%D9%86-%DB%B1%DB%B3%DB%B9%DB%B9-82836702-1292.jpg"));

        adapter = new SliderAdapter(listSlider);
        viewPager.setAdapter(adapter);
    }

    @BindingAdapter("SET_TABLAYOUT")
    public static void SetTabLayout(TabLayout tabLayout, ViewPager viewPager) {
        tabLayout.setupWithViewPager(viewPager, true);
    }

}