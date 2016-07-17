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
        //
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.nextDay);
        listView.setAdapter(new MainAdabter());
    }
    private class MainAdabter extends BaseAdapter{

        private String[] arrayString = {"Cerah", "Berawan", "Salju", "Hujan", "Duren", "Badai", "Gugur"};
        private String[] arraySuhu = {"10", "45", "23", "34", "56", "23", "34", "56", "24", "23", "89",};

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
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getBaseContext());
            view = inflater.inflate(R.layout.item_forecast,parent,false);
            TextView textView = (TextView) view.findViewById(R.id.cuaca_kam);
            textView.setText(arrayString[position]);

            TextView textView1 = (TextView) view.findViewById(R.id.suhu_kamis);
            textView1.setText(arraySuhu[position]);

            return view;
        }
    }
}
