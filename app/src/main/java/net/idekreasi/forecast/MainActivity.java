package net.idekreasi.forecast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ikrenet on 26/06/16.
 */
public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.nextDay);
        listView.setAdapter(new MainAdapter());
    }

    private class MainAdapter extends BaseAdapter {

        private String[] arrayString = {"Cerah", "Mendung", "Berawan", "Hujan", "Badai"};
        @Override
        public int getCount() {
            return arrayString.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(getBaseContext());
            view = inflater.inflate(R.layout.item_forecast, viewGroup, false);
            TextView textView = (TextView) view.findViewById(R.id.cuaca_kam);
            textView.setText(arrayString[position]);
            return view;
        }
    }
}
