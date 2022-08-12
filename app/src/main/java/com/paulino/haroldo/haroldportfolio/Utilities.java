package com.paulino.haroldo.haroldportfolio;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Haroldo on 3/1/2016.
 */
public class Utilities {
    Activity activity;

    public Utilities(Activity inputActivity) {
        activity = inputActivity;
    }

    public ArrayList<String> allCategories = new ArrayList<>(Arrays.asList(
            "work_samples",
            "portfolio",
            "qualifications",
            "education",
            "professional_experience",
            "technical_skills"));

    public String getData(String inputMode, String inputKey) {
        String output= "";
        switch(inputMode.toUpperCase()) {
            case "TITLE" :
                switch(inputKey) {
                    case "qualifications" : output = "Qualifications"; break;
                    case "technical_skills" : output = "Technical Skills"; break;
                    case "professional_experience" : output = "Professional Experience"; break;
                    case "http_rest_android_app" : output = "HTTP REST - Android App"; break;
                    case "papi_quotes_android_app" : output = "Papi Quotes - Android App"; break;
                    case "spooled_files_android_app" : output = "Spooled Files - Android App"; break;
                    case "ispeech_android_app" : output = "iSpeech - Android App"; break;
                    case "gospel_in_sync_android_app" : output = "Gospel In Sync - Android App"; break;
                    case "jpro_inspects_android_app" : output = "J-Pro Inspects - Android App"; break;
                    case "uiipa_demo_android_app" : output = "UIIPA Demo - Android App"; break;
                    case "knowledge_base_android_app" : output = "Knowledge Base - Android App"; break;
                    case "bma_annual_android_app" : output = "BMA Annual - Android App"; break;
                    case "vitasume_ios_app" : output = "Vitasume - iOS App"; break;
                    case "jpro_inspects_website" : output = "J-Pro Inspects - Website"; break;
                    case "uiipa_website" : output = "Utah IBM i Professionals Association - Website"; break;
                    case "bma_website" : output = "BMA Corporation - Website"; break;
                    case "rafikis_website" : output = "raFIKis - Website"; break;
                    case "prpinfo_website" : output = "PRPINFO - Website"; break;
                    case "ownership" : output = "Statement of Ownership"; break;
                    case "cover_letter" : output = "Cover Letter"; break;
                    case "references" : output = "References"; break;
                    case "recommendations" : output = "Letters of Recommendation"; break;
                    case "work_samples" : output = "Work Samples"; break;
                    case "education" : output = "Education"; break;
                    case "memberships" : output = "Memberships"; break;
                    case "design" : output = "Design"; break;
                    case "goals" : output = "Goals"; break;
                    case "experience" : output = "Experience"; break;
                    case "self_initiative" : output = "Self Initiative"; break;
                    case "focused" : output = "Focused"; break;
                    case "work_ethic" : output = "Exceptional work ethic"; break;
                    case "outstanding_communication" : output = "Outstanding communication"; break;
                    case "knowledgeable" : output = "Knowledgeable"; break;
                    case "college_degree" : output = "College Degree"; break;
                    case "courses" : output = "Courses"; break;
                    case "self_initiative_technical_skills" : output = "Self Initiative Technical Skills"; break;
                    case "experience_agile" : output = "Agile"; break;
                    case "experience_database_design" : output = "Database Design"; break;
                    case "experience_databases" : output = "Databases"; break;
                    case "experience_ibm" : output = "IBM"; break;
                    case "experience_mvc" : output = "MVC"; break;
                    case "experience_oop" : output = "OOP"; break;
                    case "experience_scrum" : output = "Scrum"; break;
                    case "experience_seo" : output = "SEO"; break;
                    case "experience_software_development" : output = "Software Development"; break;
                    case "experience_sql" : output = "SQL"; break;
                    case "experience_web_development" : output = "Web Development"; break;
                    case "skill_ajax" : output = "Ajax"; break;
                    case "skill_android" : output = "Android"; break;
                    case "skill_android_studio" : output = "Android Studio"; break;
                    case "skill_arduino" : output = "Arduino"; break;
                    case "skill_apache" : output = "Apache HTTP Server"; break;
                    case "skill_bryce_3d" : output = "Bryce 3D"; break;
                    case "skill_camtasia_studio" : output = "Camtasia Studio"; break;
                    case "skill_corel_draw" : output = "Corel Draw"; break;
                    case "skill_css3" : output = "CSS3"; break;
                    case "skill_db2" : output = "DB2"; break;
                    case "skill_dotnet" : output = ".NET"; break;
                    case "skill_dreamweaver" : output = "Dreamweaver"; break;
                    case "skill_eclipse" : output = "Eclipse"; break;
                    case "skill_filezilla" : output = "FileZilla"; break;
                    case "skill_git" : output = "Git"; break;
                    case "skill_html" : output = "HTML"; break;
                    case "skill_iis" : output = "IIS"; break;
                    case "skill_java" : output = "Java"; break;
                    case "skill_javascript" : output = "JavaScript"; break;
                    case "skill_jquery" : output = "jQuery"; break;
                    case "skill_json" : output = "JSON"; break;
                    case "skill_kotlin" : output = "Kotlin"; break;
                    case "skill_linux" : output = "Linux"; break;
                    case "skill_mac_os" : output = "Mac OS"; break;
                    case "skill_mysql" : output = "MySQL"; break;
                    case "skill_netbeans" : output = "NetBeans"; break;
                    case "skill_objective_c" : output = "Objective-C"; break;
                    case "skill_php" : output = "PHP"; break;
                    case "skill_raspberry_pi" : output = "Raspberry Pi"; break;
                    case "skill_soap" : output = "SOAP"; break;
                    case "skill_swift" : output = "Swift"; break;
                    case "skill_swiftui" : output = "SwiftUI"; break;
                    case "skill_web_services" : output = "Web Services"; break;
                    case "skill_windows" : output = "Windows"; break;
                    case "skill_xcode" : output = "Xcode"; break;
                    case "skill_xml" : output = "XML"; break;
                }
                break;
            case "DESCRIPTION" :
                switch(inputKey) {
                    case "http_rest_android_app" : output = "Test and Debug HTTP and RESTful services with this free tool."; break;
                    case "papi_quotes_android_app" : output = "A positive, or maybe funny, famous quote to help brighten your day."; break;
                    case "spooled_files_android_app" : output = "A manager app for IBM i Spooled Files from the available queues."; break;
                    case "ispeech_android_app" : output = "A sample implementation of voice recognition, interfacing with IBM i servers."; break;
                    case "gospel_in_sync_android_app" : output = "Keep connected and participate in a gospel lesson without touching your device."; break;
                    case "jpro_inspects_android_app" : output = "Utah Home Inspection app for the home inspection business J-Pro Inspects."; break;
                    case "uiipa_demo_android_app" : output = "Presented at IBM i Professional Association presentation, includes SQL, web service, program execution and more."; break;
                    case "knowledge_base_android_app" : output = "A custom knowledge base app so may share their solutions within a company."; break;
                    case "bma_annual_android_app" : output = "BMA Annual Conference app that allows the user to load multiple years when available."; break;
                    case "vitasume_ios_app" : output = "Share your resume with the world!"; break;
                    case "jpro_inspects_website" : output = "A Home Inspection database driven website with a custom web service for external client access."; break;
                    case "uiipa_website" : output = "A non-profit organization with focus on IBM i servers ecosystems."; break;
                    case "bma_website" : output = "A Core Banking Corporation database driven website with a custom web service for external client access."; break;
                    case "rafikis_website" : output = "I've made this website several years ago as a free project. This was my contribution to this great charity organization."; break;
                    case "prpinfo_website" : output = "An IT Services company database driven website with a custom web service for external client access."; break;
                    case "ownership" : output = "I certify that the contents displayed in this app were made by me."; break;
                    case "cover_letter" : output = "I am constantly widening my knowledge and experience."; break;
                    case "references" : output = "These people have seen my work ethic and results."; break;
                    case "recommendations" : output = "See for yourself what people say about me."; break;
                    case "work_samples" : output = "I am proud to show some of my samples, both newer and older."; break;
                    case "education" : output = "It all started here."; break;
                    case "memberships" : output = "I treasure my affiliations and how much I choose to give back to my community."; break;
                    case "design" : output = "I love designing art and 3D animations, Check it out!"; break;
                    case "goals" : output = "Where am I going and how do I see myself in the next decade?"; break;
                    case "experience" : output = "21 years' programming experience."; break;
                    case "self_initiative" : output = "Motivation contributes to great professional outcome."; break;
                    case "focused" : output = "Actively pursuing a target is one of my greatest strengths."; break;
                    case "work_ethic" : output = "There is nothing like seeking excellence everyday."; break;
                    case "outstanding_communication" : output = "Being on the same page as my peers is always a priority."; break;
                    case "knowledgeable" : output = "From programming, networking, server configuration and management."; break;
                    case "college_degree" : output = "Computer Science (BS)"; break;
                    case "courses" : output = "Various courses I've successfully completed."; break;
                    case "self_initiative_technical_skills" : output = "Pursing excellence is the only acceptable goal. Always moving forward."; break;
                    case "experience_agile" : output = "It has been fun to work in an Agile development setting for the past 8 years. The benefits from such methodology involve ..."; break;
                    case "experience_database_design" : output = "After so many years working with hundreds of databases, I've learned so much about what works and ..."; break;
                    case "experience_databases" : output = "Working with so many databases' engines, under different operating systems, network setups and hardware ..."; break;
                    case "experience_ibm" : output = "After working with IBM servers for 8 straight years, I've become quite familiar with the web/mobile ..."; break;
                    case "experience_mvc" : output = "I have been implementing MVC in almost all the projects I am involved with, unless I am required ..."; break;
                    case "experience_oop" : output = "For many years I've worked with Object Oriented Programming and have realized it's potential early ..."; break;
                    case "experience_scrum" : output = "We all miss details at some point during development, but scrum development gives the ..."; break;
                    case "experience_seo" : output = "I've been involved in quite a few SEO projects. It is nice to implement ..."; break;
                    case "experience_software_development" : output = "I've been involved with all phases of development of new systems or upgrading existing ones ...."; break;
                    case "experience_sql" : output = "To be able to work with SQL is almost required these days, in virtually every development position ..."; break;
                    case "experience_web_development" : output = "Developing web-based application has been mind bending for me. Coming from ..."; break;
                    case "skill_ajax" : output = "Asynchronous JavaScript and XML."; break;
                    case "skill_android" : output = "Android Development."; break;
                    case "skill_android_studio" : output = "The official integrated development environment (IDE) for Android platform development."; break;
                    case "skill_arduino" : output = "Arduino Software and Electronic development."; break;
                    case "skill_apache" : output = "The world's most used web server software."; break;
                    case "skill_bryce_3d" : output = "Bryce is a 3D modeling, rendering and animation program specializing in fractal landscapes."; break;
                    case "skill_camtasia_studio" : output = "Created and published by TechSmith, for creating video tutorials and presentations directly via screencast, or via a direct recording plug-in to Microsoft PowerPoint."; break;
                    case "skill_corel_draw" : output = "Vector graphics editor, as well as bitmap-image and other graphics types developed and marketed by Corel Corporation."; break;
                    case "skill_css3" : output = "Cascading Style Sheets (CSS) 3."; break;
                    case "skill_db2" : output = "IBM DB2 is a family of database server products developed by IBM, it supports relational model and has been extended to support object-relational features and non-relational structures like JSON and XML."; break;
                    case "skill_dotnet" : output = "I have completed a few .NET projects in 2020 and 2021, using Visual Studio and Azure Portal. It was a great experience."; break;
                    case "skill_dreamweaver" : output = "Adobe Dreamweaver is a proprietary web development tool developed by Adobe Systems."; break;
                    case "skill_eclipse" : output = "Eclipse is an integrated development environment (IDE) used in computer programming."; break;
                    case "skill_filezilla" : output = "FileZilla is a free software, cross-platform FTP application, consisting of FileZilla Client and FileZilla Server."; break;
                    case "skill_git" : output = "Git is a version control system that is widely used for software development[6] and other version control tasks."; break;
                    case "skill_html" : output = "HyperText Markup Language, commonly abbreviated as HTML."; break;
                    case "skill_iis" : output = "Internet Information Services (IIS, formerly Internet Information Server) is an extensible web server created by Microsoft for use with Windows NT family. IIS supports HTTP, HTTPS, FTP, FTPS, SMTP and NNTP."; break;
                    case "skill_java" : output = "Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible."; break;
                    case "skill_javascript" : output = "JavaScript is a high-level, dynamic, untyped, and interpreted programming language."; break;
                    case "skill_jquery" : output = "jQuery is a cross-platform JavaScript library designed to simplify the client-side scripting of HTML."; break;
                    case "skill_json" : output = "JavaScript Object Notation is an open-standard format that uses human-readable text to transmit data objects consisting of attribute–value pairs."; break;
                    case "skill_kotlin" : output = "I'm embracing this new language by taking a full course and converting my Knowledge Base Android app from Java to Kotlin."; break;
                    case "skill_linux" : output = "Linux is a Unix-like and mostly POSIX-compliant computer operating system assembled under the model of free and open-source software development and distribution."; break;
                    case "skill_mac_os" : output = "Mac OS is a series of graphical user interface–based operating systems developed by Apple Inc. for their Macintosh line of computer systems."; break;
                    case "skill_mysql" : output = "MySQL is an open-source relational database management system (RDBMS)."; break;
                    case "skill_netbeans" : output = "NetBeans is a software development platform written in Java."; break;
                    case "skill_objective_c" : output = "All my iOS projects at iSolved were 100% Objective-C, so I had the opportunity to learn and see how stable it is to code in Objective-C."; break;
                    case "skill_php" : output = "PHP is a server-side scripting language designed for web development but also used as a general-purpose programming language."; break;
                    case "skill_raspberry_pi" : output = "Raspberry Pi Software and Electronic development."; break;
                    case "skill_soap" : output = "SOAP, or the Simple Object Access Protocol is a protocol used in computing. Web services use this protocol to communicate."; break;
                    case "skill_swift" : output = "All my iOS projects at iSolved were 100% Objective C, so I've started converting them to Swift, simply because Apple strongly recommended. Swift is such a powerful modern language and such a pleasure to develop with."; break;
                    case "skill_swiftui" : output = "Apple has recommended the adoption of SwiftUI over Storyboards, so I've started developing a few test apps using nothing but Swift and SwiftUI. It's been a great journey."; break;
                    case "skill_web_services" : output = "A Web service is a service offered by an electronic device to another electronic device, communicating with each other via the World Wide Web."; break;
                    case "skill_windows" : output = "Windows is a metafamily of graphical operating systems developed, marketed, and sold by Microsoft."; break;
                    case "skill_xcode" : output = "The most powerful native iOS/macOS/watchOS/tvOS IDE in the world. Xcode has a special place in my heart, especially because I use it everyday. I'd highly recommend it to any serious iOS developer."; break;
                    case "skill_xml" : output = "XML is a markup language that defines a set of rules for encoding documents in a format that is both human-readable and machine-readable."; break;
                }
            break;
        }
        return output;
    }

    public String getFileContentFromAssets(String name) {
        try {
            InputStream inputStream = activity.getAssets().open(name);
            int streamSize = inputStream.available();
            byte[] buffer = new byte[streamSize];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public JSONArray getListContents(String subjectGroup) {
        JSONArray outputArray = new JSONArray();
        try {
            switch(subjectGroup.trim().toLowerCase()) {
                case "work_samples" :
                    outputArray.put((new JSONObject()).put("image", "http_rest_android_app").put("image_style", "portrait").put("first_line", getData("TITLE", "http_rest_android_app")).put("second_line", getData("DESCRIPTION", "http_rest_android_app")));
                    outputArray.put((new JSONObject()).put("image", "papi_quotes_android_app").put("image_style", "portrait").put("first_line", getData("TITLE", "papi_quotes_android_app")).put("second_line", getData("DESCRIPTION", "papi_quotes_android_app")));
                    outputArray.put((new JSONObject()).put("image", "spooled_files_android_app").put("image_style", "portrait").put("first_line", getData("TITLE", "spooled_files_android_app")).put("second_line", getData("DESCRIPTION", "spooled_files_android_app")));
                    outputArray.put((new JSONObject()).put("image", "ispeech_android_app").put("image_style", "portrait").put("first_line", getData("TITLE", "ispeech_android_app")).put("second_line", getData("DESCRIPTION", "ispeech_android_app")));
                    outputArray.put((new JSONObject()).put("image", "knowledge_base_android_app").put("image_style", "portrait").put("first_line", getData("TITLE", "knowledge_base_android_app")).put("second_line", getData("DESCRIPTION", "knowledge_base_android_app")));
                    outputArray.put((new JSONObject()).put("image", "uiipa_demo_android_app").put("image_style", "portrait").put("first_line", getData("TITLE", "uiipa_demo_android_app")).put("second_line", getData("DESCRIPTION", "uiipa_demo_android_app")));
                    outputArray.put((new JSONObject()).put("image", "gospel_in_sync_android_app").put("image_style", "portrait").put("first_line", getData("TITLE", "gospel_in_sync_android_app")).put("second_line", getData("DESCRIPTION", "gospel_in_sync_android_app")));
                    outputArray.put((new JSONObject()).put("image", "bma_annual_android_app").put("image_style", "portrait").put("first_line", getData("TITLE", "bma_annual_android_app")).put("second_line", getData("DESCRIPTION", "bma_annual_android_app")));
                    outputArray.put((new JSONObject()).put("image", "vitasume_ios_app").put("image_style", "portrait").put("first_line", getData("TITLE", "vitasume_ios_app")).put("second_line", getData("DESCRIPTION", "vitasume_ios_app")));
                    outputArray.put((new JSONObject()).put("image", "uiipa_website").put("image_style", "portrait").put("first_line", getData("TITLE", "uiipa_website")).put("second_line", getData("DESCRIPTION", "uiipa_website")));
                    outputArray.put((new JSONObject()).put("image", "bma_website").put("image_style", "portrait").put("first_line", getData("TITLE", "bma_website")).put("second_line", getData("DESCRIPTION", "bma_website")));
                    outputArray.put((new JSONObject()).put("image", "prpinfo_website").put("image_style", "portrait").put("first_line", getData("TITLE", "prpinfo_website")).put("second_line", getData("DESCRIPTION", "prpinfo_website")));
                    outputArray.put((new JSONObject()).put("image", "jpro_inspects_website").put("image_style", "portrait").put("first_line", getData("TITLE", "jpro_inspects_website")).put("second_line", getData("DESCRIPTION", "jpro_inspects_website")));
                    outputArray.put((new JSONObject()).put("image", "rafikis_website").put("image_style", "portrait").put("first_line", getData("TITLE", "rafikis_website")).put("second_line", getData("DESCRIPTION", "rafikis_website")));
                    break;
                case "portfolio" :
                    outputArray.put((new JSONObject()).put("image", "ownership").put("image_style", "landscape").put("first_line", getData("TITLE", "ownership")).put("second_line", getData("DESCRIPTION", "ownership")));
                    outputArray.put((new JSONObject()).put("image", "cover_letter").put("image_style", "landscape").put("first_line", getData("TITLE", "cover_letter")).put("second_line", getData("DESCRIPTION", "cover_letter")));
                    outputArray.put((new JSONObject()).put("image", "references").put("image_style", "landscape").put("first_line", getData("TITLE", "references")).put("second_line", getData("DESCRIPTION", "references")));
                    outputArray.put((new JSONObject()).put("image", "recommendations").put("image_style", "landscape").put("first_line", getData("TITLE", "recommendations")).put("second_line", getData("DESCRIPTION", "recommendations")));
                    outputArray.put((new JSONObject()).put("image", "work_samples").put("image_style", "landscape").put("first_line", getData("TITLE", "work_samples")).put("second_line", getData("DESCRIPTION", "work_samples")));
                    outputArray.put((new JSONObject()).put("image", "education").put("image_style", "landscape").put("first_line", getData("TITLE", "education")).put("second_line", getData("DESCRIPTION", "education")));
                    outputArray.put((new JSONObject()).put("image", "memberships").put("image_style", "landscape").put("first_line", getData("TITLE", "memberships")).put("second_line", getData("DESCRIPTION", "memberships")));
                    outputArray.put((new JSONObject()).put("image", "design").put("image_style", "landscape").put("first_line", getData("TITLE", "design")).put("second_line", getData("DESCRIPTION", "design")));
                    outputArray.put((new JSONObject()).put("image", "goals").put("image_style", "landscape").put("first_line", getData("TITLE", "goals")).put("second_line", getData("DESCRIPTION", "goals")));
                    break;
                case "qualifications" :
                    outputArray.put((new JSONObject()).put("image", "experience").put("image_style", "landscape").put("first_line", getData("TITLE", "experience")).put("second_line", getData("DESCRIPTION", "experience")));
                    outputArray.put((new JSONObject()).put("image", "self_initiative").put("image_style", "landscape").put("first_line", getData("TITLE", "self_initiative")).put("second_line", getData("DESCRIPTION", "self_initiative")));
                    outputArray.put((new JSONObject()).put("image", "focused").put("image_style", "landscape").put("first_line", getData("TITLE", "focused")).put("second_line", getData("DESCRIPTION", "focused")));
                    outputArray.put((new JSONObject()).put("image", "work_ethic").put("image_style", "landscape").put("first_line", getData("TITLE", "work_ethic")).put("second_line", getData("DESCRIPTION", "work_ethic")));
                    outputArray.put((new JSONObject()).put("image", "outstanding_communication").put("image_style", "landscape").put("first_line", getData("TITLE", "outstanding_communication")).put("second_line", getData("DESCRIPTION", "outstanding_communication")));
                    outputArray.put((new JSONObject()).put("image", "knowledgeable").put("image_style", "landscape").put("first_line", getData("TITLE", "knowledgeable")).put("second_line", getData("DESCRIPTION", "knowledgeable")));
                    break;
                case "education" :
                    outputArray.put((new JSONObject()).put("image", "college_degree").put("image_style", "landscape").put("first_line", getData("TITLE", "college_degree")).put("second_line", getData("DESCRIPTION", "college_degree")));
                    outputArray.put((new JSONObject()).put("image", "courses").put("image_style", "landscape").put("first_line", getData("TITLE", "courses")).put("second_line", getData("DESCRIPTION", "courses")));
                    outputArray.put((new JSONObject()).put("image", "self_initiative_technical_skills").put("image_style", "landscape").put("first_line", getData("TITLE", "self_initiative_technical_skills")).put("second_line", getData("DESCRIPTION", "self_initiative_technical_skills")));
                    break;
                case "professional_experience" :
                    outputArray.put((new JSONObject()).put("image", "experience_agile").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_agile")).put("second_line", getData("DESCRIPTION", "experience_agile")));
                    outputArray.put((new JSONObject()).put("image", "experience_database_design").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_database_design")).put("second_line", getData("DESCRIPTION", "experience_database_design")));
                    outputArray.put((new JSONObject()).put("image", "experience_databases").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_databases")).put("second_line", getData("DESCRIPTION", "experience_databases")));
                    outputArray.put((new JSONObject()).put("image", "experience_ibm").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_ibm")).put("second_line", getData("DESCRIPTION", "experience_ibm")));
                    outputArray.put((new JSONObject()).put("image", "experience_mvc").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_mvc")).put("second_line", getData("DESCRIPTION", "experience_mvc")));
                    outputArray.put((new JSONObject()).put("image", "experience_oop").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_oop")).put("second_line", "For many years I've worked with Object Oriented Programming and have realized it's potential early ..."));
                    outputArray.put((new JSONObject()).put("image", "experience_scrum").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_scrum")).put("second_line", getData("DESCRIPTION", "experience_scrum")));
                    outputArray.put((new JSONObject()).put("image", "experience_seo").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_seo")).put("second_line", getData("DESCRIPTION", "experience_seo")));
                    outputArray.put((new JSONObject()).put("image", "experience_software_development").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_software_development")).put("second_line", getData("DESCRIPTION", "experience_software_development")));
                    outputArray.put((new JSONObject()).put("image", "experience_sql").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_sql")).put("second_line", getData("DESCRIPTION", "experience_sql")));
                    outputArray.put((new JSONObject()).put("image", "experience_web_development").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_web_development")).put("second_line", getData("DESCRIPTION", "experience_web_development")));
                    break;
                case "technical_skills" :
                case "self_initiative_technical_skills" :
                    outputArray.put((new JSONObject()).put("image", "skill_ajax").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_ajax")).put("second_line", getData("DESCRIPTION", "skill_ajax")));
                    outputArray.put((new JSONObject()).put("image", "skill_android").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_android")).put("second_line", getData("DESCRIPTION", "skill_android")));
                    outputArray.put((new JSONObject()).put("image", "skill_android_studio").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_android_studio")).put("second_line", getData("DESCRIPTION", "skill_android_studio")));
                    outputArray.put((new JSONObject()).put("image", "skill_arduino").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_arduino")).put("second_line", getData("DESCRIPTION", "skill_arduino")));
                    outputArray.put((new JSONObject()).put("image", "skill_apache").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_apache")).put("second_line", getData("DESCRIPTION", "skill_apache")));
                    outputArray.put((new JSONObject()).put("image", "skill_bryce_3d").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_bryce_3d")).put("second_line", getData("DESCRIPTION", "skill_bryce_3d")));
                    outputArray.put((new JSONObject()).put("image", "skill_camtasia_studio").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_camtasia_studio")).put("second_line", getData("DESCRIPTION", "skill_camtasia_studio")));
                    outputArray.put((new JSONObject()).put("image", "skill_corel_draw").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_corel_draw")).put("second_line", getData("DESCRIPTION", "skill_corel_draw")));
                    outputArray.put((new JSONObject()).put("image", "skill_css3").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_css3")).put("second_line", getData("DESCRIPTION", "skill_css3")));
                    outputArray.put((new JSONObject()).put("image", "skill_db2").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_db2")).put("second_line", getData("DESCRIPTION", "skill_db2")));
                    outputArray.put((new JSONObject()).put("image", "skill_dotnet").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_dotnet")).put("second_line", getData("DESCRIPTION", "skill_dotnet")));
                    outputArray.put((new JSONObject()).put("image", "skill_dreamweaver").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_dreamweaver")).put("second_line", getData("DESCRIPTION", "skill_dreamweaver")));
                    outputArray.put((new JSONObject()).put("image", "skill_eclipse").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_eclipse")).put("second_line", getData("DESCRIPTION", "skill_eclipse")));
                    outputArray.put((new JSONObject()).put("image", "skill_filezilla").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_filezilla")).put("second_line", getData("DESCRIPTION", "skill_filezilla")));
                    outputArray.put((new JSONObject()).put("image", "skill_git").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_git")).put("second_line", getData("DESCRIPTION", "skill_git")));
                    outputArray.put((new JSONObject()).put("image", "skill_html").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_html")).put("second_line", getData("DESCRIPTION", "skill_html")));
                    outputArray.put((new JSONObject()).put("image", "skill_iis").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_iis")).put("second_line", getData("DESCRIPTION", "skill_iis")));
                    outputArray.put((new JSONObject()).put("image", "skill_java").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_java")).put("second_line", getData("DESCRIPTION", "skill_java")));
                    outputArray.put((new JSONObject()).put("image", "skill_javascript").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_javascript")).put("second_line", getData("DESCRIPTION", "skill_javascript")));
                    outputArray.put((new JSONObject()).put("image", "skill_jquery").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_jquery")).put("second_line", getData("DESCRIPTION", "skill_jquery")));
                    outputArray.put((new JSONObject()).put("image", "skill_json").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_json")).put("second_line", getData("DESCRIPTION", "skill_json")));
                    outputArray.put((new JSONObject()).put("image", "skill_kotlin").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_kotlin")).put("second_line", getData("DESCRIPTION", "skill_kotlin")));
                    outputArray.put((new JSONObject()).put("image", "skill_linux").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_linux")).put("second_line", getData("DESCRIPTION", "skill_linux")));
                    outputArray.put((new JSONObject()).put("image", "skill_mac_os").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_mac_os")).put("second_line", getData("DESCRIPTION", "skill_mac_os")));
                    outputArray.put((new JSONObject()).put("image", "skill_mysql").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_mysql")).put("second_line", getData("DESCRIPTION", "skill_mysql")));
                    outputArray.put((new JSONObject()).put("image", "skill_netbeans").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_netbeans")).put("second_line", getData("DESCRIPTION", "skill_netbeans")));
                    outputArray.put((new JSONObject()).put("image", "skill_objective_c").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_objective_c")).put("second_line", getData("DESCRIPTION", "skill_objective_c")));
                    outputArray.put((new JSONObject()).put("image", "skill_php").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_php")).put("second_line", getData("DESCRIPTION", "skill_php")));
                    outputArray.put((new JSONObject()).put("image", "skill_raspberry_pi").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_raspberry_pi")).put("second_line", getData("DESCRIPTION", "skill_raspberry_pi")));
                    outputArray.put((new JSONObject()).put("image", "skill_soap").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_soap")).put("second_line", getData("DESCRIPTION", "skill_soap")));
                    outputArray.put((new JSONObject()).put("image", "skill_swift").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_swift")).put("second_line", getData("DESCRIPTION", "skill_swift")));
                    outputArray.put((new JSONObject()).put("image", "skill_swiftui").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_swiftui")).put("second_line", getData("DESCRIPTION", "skill_swiftui")));
                    outputArray.put((new JSONObject()).put("image", "experience_sql").put("image_style", "landscape").put("first_line", getData("TITLE", "experience_sql")).put("second_line", getData("DESCRIPTION", "experience_sql")));
                    outputArray.put((new JSONObject()).put("image", "skill_web_services").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_web_services")).put("second_line", getData("DESCRIPTION", "skill_web_services")));
                    outputArray.put((new JSONObject()).put("image", "skill_windows").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_windows")).put("second_line", getData("DESCRIPTION", "skill_windows")));
                    outputArray.put((new JSONObject()).put("image", "skill_xcode").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_xcode")).put("second_line", getData("DESCRIPTION", "skill_xcode")));
                    outputArray.put((new JSONObject()).put("image", "skill_xml").put("image_style", "landscape").put("first_line", getData("TITLE", "skill_xml")).put("second_line", getData("DESCRIPTION", "skill_xml")));
                    break;
            }

        } catch (JSONException e) {
            Log.d("error", e.getMessage());
        }

        return outputArray;
    }

    public void callPhone(final String phoneNumber) {
        activity.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

    public void openMap() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=559 E 2200 S, Clearfield, UT");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        activity.startActivity(mapIntent);
    }

    public void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "haroldopaulino@hotmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contact from Portfolio (Android)");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi Haroldo, I would like to talk to you.");

        activity.startActivity(Intent.createChooser(intent, "Send Email"));
    }
}
