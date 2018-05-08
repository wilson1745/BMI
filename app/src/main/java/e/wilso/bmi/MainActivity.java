package e.wilso.bmi;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

   private EditText edWeight;
   private EditText edHeight;
   private Button bHelp;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      findViews();
   }

   private void findViews() {
      edWeight = findViewById(R.id.ed_weight);
      edHeight = findViewById(R.id.ed_height);
      bHelp = findViewById(R.id.b_help);
   }

   public void bmi(View v) {
      String w = edWeight.getText().toString();
      String h = edHeight.getText().toString();

      if(!("".equals(w) || "".equals(h))) {
         float weight = Float.parseFloat(w);
         float height = Float.parseFloat(h);
         float bmi = weight/(height*height);

         Log.d("BMI", String.valueOf(bmi));
         Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();
         new AlertDialog.Builder(this)
                 .setMessage(bmi + "")
                 .setTitle("BMI Result")
                 .setPositiveButton("OK", null)
                 .setNeutralButton("Cancel", null)
                 .show();
      }
      else Toast.makeText(this, "Something cannot be null", Toast.LENGTH_LONG).show();
   }
}

/*public class MainActivity extends AppCompatActivity {
   EditText edWeight;                //宣告全域變數
   EditText edHeight;                //宣告全域變數

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      edWeight = findViewById(R.id.ed_weight);
      edHeight = findViewById(R.id.ed_height);
      Button submit = (Button)findViewById(R.id.button3);

      submit.setOnClickListener(new Button.OnClickListener() {
         public void onClick(View arg0) {
            if(!("".equals(edWeight.getText().toString()) || "".equals(edHeight.getText().toString()))) {
               float fw = Float.parseFloat(edWeight.getEditableText().toString());      // 取得 體重輸入值
               float fh = Float.parseFloat(edHeight.getEditableText().toString());      // 取得 身高輸入值
               float fresult;                                                           // BMI值 計算結果

               fh = fh*fh;          // 計算BMI
               fresult = fw/fh;     // 計算BMI

               Log.d("BMI", String.valueOf(fresult));
               Toast.makeText(getApplicationContext(), String.valueOf(fresult), Toast.LENGTH_LONG).show();
            }
            else Toast.makeText(getApplicationContext(), "Something cannot be null", Toast.LENGTH_LONG).show();
         }
      });
   }
}*/
