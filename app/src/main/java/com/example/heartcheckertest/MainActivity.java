package com.example.heartcheckertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity{
    Button submit;
    Map params = new HashMap();
    RequestQueue requestQueue;
    // EditText  age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal ;

 //  String url = "https://api.vultr.com/v1/server/list";
    String url="https://ussouthcentral.services.azureml.net/workspaces/7902219e12eb465083089e9e36ca9784/services/e4fcc71e2c4646f0863ec60e5db6e222/execute";
    /*url = new String(url.trim().replace(" ", "%20").replace("&", "%26")
.replace(",", "%2c").replace("(", "%28").replace(")", "%29")
.replace("!", "%21").replace("=", "%3D").replace("<", "%3C")
.replace(">", "%3E").replace("#", "%23").replace("$", "%24")
.replace("'", "%27").replace("*", "%2A").replace("-", "%2D")
.replace(".", "%2E").replace("/", "%2F").replace(":", "%3A")
.replace(";", "%3B").replace("?", "%3F").replace("@", "%40")
.replace("[", "%5B").replace("\\", "%5C").replace("]", "%5D")
.replace("_", "%5F").replace("`", "%60").replace("{", "%7B")
.replace("|", "%7C").replace("}", "%7D"));*/
    //String url ="https://ussouthcentral.services.azureml.net/workspaces/7902219e12eb465083089e9e36ca9784/services/e4fcc71e2c4646f0863ec60e5db6e222/execute --data 'api-version=2.0' --data 'details=true'";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();
        VolleyLog.DEBUG = true;
        submit = (Button)findViewById(R.id.btn_link_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    sendData();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void sendData() throws JSONException {
        // Context context;
        JSONObject jo = new JSONObject();
        JSONObject j1 = new JSONObject();
        // for address data, first create LinkedHashMap
        LinkedList nameArray = new LinkedList();
        nameArray.add("age");
        nameArray.add("sex");
        nameArray.add("cp");
        nameArray.add("trestbps");
        nameArray.add("chol");
        nameArray.add("fbs");
        nameArray.add("restecg");
        nameArray.add("thalach");
        nameArray.add("exang");
        nameArray.add("oldpeak");
        nameArray.add("slope");
        nameArray.add("ca");
        nameArray.add("thal");

        LinkedList valueArray = new LinkedList();
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");
        valueArray.add("0");


        LinkedList valueArray1 = new LinkedList();
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");
        valueArray1.add("0");

        LinkedList valueMultiArray = new LinkedList();
        valueMultiArray.add(valueArray);
        valueMultiArray.add(valueArray1);


        // putting data to JSONObject
        Map input1 = new LinkedHashMap();
        input1.put("ColumnNames",nameArray);
        input1.put("Values",valueMultiArray);

        Map inputs = new LinkedHashMap();
        Map GlobalParameters = new LinkedHashMap();
        inputs.put("input1",input1);
        try {
            jo.put("Inputs", inputs);
            jo.put("GlobalParameters", GlobalParameters);
        }catch(Exception e){
            e.printStackTrace();
        }
        final String requestbody = jo.toString();

        String requestbody1 = "{\n" +
                "  \"GlobalParameters\": {},\n" +
                "  \"Inputs\": {\n" +
                "    \"input1\": {\n" +
                "      \"ColumnNames\": [\n" +
                "        \"age\",\n" +
                "        \"sex\",\n" +
                "        \"cp\",\n" +
                "        \"trestbps\",\n" +
                "        \"chol\",\n" +
                "        \"fbs\",\n" +
                "        \"restecg\",\n" +
                "        \"thalach\",\n" +
                "        \"exang\",\n" +
                "        \"oldpeak\",\n" +
                "        \"slope\",\n" +
                "        \"ca\",\n" +
                "        \"thal\"\n" +
                "      ],\n" +
                "      \"Values\": [\n" +
                "        [\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\",\n" +
                "          \"0\"\n" +
                "        ]\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Log.i("Body", requestbody1 );
        try {
            JSONObject body = new JSONObject(requestbody1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*JSONObject jsonRequest = new JSONObject();
        try {
            jsonRequest.put("api-version", 2.0);
            jsonRequest.put("details", true);
        }catch(Exception e){
            Log.e("jsonobejct", "onClick: " );
        }
        JSONObject param = new JSONObject();
        param.put("api-version", "2.0");
        param.put("details", "true");
        Log.i("parameter", "sendData: "+param.toString());*/

      /*  HashMap<String, String> params = new HashMap<String, String>();
        params.put("api-version", "2.0");
        params.put("details", "true");*/


        JsonObjectRequest objectRequest = new JsonObjectRequest (
                Request.Method.POST,
                url,
                new JSONObject(requestbody1) ,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Error Response", response.toString());
                        JSONObject response1 = null;
                        VolleyLog.wtf("utf-8", response);
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.i("info", "Request body: " + new String(objectRequest.getBody()));
                        Log.e("Error Response", error.toString());
                        NetworkResponse networkResponse = error.networkResponse;
                        if (error instanceof ServerError && networkResponse != null) {
                            try {
                                Log.e("Error Response!!!!!!!!!", error.toString());
                                Log.e("Error Response!!!!!!!!!", String.valueOf(networkResponse));
                                String res = new String(networkResponse.data,
                                        HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"));
                                // Now you can use any deserializer to make sense of data
                                JSONObject obj = new JSONObject(res);
                            } catch (UnsupportedEncodingException e1) {
                                // Couldn't properly decode data to string
                                e1.printStackTrace();
                            } catch (JSONException e2) {
                                // returned data is not JSONObject?
                                Log.e("Error Response!!!!!!!!!", "hosari");
                                e2.printStackTrace();
                            }
                        }
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer wCjBMQEVRcVISs1sJyalTRdBNsCYz+nWm4WpuNFM0S9tOszbXBr/HDq/HZoAOUs4CDXO6JIehGlOHHRXZz8Ilw==");
                params.put("Content-Type", "application/json");
                params.put("Accept","application/json");
                Log.i("Header", "getHeaders: "+params );
                return params;
            }

          @Override
            protected Map getParams() throws AuthFailureError{
                try {
                    HashMap<String, String> params = new HashMap<String, String>();
                    params.put("api-version","2.0");
                    params.put("details", "true");
                    Log.i("parameter", "getParams: " + params.toString());
                    return params;
                }catch(Exception e){
                    Log.e("Parameter", "getParams: " );
                    return null;
                }
            }

           @Override
            public String getBodyContentType() {
                Log.i("BodyContentType", "getBodyContentType:" +"application/json; charset=" + getParamsEncoding());
                return "application/json";
            }
			/* Adding the comment for testing the git */
           /*@Override
            public byte[] getBody() {


               return requestbody1.getBytes();
           }*/
        };
        try {
            Log.i("info", "Request!!!!!!!!!!: " + objectRequest.toString());
            Log.i("info", "Request body!!!!!!!!!!: " + new String(objectRequest.getBody()));
        }catch(Exception e){}
        requestQueue.getCache().clear();
        requestQueue.add(objectRequest);
    }
}