package com.example.alankrit.twitterapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton button;
    ArrayList<Statuses> statusesArrayList = new ArrayList<>();
    EditText editText;
    ResultAdapter resultAdapter;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        button = (FloatingActionButton) findViewById(R.id.button);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        resultAdapter = new ResultAdapter(statusesArrayList, this);
        recyclerView.setAdapter(resultAdapter);

        final LinearLayout l = (LinearLayout) getLayoutInflater().inflate(R.layout.custom_dialog, null);
        editText = (EditText) l.findViewById(R.id.editText);
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Search")
                .setView(l)
                .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        num = editText.getText().toString();
                        fun(num);
                        editText.getText().clear();
                    }
                })
                .create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
    }

    public void fun(String num) {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://loklak.org/api/search.json?q=" + num)
                .build();

        final ProgressDialog progress = new ProgressDialog(MainActivity.this);
        progress.setMessage("Please Wait");
        progress.show();
        progress.setCancelable(false);

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                Log.e("TAG", "onFailure: " + call.request().url());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();

                final Gson gson = new Gson();
                Result result1 = gson.fromJson(result, Result.class);

                statusesArrayList.addAll(result1.getStatuses());

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.hide();
                        resultAdapter.notifyDataSetChanged();
                    }
                });

            }
        });
    }
}
