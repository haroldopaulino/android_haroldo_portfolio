package com.paulino.haroldo.haroldportfolio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class SubjectGroupActivity extends Activity {
    private Utilities utilities;

    private class DetailClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_group);

        Activity activity = this;
        String action = getIntent().getExtras().getString("topic");
        utilities = new Utilities(activity);
        String listContents = "";
        switch (action) {
            case "qualifications" : listContents = "qualifications"; break;
            case "technical_skills" : listContents = "technical_skills"; break;
            case "professional_experience" : listContents = "professional_experience"; break;
            case "ownership" : listContents = "ownership"; break;
            case "cover_letter" : listContents = "cover_letter"; break;
            case "references" : listContents = "references"; break;
            case "resume" : listContents = "resume"; break;
            case "work_samples" : listContents = "work_samples"; break;
            case "education" : listContents = "education"; break;
            case "college_degree" : listContents = "college_degree"; break;
            case "self_initiative_technical_skills" : listContents = "self_initiative_technical_skills"; break;
            case "memberships" : listContents = "memberships"; break;
            case "design" : listContents = "design"; break;
            case "goals" : listContents = "goals"; break;
            case "self_initiative" : listContents = "self_initiative"; break;
            case "skill_agile" : listContents = "professional_experience"; break;
            case "skill_ajax" : listContents = "technical_skills"; break;
            case "skill_android" : listContents = "technical_skills"; break;
            case "skill_android_studio" : listContents = "technical_skills"; break;
            case "skill_apache" : listContents = "technical_skills"; break;
            case "skill_bryce_3d" : listContents = "technical_skills"; break;
            case "skill_camtasia_studio" : listContents = "technical_skills"; break;
            case "skill_corel_draw" : listContents = "technical_skills"; break;
            case "skill_css3" : listContents = "technical_skills"; break;
            case "skill_database_design" : listContents = "professional_experience"; break;
            case "skill_databases" : listContents = "professional_experience"; break;
            case "skill_db2" : listContents = "technical_skills"; break;
            case "skill_dreamweaver" : listContents = "technical_skills"; break;
            case "skill_filezilla" : listContents = "technical_skills"; break;
            case "skill_git" : listContents = "technical_skills"; break;
            case "skill_html" : listContents = "technical_skills"; break;
            case "skill_ibm" : listContents = "technical_skills"; break;
            case "skill_iis" : listContents = "technical_skills"; break;
            case "skill_j2ee" : listContents = "technical_skills"; break;
            case "skill_java" : listContents = "technical_skills"; break;
            case "skill_javascript" : listContents = "technical_skills"; break;
            case "skill_jquery" : listContents = "technical_skills"; break;
            case "skill_json" : listContents = "technical_skills"; break;
            case "skill_linux" : listContents = "technical_skills"; break;
            case "skill_mac_os" : listContents = "technical_skills"; break;
            case "skill_mvc" : listContents = ""; break;
            case "skill_mysql" : listContents = "technical_skills"; break;
            case "skill_netbeans" : listContents = "technical_skills"; break;
            case "skill_oop" : listContents = "professional_experience"; break;
            case "skill_php" : listContents = "technical_skills"; break;
            case "skill_scrum" : listContents = "professional_experience"; break;
            case "skill_seo" : listContents = "professional_experience"; break;
            case "skill_soap" : listContents = "technical_skills"; break;
            case "skill_software_development" : listContents = "professional_experience"; break;
            case "skill_sql" : listContents = "technical_skills"; break;
            case "skill_web_development" : listContents = "professional_experience"; break;
            case "skill_web_services" : listContents = "technical_skills"; break;
            case "skill_windows" : listContents = "technical_skills"; break;
            case "skill_xhtml" : listContents = "technical_skills"; break;
            case "skill_xml" : listContents = "technical_skills"; break;
        }

        TextView backTextView = (TextView) findViewById(R.id.backTextView);
        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        ListView mainListView = (ListView) findViewById(R.id.portfolioListView);
        mainListView.setAdapter(new ListAdapter(this, utilities.getListContents(listContents)));

        backTextView.setOnClickListener(new DetailClickHandler());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Calling Haroldo Paulino", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            utilities.callPhone("8015025237");
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setTitle(utilities.getData("TITLE", action));
        titleTextView.setText(utilities.getData("TITLE", action).toUpperCase());
    }

}
