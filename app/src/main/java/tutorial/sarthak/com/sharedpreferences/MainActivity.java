
package tutorial.sarthak.com.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
    Button b1;
    SharedPreferences p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=getSharedPreferences("Detail",MODE_PRIVATE);
        Toast.makeText(getApplicationContext(),p.getString("name", "")+""+p.getInt("age",0),Toast.LENGTH_LONG).show();
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=e1.getText().toString();
                int age=Integer.parseInt(e2.getText().toString());

                SharedPreferences.Editor ed=p.edit();
                ed.putInt("age",age);
                ed.putString("name",name);
                ed.commit();
            }
        });
    }
}
