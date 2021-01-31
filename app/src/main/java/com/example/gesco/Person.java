package com.example.gesco;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Person extends AppCompatActivity {
    String username;
    String password;

    public int PersonLogin (){
        EditText usernameInput;
        EditText passwordInput;
        usernameInput = (EditText) findViewById(R.id.editTextTextEmailAddress);
        passwordInput = (EditText) findViewById(R.id.editTextNumberPassword);
        this.username = usernameInput.getText().toString();
        this.password = passwordInput.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://github.com/SteveMelons/gesco-backend/blob/main/db.json"; //https://github.com/SteveMelons/gesco-backend/blob/main/db.json

        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("tag", "test");
                return params;
            }
        };
        queue.add(strRequest);
        return 1;
    }
}

/*Person Person1 = new Person;
Person1.usernameInput = findViewById(R.id.editTextTextEmailAddress);
Person1.passwordInput = (EditText) findViewById(R.id.editTextNumberPassword);
Person1.PersonLogin();*/