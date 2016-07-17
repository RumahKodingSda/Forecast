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
        private String[] arrayCuaca = {"Cerah", "Mendung", "Berawan", "Hujan", "Badai"};
        private String[] arraySuhu = {"30", "29", "28", "27", "26"};

        @Override
        public int getCount() {
            return arrayCuaca.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater =LayoutInflater.from(getBaseContext());
            convertView = inflater.inflate(R.layout.item_forecast, parent, false);
            TextView textCuaca = (TextView) convertView.findViewById(R.id.text_cuaca);
            TextView textSuhu = (TextView) convertView.findViewById(R.id.text_suhu);
                    textCuaca.setText(arrayCuaca[position]);
                    textSuhu.setText(arraySuhu[position]);
            return convertView;
        }
    }
}
