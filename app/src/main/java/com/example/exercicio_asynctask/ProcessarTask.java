package com.example.exercicio_asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Integer, Integer, Void> {
    Button btnProcessar;
    TextView txtStatus;
    TextView txtNumber;


    public ProcessarTask(Button btnProcessar, TextView txtStatus,  TextView txtNumber) {
        this.btnProcessar = btnProcessar;
        this.txtStatus = txtStatus;
        this.txtNumber = txtNumber;
    }

    @Override
    protected void onPreExecute() {
        btnProcessar.setEnabled(false);
        txtStatus.setVisibility(View.INVISIBLE);
        txtNumber.setVisibility(View.VISIBLE);
        txtNumber.setText(0);
    }

    @Override
    protected void onPostExecute(Void unused) {
        btnProcessar.setEnabled(true);
        txtStatus.setText(R.string.finalizado);
        txtStatus.setVisibility(View.VISIBLE);
        txtNumber.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int p = values[0];
        txtNumber.setText(p);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[11];
        for(int i=0; i<=max; i++){
            SystemClock.sleep(1000);
            txtNumber.setText(i);
        }
        return null;
    }
}
