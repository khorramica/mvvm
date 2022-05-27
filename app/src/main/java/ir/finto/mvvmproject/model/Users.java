package ir.finto.mvvmproject.model;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Users {
    public String name,email,imgLink;


    public Users(String name, String email, String imgLink) {
        this.name = name;
        this.email = email;
        this.imgLink = imgLink;
    }

    @BindingAdapter({"android:CircleImageView"})
    public static void LoadImage(CircleImageView imageView,String imgLink)
    {
        Picasso.get().load(imgLink).into(imageView);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
