package com.example.tjddl.begging_customdlg;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.textView_id);
        tv2 = (TextView)findViewById(R.id.textView_name);
        tv3 = (TextView)findViewById(R.id.textView_C);

    }

    public void onClick(View v){
        if(v.getId()==R.id.button){
            final View view = View.inflate(this,R.layout.dlglayout,null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setView(view);
            dlg.setTitle("커스텀 대화상자")
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("입력", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            EditText editText1 = (EditText)view.findViewById(R.id.editText);
                            EditText editText2 = (EditText)view.findViewById(R.id.editText2);
                            CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox);

                            String name = editText1.getText().toString();
                            String ID = editText2.getText().toString();
                            Toast.makeText(getApplicationContext(),"이름은 "+name + "\nID는"+ID+"입니다",Toast.LENGTH_SHORT).show();
                            tv1.setText("이름"+name);
                            tv2.setText("학번 :"+ID);
                            if(checkBox.isChecked()) tv3.setText("복학생여부 : 복학생 아님");
                            else tv3.setText("복학생여부 : 복학생");
                        }
                    });
            dlg.show();
        }
    }
}
