package ks.hs.emirim.wlalsdl_04.project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ImageView imgv = findViewById(R.id.imgv);
        TextView text1 = findViewById(R.id.text_result1);
        TextView text2 = findViewById(R.id.text_result2);
        Intent intent = getIntent();
        double w = intent.getDoubleExtra("weight",0);
        double h = intent.getDoubleExtra("height",0);
        // BMI 단위  :kg /m*m
        double bmi = w / Math.pow(h/100,2);

        String bmiStr = "";
        int imgSrcId = 0;
        int bmiCommenId = 0;

        if (bmi < 18.5) {
            bmiStr = "저";
            imgSrcId = R.drawable.b1;
            bmiCommenId = R.string.BMi_comment1;
        }else if(bmi < 24.9){
            bmiStr = "정상";
            imgSrcId = R.drawable.b2;
            bmiCommenId = R.string.BMi_comment2;
        }else if(bmi < 29.9){
            bmiStr = "과체중";
            imgSrcId = R.drawable.b3;
            bmiCommenId = R.string.BMi_comment3;
        }else if(bmi < 39.9){
            bmiStr = "비만";
            imgSrcId = R.drawable.b4;
            bmiCommenId = R.string.BMi_comment4;
        }else if(bmi < 40){
            bmiStr = "고도비만";
            imgSrcId = R.drawable.b5;
            bmiCommenId = R.string.BMi_comment5;
        }else{
            bmiStr = "초고도비만";
            imgSrcId = R.drawable.b6;
            bmiCommenId = R.string.BMi_comment6;
        }
        imgv.setImageResource(imgSrcId);
        text1.setText(String.format("귀하의 BMI지수는 %.2f(kg/m)이므로 %s체중입니다")+ bmiStr + "체중");
        text2.setText(bmiCommenId);
    }
}