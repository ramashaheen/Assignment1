package com.example.assignment1_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TopicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        TextView topicTextView = findViewById(R.id.text1);

        // Get the topic information from the intent
        String topic = getIntent().getStringExtra("topic");

        if (topic != null) {
            // Display the topic information
            topicTextView.setText(getTopicInformation(topic));
        } else {
            // Handle error if topic information is not passed
            topicTextView.setText("Error: Topic not provided");
        }
    }


    // Method to get information about the selected topic
    private String getTopicInformation(String topic) {
        // Add your information about each topic here
        switch (topic) {
            case "Capital of palestine":
                return "Jerusalem is a city located in Palestine and is considered by many to be one of " +
                        "the holiest places in the world. " +
                        "Jerusalem is a site of major significance for the three largest " +
                        "monotheistic religions: Judaism, Islam and Christianity, " +
                        " Palestine have claimed Jerusalem as a capital city. " +
                        "Because of these strong, age-old associations." +
                        " bloody conflicts to control the city and sites within it have been waged for thousands of years." +
                        "also Jerusalem has 11 gates 4 of them are closed:" +
                        "the seven known gates:" +
                        "Damascus gate, Herod's gate, Jaffa gate, Lion's gate, New gate, Maghrabi gate, Zion gate" +
                        "the four closed gates:" +
                        "Golden gate, Single gate, Hulda gate (the triple gate), the double gate";
            case "Palestinian Cuisine":
                return "Musakhan is a common main dish that originated in the Jenin and Tulkarm area in the northern West Bank. It consists of a roasted chicken over a taboon bread that has been topped with pieces of fried sweet onions, sumac, allspice and pine nuts.[8] Maqluba is an upside-down rice and baked eggplant casserole mixed with cooked cauliflower, carrots and chicken or lamb. The meal is known throughout the Levant but among Palestinians especially. It dates back to the 13th century.[9]";
            case "Palestinian poet Mahmoud Darwish":
                return "13 March 1941 – 9 August 2008) was a Palestinian poet and author who was regarded as Palestine's national poet" +
                        "In 1988, Darwish wrote the Palestinian Declaration of Independence, which was a declaration for the creation of a State of Palestine. Darwish won numerous awards for his works. Darwish used Palestine as a metaphor for the loss of Eden, birth and resurrection, and the anguish of dispossession and exile. He has been described as incarnating and reflecting the tradition of the political poet in Islam," +
                        " the man of action whose action is poetry. He also served as an editor for several literary magazines in Palestinian.";
            default:
                return "";
        }
    }
}

