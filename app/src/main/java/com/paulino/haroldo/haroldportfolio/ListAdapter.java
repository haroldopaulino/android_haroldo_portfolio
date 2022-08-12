package com.paulino.haroldo.haroldportfolio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListAdapter extends ArrayAdapter {
    private final Activity activity;
    private final JSONArray contents;

    private class ClickHandler implements View.OnClickListener {
        String action;
        ClickHandler(String inputAction) {
            action = inputAction;
        }

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (action) {
                case "ownership":
                case "cover_letter":
                case "references":
                case "recommendations":
                case "work_samples":
                case "experience":
                case "memberships":
                case "design":
                case "goals":
                case "self_initiative":
                case "focused":
                case "work_ethic":
                case "outstanding_communication":
                case "knowledgeable":
                case "gospel_in_sync_android_app":
                case "http_rest_android_app":
                case "papi_quotes_android_app":
                case "spooled_files_android_app":
                case "ispeech_android_app":
                case "jpro_inspects_android_app":
                case "uiipa_demo_android_app":
                case "knowledge_base_android_app":
                case "bma_annual_android_app":
                case "vitasume_ios_app":
                case "jpro_inspects_website":
                case "uiipa_website":
                case "bma_website":
                case "rafikis_website":
                case "prpinfo_website":
                case "experience_agile":
                case "experience_database_design":
                case "experience_databases":
                case "experience_ibm":
                case "experience_mvc":
                case "experience_oop":
                case "experience_scrum":
                case "experience_seo":
                case "experience_software_development":
                case "experience_web_development":
                case "skill_ajax":
                case "skill_android":
                case "skill_android_studio":
                case "skill_arduino":
                case "skill_apache":
                case "skill_bryce_3d":
                case "skill_camtasia_studio":
                case "skill_corel_draw":
                case "skill_css3":
                case "skill_db2":
                case "skill_dotnet":
                case "skill_dreamweaver":
                case "skill_eclipse":
                case "skill_filezilla":
                case "skill_git":
                case "skill_html":
                case "skill_iis":
                case "skill_java":
                case "skill_javascript":
                case "skill_jquery":
                case "skill_json":
                case "skill_kotlin":
                case "skill_linux":
                case "skill_mac_os":
                case "skill_mysql":
                case "skill_netbeans":
                case "skill_objective_c":
                case "skill_php":
                case "skill_raspberry_pi":
                case "skill_soap":
                case "skill_swift":
                case "skill_swiftui":
                case "experience_sql":
                case "skill_web_services":
                case "skill_windows":
                case "skill_xcode":
                case "skill_xml":
                case "college_degree":
                case "courses":
                    intent = new Intent(activity, DetailActivity.class);
                    break;
                case "qualifications":
                case "technical_skills":
                case "self_initiative_technical_skills":
                case "professional_experience":
                case "education":
                    intent = new Intent(activity, SubjectGroupActivity.class);
                    break;
            }

            assert intent != null;
            intent.putExtra("topic", action);
            activity.startActivity(intent);
        }
    }

    public ListAdapter(Activity inputActivity, JSONArray inputContents) {
        super(inputActivity, R.layout.list_item_1);
        activity = inputActivity;
        contents = inputContents;
    }

    @Override
    public int getCount()
    {
        return contents.length();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = null;
        try {
            JSONObject record = (JSONObject)contents.get(position);
            String listType = record.has("image_style") ? record.get("image_style").toString() : "";
            switch (listType) {
                case "portrait" : rowView = inflater.inflate(R.layout.list_item_1, parent, false); break;
                case "landscape" : rowView = inflater.inflate(R.layout.list_item_2, parent, false); break;
                default : rowView = inflater.inflate(R.layout.list_item_2, parent, false); break;
            }
            LinearLayout linearLayoutContainer = (LinearLayout) rowView.findViewById(R.id.linearLayoutContainer);

            TextView textviewLine1 = (TextView) rowView.findViewById(R.id.textViewLine1);
            TextView textviewLine2 = (TextView) rowView.findViewById(R.id.textViewLine2);
            ImageButton imageButton = (ImageButton) rowView.findViewById(R.id.imageButton);

            textviewLine1.setText(record.has("first_line") ? record.get("first_line").toString() : "");
            textviewLine2.setText(record.has("second_line") ? record.get("second_line").toString() : "");
            imageButton.setImageResource(activity.getResources().getIdentifier(record.get("image").toString(), "drawable", activity.getPackageName()));

            linearLayoutContainer.setOnClickListener(new ClickHandler(record.get("image").toString()));
            textviewLine1.setOnClickListener(new ClickHandler(record.get("image").toString()));
            textviewLine2.setOnClickListener(new ClickHandler(record.get("image").toString()));
            imageButton.setOnClickListener(new ClickHandler(record.get("image").toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rowView;
    }
}
