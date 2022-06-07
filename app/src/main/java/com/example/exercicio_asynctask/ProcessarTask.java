package com.example.exercicio_asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Integer, Integer, Void> {

    Button btnProcessar;
    TextView txtStatus;
    TextView txtContador;


    public ProcessarTask(Button btnProcessar, TextView txtStatus, TextView txtContador) {
        this.btnProcessar = btnProcessar;
        this.txtStatus = txtStatus;
        this.txtContador = txtContador;
    }

    @Override
    protected void onPreExecute() {
        btnProcessar.setEnabled(false);
        txtStatus.setVisibility(View.INVISIBLE);
        txtContador.setVisibility(View.VISIBLE);
        txtContador.setText("0");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
      txtContador.setText(Integer.toString(values[0]));
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];
        for(int i=0; i<=max; i++){
            SystemClock.sleep(1000);
            this.publishProgress(i);
        }
       return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        btnProcessar.setEnabled(true);
        txtStatus.setText(R.string.finalizado);
        txtStatus.setVisibility(View.VISIBLE);
        txtContador.setVisibility(View.INVISIBLE);
    }
}
