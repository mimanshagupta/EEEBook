package snp.com.eeebook;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ViewBooking extends ActionBarActivity implements AdapterView.OnItemSelectedListener, DatePicker.OnDateChangedListener {

    Spinner spinner;
    private Toolbar toolbar;
    Button dateSelectView;
    TextView viewDate;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        addItemsOnSpinner1();

        dateSelectView = (Button) findViewById(R.id.dateSelectView);

        viewDate = (TextView) findViewById(R.id.viewDate);
        dateSelectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewBooking.this);
                DatePicker picker = new DatePicker(ViewBooking.this);
                picker.setCalendarViewShown(false);
                builder.setTitle("Select Date");
                builder.setView(picker);
                builder.setNegativeButton("Cancel", null);
                builder.setPositiveButton("Set", null);

                Calendar calendar = Calendar.getInstance();
                picker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), ViewBooking.this);

                builder.show();
            }
        });

        tableLayout = (TableLayout) findViewById(R.id.table);
        BuildTable(13, 2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_booking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addItemsOnSpinner1() {

        spinner = (Spinner) findViewById(R.id.roomSelect);
        List<String> list = new ArrayList<String>();
        list.add("Select Room to Book");
        list.add("Room 1");
        list.add("Room 2");
        list.add("Room 3");
        list.add("Room 4");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(0);
        spinner.setPrompt("Select Room to Book");
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        monthOfYear++;
        viewDate.setText(dayOfMonth + " / " + monthOfYear + " / " + year );
    }

    private void BuildTable(int rows, int columns) {
        TableRow tableHead = new TableRow(this);
        tableHead.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView labelTime = new TextView(this);
        labelTime.setText("Time Slot");
        labelTime.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        labelTime.setBackgroundResource(R.color.ColorPrimary);
        labelTime.setPadding(25, 25, 25, 25);
        tableHead.addView(labelTime);

        TextView labelAvailability = new TextView(this);
        labelAvailability.setText("Availability");
        labelAvailability.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        labelAvailability.setBackgroundResource(R.color.ColorPrimary);
        labelAvailability.setPadding(25, 25, 25, 25);
        tableHead.addView(labelAvailability);

        tableLayout.addView(tableHead, new TableLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        for(int i = 10; i < (rows + 10); i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tableRow.setFocusable(true);
            tableRow.setFocusableInTouchMode(true);

            TextView timeSlot = new TextView(this);
            timeSlot.setText(String.valueOf(i) + ":" + "00" +" - " + String.valueOf(i+1) + ":" + "00");
            timeSlot.setPadding(25, 25, 25, 25);
            timeSlot.setBackgroundResource(R.color.whitetext);
            tableRow.addView(timeSlot);

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tableLayout.canScrollVertically(1);
        }
    }
}
