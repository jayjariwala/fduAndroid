package com.example.jay.customizedialog;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ColorDialog colorDlg;
    TextView text;
    Button btnColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorDlg = new ColorDialog(this);
        text = (TextView) findViewById(R.id.textView2);
        btnColor = (Button) findViewById(R.id.button3);
      /*  btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorDlg.show();
                colorDlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        text.setTextColor(colorDlg.color);
                    }
                });
            }
        });
            */
    }
}
