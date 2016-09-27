package jp.techacademy.hiroyoshi.inada.aisatuapp;



        import android.app.Activity;
import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {
    private TextView textView;
    private Button button;
    private int hour;
    private int minute;

    private static final int TIME_DIALOG_ID = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        updateDisplay();
    }
    private void updateDisplay() {
        textView.setText(new StringBuilder().append(hour).append("2:00").append(minute)
                .append("30"));
        if (hour >= 2 && hour <10) {
            textView.setText("おはよう");

        }
        if (hour >= 10&& hour <18){
            textView.setText("こんにちは");
        }
        if (hour >= 18&& hour <2){
            textView.setText("こんばんは");
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, timeSetListener, hour, minute, true);
        }
        return null;
    }

    private OnTimeSetListener timeSetListener = new OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int selectMinute) {
            hour = hourOfDay;
            minute = selectMinute;

            updateDisplay();
        }
    };
}