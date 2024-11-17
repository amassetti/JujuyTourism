package edu.gti.mobile.ariel.jujuytourism;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformationActivity extends AppCompatActivity {

    List<String> groupList;
    //List<String> childList;
    Map<String, List<String>> expandableListMap;

    ExpandableListView expandableListViewJ;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_information);
        /* */

        createExpandableListMap();

        expandableListViewJ = findViewById(R.id.expandableListViewInfo);
        expandableListAdapter = new MyExpandableListAdapter(this, groupList, expandableListMap);
        expandableListViewJ.setAdapter(expandableListAdapter);
        expandableListViewJ.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                    expandableListViewJ.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

        expandableListViewJ.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String selected = expandableListAdapter.getChild(groupPosition, childPosition).toString();
                if (selected.contains("Phone")) {
                    String phone = parsePhoneNumber(selected);
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+" + phone));
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "No phone abailable in this item...", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        /* */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String parsePhoneNumber(String selected) {
        String phoneNumber = selected.substring(selected.indexOf("Phone: ")+7, selected.indexOf("Phone: ")+17);
        //remove spaces and chars
        phoneNumber = phoneNumber.replace(" ", "");
        phoneNumber = phoneNumber.replace("-", "");
        return phoneNumber;
    }

    private void createExpandableListMap() {
        expandableListMap = new HashMap<String, List<String>>();

        groupList = new ArrayList<String>();
        groupList.add("General Recommendations");
        groupList.add("Tourist Information Offices");
        groupList.add("Consulates and Associations");
        groupList.add("Non-Governmental Organizations");
        groupList.add("Emergency Telephones");

        List<String> childList0 = new ArrayList<String>();
        childList0.add("Check the condition of your vehicle and documentation before traveling.");
        childList0.add("Check the status of routes and roads by calling 103 (Civil Protection).");
        childList0.add("Travel with caution on mountain and rural roads, on slopes, use the engine as a brake.");
        childList0.add("If you visit high altitude destinations consult your doctor before traveling if you suffer from hypertension.");
        childList0.add("Do not drive during heavy rain, especially in mountain areas, as they are prone to sliding mud and stones.");
        //childList.addAll(childList0);
        expandableListMap.put(groupList.get(0), childList0);

        List<String> childList1 = new ArrayList<String>();
        childList1.add("OIT CABILDO - Phone: 3885754438 - eMail:  infoturismojujuy@gmail.com");
        childList1.add("AEROPUERTO HORACIO GUZMÁN - Phone: 3884173940 - eMail: aeropuertoturismojujuy@gmail.com");
        childList1.add("TERMINAL DE OMNIBUS - Phone: 3884289012 - eMail: infoterminaljujuy@gmail.com");
        childList1.add("CASA DE JUJUY EN BUENOS AIRES - Phone: 1143931295 - eMail: sec.casadejujuy@gmail.com");
        //childList.addAll(childList1);
        expandableListMap.put(groupList.get(1), childList1);

        List<String> childList2 = new ArrayList<String>();
        childList2.add("VICECONSULADO GENERAL DE ITALIA EN SAN SALVADOR DE JUJUY - Phone: 3884235856 ");
        childList2.add("VICECONSULADO DE ESPAÑA EN SAN SALVADOR DE JUJUY - Phone: 3884235128 ");
        childList2.add("CONSULADO HONORÍFICO DE FRANCIA EN JUJUY - Phone: 3884785021 - eMail: remyrasse@gmail.com");
        expandableListMap.put(groupList.get(2), childList2);

        List<String> childList3 = new ArrayList<String>();
        childList3.add("ASOCIACIÓN ARGENTINA DE AGENCIAS DE VIAJES Y TURISMO – Phone: 3884232696 - eMail: aaavytjujuy@hotmail.com");
        childList3.add("JUJUY BUREAU, EVENTOS Y CONVENCIONES - Phone: 3885801805 - Web: http://jujuybureau.com.ar/ - eMail: jujuybureau@gmail.com");
        childList3.add("CÁMARA DE TURISMO DE JUJUY - Phone: 3884057787 - eMail: camaradeturismojujuy@gmail.com");
        expandableListMap.put(groupList.get(3), childList3);

        List<String> childList4 = new ArrayList<String>();
        childList4.add("POLICE - Phone:        911 ");
        childList4.add("FIREFIGHTERS - Phone:        100 ");
        childList4.add("CIVIL DEFENSE - Phone:        103 ");
        childList4.add("SAME - Phone:        107 ");
        childList4.add("VIOLENCE AGAINST WOMEN - Phone:        144 ");
        childList4.add("ENVIRONMENTAL EMERGENCY - Phone:        105 ");
        childList4.add("San Roque Hospital - Phone: 3884221305 ");
        expandableListMap.put(groupList.get(4), childList4);

    }

}