package dev.mobile.ass_1_loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author CuongNV
 */
public class MainActivity extends AppCompatActivity {
    private EditText mEdtUser;
    private EditText mEdtPass;
    private Button mBtnLogin;
    private Button mBtnRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtUser = (EditText) findViewById(R.id.edtUser);
        mEdtPass = (EditText) findViewById(R.id.edtPass);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mBtnRegistry = (Button) findViewById(R.id.btnRegistry);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (mEdtUser.getText().toString().equals("")
                        || mEdtPass.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không được trống", Toast.LENGTH_SHORT).show();
                } else if (mEdtUser.getText().toString().equals("abc")
                        && mEdtPass.getText().toString().equals("123")) {
                    Intent intt = new Intent(MainActivity.this, MainDetailActivity.class);
                    startActivity(intt);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    mEdtUser.setText("");
                    mEdtPass.setText("");
                }
            }
        });

        mBtnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }
}
