package com.walkwithme;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.walkwithme.databinding.FragmentTopUsersBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TopUsers extends Fragment {

    private FragmentTopUsersBinding binding;
    ArrayList<String> names;
    ArrayList<String> avatars;
    ArrayList<Integer> ids;
    private static final String TAG = "TopUsers Fragment";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTopUsersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        names = new ArrayList<>();
        avatars = new ArrayList<>();
        ids = new ArrayList<>();
        getTopUsers();
    }

    public void getTopUsers() {

        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = MainActivity.url + "info/topUsers?key=" + MainActivity.apiKey;
        StringRequest stringRequest =
                new StringRequest(
                        Request.Method.GET,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response != null) {
                                    try {
                                        JSONArray topUsers = new JSONArray(response);

                                        for (int i = 0; i < topUsers.length(); i++) {
                                            JSONObject topUser = topUsers.getJSONObject(i);
                                            loadUserInfo(topUser);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                VolleyLog.d(TAG, "Error: " + error.getMessage());
                                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT)
                                        .show();
                                // hide the progress dialog
                            }
                        });

        queue.add(stringRequest);
    }

    public void updateView() {
        ListView lv = (ListView) getView().findViewById(R.id.topUsers_listview);
        FriendListAdapter adapter = new FriendListAdapter(getActivity(), names, avatars, ids);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(
                            AdapterView<?> parent, View view, int position, long id) {
                        TopUsersDirections.ActionTopUsersToProfile action =
                                TopUsersDirections.actionTopUsersToProfile();

                        int targetId = (int) view.getTag();
                        action.setId(targetId);
                        NavHostFragment.findNavController(TopUsers.this).navigate(action);
                    }
                });
    }

    public void loadUserInfo(@NonNull JSONObject jsonObject) {

        try {
            int topUserId = jsonObject.getInt("userid");
            ids.add(topUserId);

            String name = jsonObject.getString("username");
            JSONObject avatarJson = new JSONObject(jsonObject.getString("avatar"));
            String avatarURL =
                    "http://185.194.217.213:8080/resources/"
                            + avatarJson.getString("image")
                            + ".jpg";
            names.add(name);
            avatars.add(avatarURL);
            updateView();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
