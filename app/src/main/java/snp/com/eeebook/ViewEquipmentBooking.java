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


public class ViewEquipmentBooking extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private Toolbar toolbar;
    Button dateSelectView;
    TextView viewDate;
    Button dateSelectView2;
    TextView viewDate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_equiment_booking);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        addItemsOnSpinner1();

        dateSelectView = (Button) findViewById(R.id.dateSelectView);

        viewDate = (TextView) findViewById(R.id.viewDate);
        dateSelectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewEquipmentBooking.this);
                DatePicker picker = new DatePicker(ViewEquipmentBooking.this);
                picker.setCalendarViewShown(false);
                builder.setTitle("Select Date");
                builder.setView(picker);
                builder.setNegativeButton("Cancel", null);
                builder.setPositiveButton("Set", null);

                Calendar calendar = Calendar.getInstance();
                picker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear++;
                        viewDate.setText(dayOfMonth + " / " + monthOfYear + " / " + year );
                    }
                });

                builder.show();
            }
        });

        dateSelectView2 = (Button) findViewById(R.id.dateSelectView2);

        viewDate2 = (TextView) findViewById(R.id.viewDate2);
        dateSelectView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewEquipmentBooking.this);
                DatePicker picker = new DatePicker(ViewEquipmentBooking.this);
                picker.setCalendarViewShown(false);
                builder.setTitle("Select Date");
                builder.setView(picker);
                builder.setNegativeButton("Cancel", null);
                builder.setPositiveButton("Set", null);

                Calendar calendar = Calendar.getInstance();
                picker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear++;
                        viewDate2.setText(dayOfMonth + " / " + monthOfYear + " / " + year);
                    }
                });

                builder.show();
            }
        });
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
        list.add("Select Equipment");
        list.add("Laptop");
        list.add("Android tablet");
        list.add("Raspberry Pi");
        list.add("Micro-controller");
        list.add("Breadboard");
        list.add("Projector");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(0);
        spinner.setPrompt("Select Equipment");
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
