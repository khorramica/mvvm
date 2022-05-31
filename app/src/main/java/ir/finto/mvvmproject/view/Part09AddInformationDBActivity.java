package ir.finto.mvvmproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ir.finto.mvvmproject.R;

public class Part09AddInformationDBActivity extends AppCompatActivity {

    EditText txtUserName;
    Button btnAdd;
    public static String KEY_INFO_SAVE="keyName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part09_add_information_dbactivity);

        txtUserName = findViewById(R.id.txt_Username);
        btnAdd = findViewById(R.id.btn_Add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                if(TextUtils.isEmpty(txtUserName.getText())){
                    setResult(RESULT_CANCELED,intent);
                }
                else
                {
                    String userName = txtUserName.getText().toString();
                    intent.putExtra(KEY_INFO_SAVE,userName);
                    setResult(RESULT_OK,intent);
                }

                finish();
            }
        });
    }
}