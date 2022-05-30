package ir.finto.mvvmproject.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

public class Slider {
    private String name, link_img;

    public Slider(String name, String link_img) {
        this.name = name;
        this.link_img = link_img;
    }

    public Slider() {
    }

    @BindingAdapter("LINK_IMAGE_SLIDER")
    public static void LoadImage(ImageView imageView, String link_img)
    {
        Picasso.get().load(link_img).into(imageView);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }
}
