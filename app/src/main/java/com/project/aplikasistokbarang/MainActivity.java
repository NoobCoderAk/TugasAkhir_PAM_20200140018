package com.project.aplikasistokbarang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variable untuk button dan EditText
    Button btnLogin;
    EditText eduser, edpassword;

    //Deklarasi variable untk menyimpan username dan password
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variable yang ada di java dengan componen yang ada pada layout
        btnLogin=findViewById(R.id.btLogin);
        eduser=findViewById(R.id.edUsername);
        edpassword=findViewById(R.id.edPassword);

        //Membuat fungsi onClick pada buton btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext eduser dan edpasssword kedalam variable user dan password
                username = eduser.getText().toString();
                password = edpassword.getText().toString();

                //Mengset user dan password yang benar
                String user= "master";
                String pass = "123";

                //mengecek apakah edittext username dan password terdapat isi atau tidak
                if (username.isEmpty() || password.isEmpty()){
                    //membuat variable toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Username dan Password wajib di isi !!!", Toast.LENGTH_LONG);

                    //menampilkan toast
                    t.show();
                }
                else {

                    //mengecek apakah isi dari username dana password sudah sama dengan username dan
                    //passwod yang sudah diset
                    if (username.equals(user) && password.equals(pass)){
                        //membuatr variable toast dan menampilkan pesan "login sukses"
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);

                        //menampilkan Toast
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();

                        //masukkan value dari variable username dengan kunci "a"
                        //dan dimasukan kedalam bundle
                        b.putString("a", username.trim());

                        //masukkan value dari variable password dengan kunci "b"
                        //dan dimasukkan kedalam bundle
                        b.putString("b", password.trim());

                        //membuat objek intent berpindah activity dari MainActivity ke ActivityHome
                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                        //memasukkan bundle kedalam intent untuk dikirim ke ActivityHome
                        i.putExtras(b);

                        //berpindah ke ActivityHome
                        startActivity(i);
                    }

                    else {
                        //membuat variable toast dan membuat toast dan menampilkan pesan
                        // "login gagal"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal",Toast.LENGTH_LONG);

                        ////menampilkan toast
                        t.show();
                    }
                }
            }
        });
    }
}