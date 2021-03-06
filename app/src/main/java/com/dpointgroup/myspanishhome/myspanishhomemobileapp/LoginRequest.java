package com.dpointgroup.myspanishhome.myspanishhomemobileapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ekinmac on 13/07/16.
 */
public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL = "http://10.0.2.2:8888/mySpanishHome/scripts/login.php";
    protected static final String LOGIN_REQUEST_TAG = "LOGIN_REQUEST";
    private Map<String, String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
