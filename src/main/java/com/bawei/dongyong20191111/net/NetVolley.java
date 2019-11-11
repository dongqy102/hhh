package com.bawei.dongyong20191111.net;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.dongyong20191111.app.AppUrl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 9:03
 * @Description:
 */
public class NetVolley {
     static  NetVolley netVolley =new NetVolley();

    public static NetVolley getInstance() {
        return netVolley;
    }

    private NetVolley() {
    }
    RequestQueue requestQueue= Volley.newRequestQueue(AppUrl.context);

    public  interface MyCallBack{
         void onSccess(String json);
         void onErrorSccess(String error);
    }
    public  void doGet(String temUrl, final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(temUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String s = new String(response.getBytes("ISO-8859-1"), "utf-8");
                    myCallBack.onSccess(s);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 myCallBack.onErrorSccess(error.getMessage());
            }
        });
     requestQueue.add(stringRequest);

    }
    public  void dopost(String temUrl, final Map<String,String>map, final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(temUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String s = new String(response.getBytes("ISO-8859-1"), "utf-8");
                    myCallBack.onSccess(s);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.onErrorSccess(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (map != null) {
                    return map;
                }

                return super.getParams();
            }
        };
         requestQueue.add(stringRequest);
    }

}
