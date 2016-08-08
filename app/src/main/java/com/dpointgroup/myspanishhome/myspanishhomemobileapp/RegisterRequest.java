package com.dpointgroup.myspanishhome.myspanishhomemobileapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ekinmac on 13/07/16.
 */
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://10.0.2.2:8888/mySpanishHome/Scripts/register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String email,String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
