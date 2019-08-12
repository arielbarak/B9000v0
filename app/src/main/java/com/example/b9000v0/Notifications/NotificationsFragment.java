package com.example.b9000v0.Notifications;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b9000v0.R;
import com.example.b9000v0.Schema.Actions.*;
import com.example.b9000v0.Schema.Notification;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

public class NotificationsFragment extends Fragment {

    private RecyclerView recycler_view;
    private LinearLayoutManager layout_manager;
    private NotificationsListAdapter adapter;
    private Vector<Notification> notifications = new Vector<>(); //TODO remove

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        recycler_view = view.findViewById(R.id.notifications_recycler_view);
        recycler_view.setHasFixedSize(true);

        layout_manager = new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(layout_manager);

        //TODO remove
        Notification n1 = new Notification();
        n1.setAction(new LikeAction());
        n1.setAction_time(
                new GregorianCalendar(2019, Calendar.MARCH, 4, 10, 20, 3)
                        .getTime()
        );
        n1.setEffected_user_id("1");
        n1.setNotification_id("1");
        n1.setTriggering_user_id("2");
        // -------------------------------------
        Notification n2 = new Notification();
        n2.setAction(new SubscriptionAction());
        n2.setAction_time(
                new GregorianCalendar(2019, Calendar.AUGUST, 4, 22, 49, 3)
                        .getTime()
        );
        n2.setEffected_user_id("3");
        n2.setNotification_id("2");
        n2.setTriggering_user_id(
                "45");
        // -------------------------------------
        Notification n3 = new Notification();
        n3.setAction(new CommentAction());
        n3.setAction_time(
                new GregorianCalendar(2019, Calendar.AUGUST, 5, 22, 54, 0)
                        .getTime()
        );
        n3.setEffected_user_id("2");
        n3.setNotification_id("3");
        n3.setTriggering_user_id("1");

        notifications.add(n1);
        notifications.add(n2);
        notifications.add(n3);


        adapter = new NotificationsListAdapter(notifications);
        recycler_view.setAdapter(adapter);


        return view;
    }

}
