package com.example.assignment1_app;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;

    // Questions array
    private String[] questions = {
            "1) What is the capital of Palestine?",
            "2) Name one of the palestinian traditional dish",
            "3) How many gates does the Old-City of Jerusalem has? ",
            "4) What is the primary language spoken in Palestine?",
            "5) How many colors in the flag of Palestine?",
            "6) Which sea borders the Gaza Strip in Palestine?",
            "7) What is the name of the iconic Palestinian scarf, known for its checkered pattern?",
            "8) Which Palestinian city is known as the birthplace of Jesus Christ according to Christian tradition?",
            "9) Which significant event in 1948 led to the displacement of hundreds of thousands of Palestinian Arabs?",
            "10) What is the name of the famous Palestinian poet known for his work on identity and exile?"
    };

    // Array containing correct answers
    private String[] correctAnswers = {
            "d) Jerusalem.",
            "a) Msakhan.",
            "b) 11 gates (4 of them are closed).",
            "c) Arabic.",
            "c) 4",
            "a) The Mediterranean Sea.",
            "d) Kuffiyeh.",
            "b) Bethlehem.",
            "c) Nakba.",
            "a) Mahmoud Darwish."
    };

    // Array to store user's selected answers
    private String[] selectedAnswers = new String[questions.length];

    // Current question index
    private int currentQuestionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);

        // Display the first question
        displayQuestion(currentQuestionIndex);
    }

    // Display question and options
    private void displayQuestion(int index) {
        questionTextView.setText(questions[index]);

        // Clear any previously selected option
        optionsRadioGroup.clearCheck();

        // Get the resource ID of the options array for the current question
        int optionsArrayResourceId = getResources().getIdentifier("options_array_" + index, "array", getPackageName());

        // Load options from resources and populate RadioButtons
        String[] options = getResources().getStringArray(optionsArrayResourceId);
        for (int i = 0; i < options.length; i++) {
            RadioButton radioButton = (RadioButton) optionsRadioGroup.getChildAt(i);
            radioButton.setText(options[i]);
        }

    }

    // Next button click handler
    public void onNextButtonClick(View view) {
        // Get the selected RadioButton
        int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            selectedAnswers[currentQuestionIndex] = selectedRadioButton.getText().toString();

            // Move to the next question if available
            if (currentQuestionIndex < questions.length - 1) {
                currentQuestionIndex++;
                displayQuestion(currentQuestionIndex);
            } else {
                // Display quiz results if all questions have been answered
                displayQuizResults();
            }
        } else {
            // Prompt the user to select an option if none is selected
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        }
    }

    // Display quiz results
    private void displayQuizResults() {
        // Calculate score and display toast message
        int score = calculateScore();
        Toast.makeText(this, "Quiz completed!\nScore: " + score + " out of " + questions.length, Toast.LENGTH_LONG).show();
    }

    // Calculate user's score
    private int calculateScore() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            if (correctAnswers[i].equals(selectedAnswers[i])) {
                score++;
            }
        }
        return score;
    }
}