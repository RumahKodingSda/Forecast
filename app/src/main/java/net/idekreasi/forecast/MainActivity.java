package net.idekreasi.forecast;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by ikrenet on 26/06/16.
 */
public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate (Bundle saveInstancesState) {
        super.onCreate(saveInstancesState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.nextDay);
                listView.setAdapter (new MainAdapter());
    }

    private class MainAdapter extends BaseAdapter {

        private String[] arrayString = {"Cerah","Mendung","Berawan","Hujan","Badai"};
        private String[] arraySuhu = {"28", "25", "26", "30", "48", "23", "12" };
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
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getBaseContext());
                    convertView = inflater.inflate(R.layout.item_forecast, parent, false);
            TextView textView = (TextView) convertView.findViewById(R.id.cuaca_kam);
                    textView.setText(arrayString[position]);

            TextView textSuhu = (TextView) convertView.findViewById(R.id.suhu_kamis);
                    textSuhu.setText(arraySuhu[position]);
            return convertView;
        }
    }
}
