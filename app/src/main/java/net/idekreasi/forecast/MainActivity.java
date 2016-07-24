package net.idekreasi.forecast;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ikrenet on 26/06/16.
 */
public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView txtCuaca;
    TextView txtSuhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.nextDay);
        listView.setAdapter(new MainAdapter());
        txtCuaca = (TextView) findViewById(R.id.cuaca);
        txtSuhu = (TextView) findViewById(R.id.suhu);

        RequestParams requestParams = new RequestParams();
        requestParams.add("q", "Sidoarjo");
        requestParams.add("appid", Constants.API_WEATHER);
        requestParams.add("units", "metric");

        RestClient.get(RestClient.BASE_URL, requestParams, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("Response Error", responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("Response String", responseString);

                try {
                    JSONObject response = new JSONObject(responseString);
                    JSONArray jArr = response.getJSONArray("weather");
                    JSONObject jsonWeather = jArr.getJSONObject(0);
                    JSONObject jsonMain = response.getJSONObject("main");
                    String cuaca = jsonWeather.getString("main");
                    int suhu = jsonMain.getInt("temp");

                    txtCuaca.setText(cuaca);
                    txtSuhu.setText(""+suhu);
                } catch (JSONException e) {
                    Toast.makeText(getBaseContext(), "Error mas", Toast.LENGTH_LONG).show();
                }


            }
        });
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

    private class MainBackground extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
