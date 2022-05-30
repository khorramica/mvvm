package ir.finto.mvvmproject.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class DetailMovie {
    private String id,name,description,link_img,genre;

    public DetailMovie( String name, String description, String link_img, String genre) {
        this.name = name;
        this.description = description;
        this.link_img = link_img;
        this.genre = genre;
    }

    @BindingAdapter({"android:ImageView"})
    public static void LoadImage(ImageView image, String link_img)
    {
        Picasso.get().load(link_img).into(image);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
