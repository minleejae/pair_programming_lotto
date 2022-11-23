package com.example.pairprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    //로또 시작버튼 불러오기
    Button lottoButton;
    TextView lottoNumberFirst;
    TextView lottoNumberSecond;
    TextView lottoNumberThird;
    TextView lottoNumberFourth;
    TextView lottoNumberFifth;
    TextView lottoNumberSixth;
    TextView lottoNumberBonus;
    ArrayList<TextView> lottoNumbersArray = new ArrayList<>();
    Set<Integer> lottoNumbersSet = new HashSet<>();
    Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //숫자 textview 배열 만들기
        lottoNumberFirst = findViewById(R.id.text_view_lotto_number_first);
        lottoNumberSecond = findViewById(R.id.text_view_lotto_number_second);
        lottoNumberThird = findViewById(R.id.text_view_lotto_number_third);
        lottoNumberFourth = findViewById(R.id.text_view_lotto_number_fourth);
        lottoNumberFifth = findViewById(R.id.text_view_lotto_number_fifth);
        lottoNumberSixth = findViewById(R.id.text_view_lotto_number_sixth);
        lottoNumberBonus = findViewById(R.id.text_view_lotto_number_bonus);
        lottoNumbersArray.add(lottoNumberFirst);
        lottoNumbersArray.add(lottoNumberSecond);
        lottoNumbersArray.add(lottoNumberThird);
        lottoNumbersArray.add(lottoNumberFourth);
        lottoNumbersArray.add(lottoNumberFifth);
        lottoNumbersArray.add(lottoNumberSixth);
        lottoNumbersArray.add(lottoNumberBonus);

        //로또 버튼
        lottoButton = (Button) findViewById(R.id.btn_lotto);

        lottoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "새로운 로또 번호를 추첨합니다.", Toast.LENGTH_SHORT).show();

                // 난수 7개 생성하기
                while (true) {
                    //1 ~ 45 사이의 랜덤한 숫자 얻어내기
                    int ranNum = ran.nextInt(45) + 1;
                    //얻어낸 숫자를 Set 에 저장하기
                    lottoNumbersSet.add(ranNum);
                    //만일 lottoSet 의 size 가 7 이면 반복문 탈출
                    if (lottoNumbersSet.size() == 7) {
                        break;
                    }
                }
                Iterator<Integer> it = lottoNumbersSet.iterator();

                //7개 출력하기
                for (int i = 0; i < lottoNumbersArray.size(); i++) {
                    lottoNumbersArray.get(i).setText(it.next().toString());
                }
                lottoNumbersSet.clear();
            }
        });
    }
}