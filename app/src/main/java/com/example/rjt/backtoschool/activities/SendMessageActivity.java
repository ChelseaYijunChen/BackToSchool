package com.example.rjt.backtoschool.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rjt.backtoschool.R;

import java.util.List;

public class SendMessageActivity extends AppCompatActivity {
    private Button btn = null;
    private EditText number = null;
    private EditText content = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        // 获取按纽ID事件
        btn = (Button) findViewById(R.id.send);
        // 获取按纽的单击事件
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 获取手机号码输入框的ID
                number = (EditText) findViewById(R.id.number);
                // 输入的获取手机号码
                String sendNumber = number.getText().toString();
                // 获取发送信息的ID
                content = (EditText) findViewById(R.id.content);
                // 获取输入的信息
                String sendContent = content.getText().toString();
                if (sendContent != null) {
                    SmsManager sms = SmsManager.getDefault();
                    // 如果短信没有超过限制长度，则返回一个长度的List。
                    List<String> texts = sms.divideMessage(sendContent);
                    for (String text : texts) {
                        sms.sendTextMessage(sendNumber, null, text, null, null);
                    }
                }
            }
        });
    }
}
