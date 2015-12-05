package snp.com.eeebook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Mimansha on 6/11/2015.
 */
public class BookingActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener, DatePicker.OnDateChangedListener, View.OnClickListener, TimePicker.OnTimeChangedListener{
    private Spinner spinner1;
    private TextView roomDate, roomDateLabel, roomTimelabel, roomTime, roomnumber, toDateLabel, toDateView;
    private Button dateSelect, timeSelect, makeBooking, toDate;
    private Toolbar toolbar;
    private TimePicker timePicker, timePicker2;
    private int fromhod = 0, frommin = 0, tohod = 0, tomin = 0;

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        roomDateLabel.setVisibility(View.VISIBLE);
        roomDate.setVisibility(View.VISIBLE);
        monthOfYear++;
        roomDate.setText(dayOfMonth + " / " + monthOfYear + " / " + year );
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(spinner1.getSelectedItemId() == 0) {
            roomnumber.setVisibility(View.INVISIBLE);
            roomnumber.setText("");
            dateSelect.setVisibility(View.INVISIBLE);
            roomDate.setVisibility(View.INVISIBLE);
            dateSelect.setVisibility(View.INVISIBLE);
            roomDateLabel.setVisibility(View.INVISIBLE);
            timeSelect.setVisibility(View.INVISIBLE);
            roomTimelabel.setVisibility(View.INVISIBLE);
            roomTime.setVisibility(View.INVISIBLE);
            roomnumber.setVisibility(View.INVISIBLE);
            toDate.setVisibility(View.INVISIBLE);
            toDateLabel.setVisibility(View.INVISIBLE);
            toDateView.setVisibility(View.INVISIBLE);
        }
        if(spinner1.getSelectedItemId() == 1) {

            final CharSequence[] list = {"Room 1", "Room 2", "Room 3", "Room 4"};

            AlertDialog.Builder modeSelect = new AlertDialog.Builder(BookingActivity.this);
            modeSelect.setTitle("Select Mode");
            modeSelect.setItems(list, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0) {
                        //Toast.makeText(BookingActivity.this, "Room 1", Toast.LENGTH_SHORT).show();
                        roomnumber.setText("Room 1");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                    if (which == 1) {
                        //Toast.makeText(BookingActivity.this, "Room 2", Toast.LENGTH_SHORT).show();
                        roomnumber.setText("Room 2");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                    if (which == 2) {
                        //Toast.makeText(BookingActivity.this, "Room 3", Toast.LENGTH_SHORT).show();
                        roomnumber.setText("Room 3");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                    if (which == 3) {
                        //Toast.makeText(BookingActivity.this, "Room 4", Toast.LENGTH_SHORT).show();
                        roomnumber.setText("Room 4");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                }
            });

            modeSelect.setPositiveButton("Set", null);
            modeSelect.setNegativeButton("Cancel", null);

            modeSelect.create().show();

            toDate.setVisibility(View.INVISIBLE);
            toDateLabel.setVisibility(View.INVISIBLE);
            toDateView.setVisibility(View.INVISIBLE);

            dateSelect.setText("Select Date");
            dateSelect.setVisibility(View.VISIBLE);
            dateSelect.setOnClickListener(BookingActivity.this);
            timeSelect.setVisibility(View.VISIBLE);
            timeSelect.setOnClickListener(BookingActivity.this); //check listener
        }

        if(spinner1.getSelectedItemId() == 2) {
            final CharSequence[] list = {"Laptop", "Android tablet", "Raspberry Pi", "Micro-controller", "Breadboard", "Projector"};

            AlertDialog.Builder eqSelect = new AlertDialog.Builder(BookingActivity.this);
            eqSelect.setTitle("Select Equipment");
            eqSelect.setItems(list, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0) {
                        roomnumber.setText("Laptop");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                    if (which == 1) {
                        roomnumber.setText("Android tablet");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                    if (which == 2) {
                        roomnumber.setText("Raspberry Pi");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                    if (which == 3) {
                        roomnumber.setText("Micro-controller");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                    if (which == 4) {
                        roomnumber.setText("Breadboard");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                    if (which == 5) {
                        roomnumber.setText("Projector");
                        roomnumber.setVisibility(View.VISIBLE);
                    }
                }
            });

            eqSelect.setPositiveButton("Set", null);
            eqSelect.setNegativeButton("Cancel", null);

            eqSelect.create().show();

            timeSelect.setVisibility(View.INVISIBLE);
            roomTime.setVisibility(View.INVISIBLE);
            roomTimelabel.setVisibility(View.INVISIBLE);

            dateSelect.setVisibility(View.VISIBLE);
            dateSelect.setText("SELECT FROM DATE");
            dateSelect.setOnClickListener(BookingActivity.this);

            toDate.setVisibility(View.VISIBLE);
            toDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BookingActivity.this);
                    DatePicker picker = new DatePicker(BookingActivity.this);
                    picker.setCalendarViewShown(false);
                    builder.setTitle("Select Date");
                    builder.setView(picker);
                    builder.setNegativeButton("Cancel", null);
                    builder.setPositiveButton("Set", null);

                    Calendar calendar = Calendar.getInstance();
                    picker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                        @Override
                        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            toDateLabel.setVisibility(View.VISIBLE);
                            toDateView.setVisibility(View.VISIBLE);
                            toDateView.setText(dayOfMonth + " / " + monthOfYear + " / " + year );
                        }
                    });

                    builder.show();


                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        addItemsOnSpinner1();
        //addListenerOnSpinnerItemSelection();
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        roomDate = (TextView) findViewById(R.id.roomDate);
        roomDate.setVisibility(View.INVISIBLE);
        dateSelect = (Button) findViewById(R.id.dateSelect);
        dateSelect.setVisibility(View.INVISIBLE);
        roomDateLabel = (TextView) findViewById(R.id.roomDatelabel);
        roomDateLabel.setVisibility(View.INVISIBLE);
        timeSelect = (Button) findViewById(R.id.fromTime);
        timeSelect.setVisibility(View.INVISIBLE);
        roomTimelabel = (TextView) findViewById(R.id.roomTimelabel);
        roomTimelabel.setVisibility(View.INVISIBLE);
        roomTime = (TextView) findViewById(R.id.roomTime);
        roomTime.setVisibility(View.INVISIBLE);
        makeBooking = (Button) findViewById(R.id.makeBooking);
        roomnumber = (TextView) findViewById(R.id.roomnumber);
        roomnumber.setVisibility(View.INVISIBLE);
        toDate = (Button) findViewById(R.id.toDate);
        toDate.setVisibility(View.INVISIBLE);
        toDateLabel = (TextView) findViewById(R.id.toDateLabel);
        toDateLabel.setVisibility(View.INVISIBLE);
        toDateView = (TextView) findViewById(R.id.toDateView);
        toDateView.setVisibility(View.INVISIBLE);

        makeBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = roomDate.getText().toString();
                String time = roomTime.getText().toString();
                String item = roomnumber.getText().toString();
                ParseObject bookingObject = new ParseObject("RoomBookings");
                bookingObject.put("", "bar");
                bookingObject.saveInBackground();
            }
        });
    }

    public void addItemsOnSpinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Select Component to Book");
        list.add("Room");
        list.add("Equipment");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner1.setSelection(0);
        spinner1.setPrompt("Select Component to Book");
        spinner1.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("mushu", "Reached onClick");
        if(v.getId()== R.id.dateSelect) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            DatePicker picker = new DatePicker(this);
            picker.setCalendarViewShown(false);
            builder.setTitle("Select Date");
            builder.setView(picker);
            builder.setNegativeButton("Cancel", null);
            builder.setPositiveButton("Set", null);

            Calendar calendar = Calendar.getInstance();
            picker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), BookingActivity.this);

            builder.show();
        }

        else if (v.getId() == R.id.fromTime) {
            Log.d("mushu", "Reached onClick for Time");
            AlertDialog.Builder timeDialog = new AlertDialog.Builder(this);
            timePicker = new TimePicker(this);
            timeDialog.setTitle("Select Start Time");
            timeDialog.setView(timePicker);
            timeDialog.setNegativeButton("Cancel", null);
            timeDialog.setPositiveButton("Set", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlertDialog.Builder timeDialog2 = new AlertDialog.Builder(BookingActivity.this);
                    timePicker2 = new TimePicker(BookingActivity.this);
                    timeDialog2.setTitle("Select End Time");
                    timeDialog2.setView(timePicker2);
                    timeDialog2.setNegativeButton("Cancel", null);
                    timeDialog2.setPositiveButton("Set", null);
                    timePicker2.setOnTimeChangedListener(BookingActivity.this);
                    timeDialog2.show();
                }
            });
            timePicker.setOnTimeChangedListener(BookingActivity.this);
            timeDialog.show();
        }
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

        if(view.equals(timePicker)) {

            fromhod = hourOfDay;
            frommin = minute;

        } else if(view.equals(timePicker2)) {
            roomTimelabel.setVisibility(View.VISIBLE);
            tohod = hourOfDay;
            tomin = minute;
        }
        roomTime.setText(new StringBuilder().append("From - ").append(fromhod).append(" : ").append(frommin).append(" To - ").append(tohod).append(" : ").append(tomin));
        roomTime.setVisibility(View.VISIBLE);
    }
}
