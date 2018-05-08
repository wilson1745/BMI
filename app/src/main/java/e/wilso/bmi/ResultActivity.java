package e.wilso.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_result);

      Intent intent = getIntent();
      Bundle bag = intent.getExtras();
      float bmi = bag.getFloat(getString(R.string.bmi_extra), 0);
      String test = bag.getString(getString(R.string.test_extra), null);
      String title = bag.getString("MY_TITLE", null);

      //float bmi = intent.getFloatExtra("BMI_EXTRA", 0);
      TextView result = (TextView)findViewById(R.id.result);
      result.setText("您的BMI值為：" + bmi + "\nThis is Bundle " + test + "\nTo test the " + title);

      if(bmi != 0) Toast.makeText(this, "Toast：" + String.valueOf(bmi), Toast.LENGTH_LONG).show();
   }
}
