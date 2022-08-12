package com.paulino.haroldo.haroldportfolio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;

public class PortfolioResumeActivity extends Activity {
    Activity activity;
    ListView searchListView, mainListView;
    EditText searchEditText;
    TextView backTextView,
            searchMatchesTextView,
            closeSearchTextView,
            ownershipTextView,
            coverLetterTextView,
            referencesTextView,
            recommendationsTextView,
            membershipsTextView,
            designTextView,
            goalsTextView,
            powerStatementsTextView;
    LinearLayout searchListLayout;
    LinearLayout mainLayout;
    LinearLayout ownershipLinearLayout;
    LinearLayout coverLetterLinearLayout;
    LinearLayout referencesLinearLayout;
    LinearLayout recommendationsLinearLayout;
    LinearLayout membershipsLinearLayout;
    LinearLayout designLinearLayout;
    LinearLayout goalsLinearLayout;
    LinearLayout powerStatementsLinearLayout;
    ImageButton qualificationsImageButton,
            technicalSkillsImageButton,
            professionalExperienceImageButton,
            educationImageButton,
            ownershipImageButton,
            coverLetterImageButton,
            referencesImageButton,
            recommendationsImageButton,
            membershipsImageButton,
            designImageButton,
            goalsImageButton,
            powerStatementsImageButton;

    private Utilities utilities;

    private class SearchTextWatcher implements TextWatcher {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (searchEditText.getText().toString().trim().equals("")) {
                    searchListLayout.setVisibility(View.GONE);
                    mainLayout.setVisibility(View.VISIBLE);
                } else {
                    searchListLayout.setVisibility(View.VISIBLE);
                    mainLayout.setVisibility(View.GONE);

                    try {
                        JSONArray outputArray = new JSONArray();
                        String fileContents;
                        for(String category : utilities.allCategories) {
                            JSONArray contentsArray = utilities.getListContents(category);
                            for (int i = 0; i < contentsArray.length(); i++) {
                                JSONObject record = (JSONObject) contentsArray.get(i);
                                fileContents = utilities.getFileContentFromAssets(record.get("image").toString() + ".html");
                                fileContents = fileContents == null ? "" : fileContents.replaceAll("<[^>]*>", " ");
                                if (fileContents.toUpperCase().contains(searchEditText.getText().toString().trim().toUpperCase()) ||
                                    record.get("first_line").toString().toUpperCase().contains(searchEditText.getText().toString().trim().toUpperCase()) ||
                                    record.get("second_line").toString().toUpperCase().contains(searchEditText.getText().toString().trim().toUpperCase())) {
                                    outputArray.put(record);
                                }
                            }
                        }

                        if (outputArray.length() == 0) {
                            searchMatchesTextView.setText("nothing found");
                        } else if (outputArray.length() == 1) {
                            searchMatchesTextView.setText("found 1 match");
                        } else {
                            searchMatchesTextView.setText("found " + outputArray.length() + " matches");
                        }
                        searchListView.setAdapter(new ListAdapter(activity, outputArray));
                    } catch (Exception e) {
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) { }
    }

    private class ClickHandler implements View.OnClickListener {
        String action;
        ClickHandler(String inputAction) {
            action = inputAction;
        }

        private void hideSearch() {
            searchEditText.setText("");
            searchListLayout.setVisibility(View.GONE);
            mainLayout.setVisibility(View.VISIBLE);
            ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
        }

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch(action) {
                case "back" : if (searchListLayout.getVisibility() != View.VISIBLE) {
                        finish();
                    } else {
                        hideSearch();
                    }
                    break;
                case "close_search" : hideSearch();
                    break;
                case "qualifications" :
                case "technical_skills" :
                case "professional_experience" :
                case "education" : intent = new Intent(activity, SubjectGroupActivity.class); break;
                case "ownership" :
                case "cover_letter" :
                case "references" :
                case "recommendations" :
                case "memberships" :
                case "design" :
                case "goals" :
                case "power_statements" : intent = new Intent(activity, DetailActivity.class); break;
            }
            if (intent != null) {
                intent.putExtra("topic", action);
                activity.startActivity(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_resume);

        activity = this;
        utilities = new Utilities(activity);

        backTextView = (TextView) findViewById(R.id.backTextView);
        searchMatchesTextView = (TextView) findViewById(R.id.searchMatchesTextView);
        closeSearchTextView = (TextView) findViewById(R.id.closeSearchTextView);

        searchListLayout = (LinearLayout) findViewById(R.id.searchListLayout);
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);

        mainListView = (ListView) findViewById(R.id.portfolioListView);
        searchListView = (ListView) findViewById(R.id.searchListView);
        mainListView.setAdapter(new ListAdapter(activity, utilities.getListContents("work_samples")));

        searchEditText = (EditText) findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new SearchTextWatcher());
        searchEditText.setOnEditorActionListener((view, actionId, event) -> {
            int result = actionId & EditorInfo.IME_MASK_ACTION;
            switch(result) {
                case EditorInfo.IME_ACTION_DONE:
                    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                    break;
                case EditorInfo.IME_ACTION_NEXT:
                    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                    break;
            }
            return false;
        });

        qualificationsImageButton = (ImageButton) findViewById(R.id.qualificationsImageButton);
        technicalSkillsImageButton = (ImageButton) findViewById(R.id.technicalSkillsImageButton);
        professionalExperienceImageButton = (ImageButton) findViewById(R.id.professionalExperienceImageButton);
        educationImageButton = (ImageButton) findViewById(R.id.educationImageButton);

        ownershipImageButton = (ImageButton) findViewById(R.id.ownershipImageButton);
        coverLetterImageButton = (ImageButton) findViewById(R.id.coverLetterImageButton);
        referencesImageButton = (ImageButton) findViewById(R.id.referencesImageButton);
        recommendationsImageButton = (ImageButton) findViewById(R.id.recommendationsImageButton);
        membershipsImageButton = (ImageButton) findViewById(R.id.membershipsImageButton);
        designImageButton = (ImageButton) findViewById(R.id.designImageButton);
        goalsImageButton = (ImageButton) findViewById(R.id.goalsImageButton);
        powerStatementsImageButton = (ImageButton) findViewById(R.id.powerStatementsImageButton);

        ownershipLinearLayout = (LinearLayout) findViewById(R.id.ownershipLinearLayout);
        coverLetterLinearLayout = (LinearLayout) findViewById(R.id.coverLetterLinearLayout);
        referencesLinearLayout = (LinearLayout) findViewById(R.id.referencesLinearLayout);
        recommendationsLinearLayout = (LinearLayout) findViewById(R.id.recommendationsLinearLayout);
        membershipsLinearLayout = (LinearLayout) findViewById(R.id.membershipsLinearLayout);
        designLinearLayout = (LinearLayout) findViewById(R.id.designLinearLayout);
        goalsLinearLayout = (LinearLayout) findViewById(R.id.goalsLinearLayout);
        powerStatementsLinearLayout = (LinearLayout) findViewById(R.id.powerStatementsLinearLayout);

        ownershipTextView = (TextView) findViewById(R.id.ownershipTextView);
        coverLetterTextView = (TextView) findViewById(R.id.coverLetterTextView);
        referencesTextView = (TextView) findViewById(R.id.referencesTextView);
        recommendationsTextView = (TextView) findViewById(R.id.recommendationsTextView);
        membershipsTextView = (TextView) findViewById(R.id.membershipsTextView);
        designTextView = (TextView) findViewById(R.id.designTextView);
        goalsTextView = (TextView) findViewById(R.id.goalsTextView);
        powerStatementsTextView = (TextView) findViewById(R.id.powerStatementsTextView);

        qualificationsImageButton.setOnClickListener(new ClickHandler("qualifications"));
        technicalSkillsImageButton.setOnClickListener(new ClickHandler("technical_skills"));
        professionalExperienceImageButton.setOnClickListener(new ClickHandler("professional_experience"));
        educationImageButton.setOnClickListener(new ClickHandler("education"));

        ownershipImageButton.setOnClickListener(new ClickHandler("ownership"));
        coverLetterImageButton.setOnClickListener(new ClickHandler("cover_letter"));
        referencesImageButton.setOnClickListener(new ClickHandler("references"));
        recommendationsImageButton.setOnClickListener(new ClickHandler("recommendations"));
        membershipsImageButton.setOnClickListener(new ClickHandler("memberships"));
        designImageButton.setOnClickListener(new ClickHandler("design"));
        goalsImageButton.setOnClickListener(new ClickHandler("goals"));
        powerStatementsImageButton.setOnClickListener(new ClickHandler("power_statements"));

        ownershipLinearLayout.setOnClickListener(new ClickHandler("ownership"));
        coverLetterLinearLayout.setOnClickListener(new ClickHandler("cover_letter"));
        referencesLinearLayout.setOnClickListener(new ClickHandler("references"));
        recommendationsLinearLayout.setOnClickListener(new ClickHandler("recommendations"));
        membershipsLinearLayout.setOnClickListener(new ClickHandler("memberships"));
        designLinearLayout.setOnClickListener(new ClickHandler("design"));
        goalsLinearLayout.setOnClickListener(new ClickHandler("goals"));
        powerStatementsLinearLayout.setOnClickListener(new ClickHandler("power_statements"));

        backTextView.setOnClickListener(new ClickHandler("back"));
        closeSearchTextView.setOnClickListener(new ClickHandler("close_search"));
        ownershipTextView.setOnClickListener(new ClickHandler("ownership"));
        coverLetterTextView.setOnClickListener(new ClickHandler("cover_letter"));
        referencesTextView.setOnClickListener(new ClickHandler("references"));
        recommendationsTextView.setOnClickListener(new ClickHandler("recommendations"));
        membershipsTextView.setOnClickListener(new ClickHandler("memberships"));
        designTextView.setOnClickListener(new ClickHandler("design"));
        goalsTextView.setOnClickListener(new ClickHandler("goals"));
        powerStatementsTextView.setOnClickListener(new ClickHandler("power_statements"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Calling Haroldo Paulino", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                utilities.callPhone("8015025237");
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

}
