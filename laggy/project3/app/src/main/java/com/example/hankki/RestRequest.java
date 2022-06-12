package com.example.hankki;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class RestRequest extends StringRequest {

    final static private String URL="http://3.38.14.46/restlist.php";
    private Map<String,String> params;

    public RestRequest(Response.Listener <String> listener)
    {
        super(Method.POST,URL,listener,null);

    }

    @Nullable
    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
