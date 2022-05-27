package ir.finto.mvvmproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import ir.finto.mvvmproject.R;

public class NavigationActivity extends AppCompatActivity {
NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        navController = Navigation.findNavController(this,R.id.fragmentContainerView);
        NavigationUI.setupActionBarWithNavController(this,navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}