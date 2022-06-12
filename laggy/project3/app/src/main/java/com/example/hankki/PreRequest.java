package com.example.hankki;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PreRequest extends StringRequest {

    final static private String URL="http://3.38.14.46/pre.php";
    private Map<String,String> params;

    public PreRequest(int gerne, int spicy, int salty, int sea, int mush,int cucum, int gosu, int gut, String id, Response.Listener <String> listener)
    {
        super(Method.POST,URL,listener,null);
        params=new HashMap<>();
        params.put("gerne",Integer.toString(gerne));
        params.put("spicy",Integer.toString(spicy));
        params.put("salty",Integer.toString(salty));
        params.put("sea",Integer.toString(sea));
        params.put("mush",Integer.toString(mush));
        params.put("cucum",Integer.toString(cucum));
        params.put("gosu",Integer.toString(gosu));
        params.put("gut",Integer.toString(gut));
        params.put("id",id);

    }

    @Nullable
    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
