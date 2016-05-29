package project.suchita.com.surroundsyncproject;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class EmployeeActivity extends AppCompatActivity {

    CustomAdapter customListAdapter;
    Chronometer focus;
    Button btnStart;
    Button btnStop;
    EditText etTask;
    ArrayList<ListItem> listItems;
    ArrayAdapter<ListItem> adapter;
    ListView lv;
    TextView sclock,eclock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        focus = (Chronometer) findViewById(R.id.chronometer);
        focus.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h = (int) (time / 3600000);
                int m = (int) (time - h * 3600000) / 60000;
                int s = (int) (time - h * 3600000 - m * 60000) / 1000;

                String hh = h < 10 ? "0" + h : h + "";
                String mm = m < 10 ? "0" + m : m + "";
                String ss = s < 10 ? "0" + s : s + "";

                chronometer.setText(hh + ":" + mm + ":" + ss);


            }
        });
        etTask = (EditText) findViewById(R.id.etTask);
        lv = (ListView) findViewById(R.id.lvTasks);
        btnStart = (Button) findViewById(R.id.btnStart);
        sclock = (TextView) findViewById(R.id.sclock);
        eclock = (TextView) findViewById(R.id.eclock);
        btnStop = (Button) findViewById(R.id.btnStop);
        listItems = new ArrayList<ListItem>();
        ListItem header = new ListItem();
        header.setTaskName("Task Name");
        header.setTaskDuration("Task Duration");
        header.setTaskTime("Task Time");
        listItems.add(header);
        adapter = new ArrayAdapter<ListItem>(this,android.R.layout.list_content,listItems);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                focus.setBase(SystemClock.elapsedRealtime());
                focus.start();

                setVisible(true);
                String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                sclock.setText(mydate);


            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                focus.stop();

               eclock.setText(focus.getText());

                String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                eclock.setText(mydate);

                ListItem listItem = new ListItem();
                listItem.setTaskName(etTask.getText().toString());
                listItem.setTaskDuration(focus.getText().toString());
                listItem.setTaskTime(sclock.getText().toString() + "-" + eclock.getText().toString());
                listItems.add(listItem);
                customListAdapter = new CustomAdapter(getBaseContext(),android.R.layout.list_content,listItems);
                lv.setAdapter(customListAdapter);
                adapter.notifyDataSetChanged();

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                if(position == 0)
                    return;
                Toast.makeText(EmployeeActivity.this, "Clicked", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }


}


