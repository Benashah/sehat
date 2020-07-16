package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import static android.widget.Toast.LENGTH_SHORT;

public class DetailsActivity extends AppCompatActivity {
private RequestQueue requestQueue;
private EditText et_name, et_job;
private Button btn_submit;
    private int text;
    private String charset;
    private String charsetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        et_name=(EditText) findViewById(R.id.et_name);
        et_job=(EditText) findViewById(R.id.et_job);
        btn_submit=(Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data="{"+"\"name\""+ "\""+ et_name.getText().toString()+"\","+"\"job\"" +"\""+et_job.getText().toString()+"\""+"}";
            Submit(data);


            }
        });




    }

    private void Submit(String data) {
        final String savedata = data;
        String URL = "https://sehat.hyderdevelops.ml/test/getOne?id=ABC123";
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), objres.toString(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {



                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), LENGTH_SHORT).show();
            }

        }) {
            @Override
            public String getBodyContentType() {
                return "application/json";
            }


        };
        requestQueue.add(stringRequest);
    }
    }













