package ir.finto.mvvmproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import ir.finto.mvvmproject.R;
import ir.finto.mvvmproject.databinding.ItemSliderBinding;
import ir.finto.mvvmproject.model.Slider;

public class SliderAdapter extends PagerAdapter {

    List<Slider> data;

    public SliderAdapter(List<Slider> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        ItemSliderBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_slider, container, false);

        binding.setSlider(data.get(position));
        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }
}
