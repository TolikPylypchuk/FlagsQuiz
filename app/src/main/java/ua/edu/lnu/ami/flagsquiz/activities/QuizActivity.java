package ua.edu.lnu.ami.flagsquiz.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orm.SugarRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import ua.edu.lnu.ami.flagsquiz.R;
import ua.edu.lnu.ami.flagsquiz.models.Country;
import ua.edu.lnu.ami.flagsquiz.models.Statistics;
import ua.edu.lnu.ami.flagsquiz.services.CountryService;

public class QuizActivity extends Activity {

    private CountryService countryService;

    private String countryCorrectName;

    private Integer questionNumber = 1;
    private Integer attemptsCounter = 0;

    private Integer questionsAmount = 3;
    private Integer answersAmount = 9;
    private List<String> regions = new ArrayList<>();

    @Inject
    void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public Integer getQuestionsAmount() {
        return questionsAmount;
    }

    public void setQuestionsAmount(Integer questionsAmount) {
        this.questionsAmount = questionsAmount;
    }

    public Integer getAnswersAmount() {
        return answersAmount;
    }

    public void setAnswersAmount(Integer answersAmount) {
        this.answersAmount = answersAmount;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        regions.add("Europe");

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        LinearLayout firstColumn = findViewById(R.id.countries1);
        LinearLayout secondColumn = findViewById(R.id.countries2);
        LinearLayout thirdColumn = findViewById(R.id.countries3);

        switch (answersAmount) {
            case 3:
                firstColumn.setVisibility(View.VISIBLE);
                secondColumn.setVisibility(View.GONE);
                thirdColumn.setVisibility(View.GONE);
                break;
            case 6:
                firstColumn.setVisibility(View.VISIBLE);
                secondColumn.setVisibility(View.VISIBLE);
                thirdColumn.setVisibility(View.GONE);

                break;
            case 9:
                firstColumn.setVisibility(View.VISIBLE);
                secondColumn.setVisibility(View.VISIBLE);
                thirdColumn.setVisibility(View.VISIBLE);

                break;
        }

        this.getNextQuestion();
    }

    public void backToMenu(View view) {
        finish();
    }

    public void country1Chosen(View view) {
        this.checkAnswer(1);
    }

    public void country2Chosen(View view) {
        this.checkAnswer(2);
    }

    public void country3Chosen(View view) {
        this.checkAnswer(3);
    }

    public void country4Chosen(View view) {
        this.checkAnswer(4);
    }

    public void country5Chosen(View view) {
        this.checkAnswer(5);
    }

    public void country6Chosen(View view) {
        this.checkAnswer(6);
    }

    public void country7Chosen(View view) {
        this.checkAnswer(7);
    }

    public void country8Chosen(View view) {
        this.checkAnswer(8);
    }

    public void country9Chosen(View view) {
        this.checkAnswer(9);
    }

    private Pair<Drawable, String> getRandomCountry()
            throws IOException {
        int regionsNumber = ThreadLocalRandom.current().nextInt(0, this.regions.size());
        String regionName = this.regions.get(regionsNumber);

        List<Country> countries = this.countryService.getByRegion(regionName);

        int countriesNumber = ThreadLocalRandom.current().nextInt(0, countries.size());
        Country country = countries.get(countriesNumber);

        InputStream fstream = getAssets().open("flags/" + country.getImagePath());
        Drawable flag = Drawable.createFromStream(fstream, null);

        return new Pair<Drawable, String>(flag, country.getName());
    }

    private List<String> getAnswers()
    {
        List<String> answers = new ArrayList<>();

        List<Country> countries = this.countryService.getAll();

        for (int i = 0; i < this.answersAmount - 1; i++)
        {
            int countriesNumber;
            String countryName;
            do {
                countriesNumber = ThreadLocalRandom.current().nextInt(0, countries.size());
                countryName = countries.get(countriesNumber).getName();
            } while (answers.contains(countryName) || countryName.equals(this.countryCorrectName));

            answers.add(countryName);
        }

        return  answers;
    }

    private void checkAnswer(int buttonNumber)
    {
        String buttonID = "country" + buttonNumber;
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        Button answerButton = findViewById(resID);

        if (this.checkIfAnswerCorrect(answerButton))
        {
            answerButton.setTextColor(Color.parseColor("#9CCC65"));

            this.questionNumber++;

            if (this.questionNumber <= this.questionsAmount)
            {
                this.resetButtons();
                this.getNextQuestion();
            }
            else
            {
                this.endQuiz();
                this.attemptsCounter++;
            }
        }
        else
        {
            Animation shaking = AnimationUtils.loadAnimation(this, R.anim.shaking);

            ImageView flag = findViewById(R.id.flag);
            flag.startAnimation(shaking);

            answerButton.setTextColor(Color.parseColor("#EF5350"));
            answerButton.setEnabled(false);
        }

        this.attemptsCounter++;
    }

    private boolean checkIfAnswerCorrect(Button answerButton)
    {
        String answer = String.valueOf(answerButton.getText());

        return answer.equals(this.countryCorrectName);
    }

    private void getNextQuestion()
    {
        TextView question = (TextView) findViewById(R.id.question);
        question.setText("Question " + this.questionNumber + "/" + this.questionsAmount);

        Pair<Drawable, String> country = null;
        try {
            country = this.getRandomCountry();
        } catch (IOException e) {
            e.printStackTrace();
            finish();
            System.exit(0);
        }

        this.countryCorrectName = country.second;

        ImageView flag = findViewById(R.id.flag);
        flag.setBackground(country.first);

        int correctAnswerNumber = ThreadLocalRandom.current().nextInt(1, this.answersAmount + 1);
        String correctAnswerButtonID = "country" + correctAnswerNumber;
        int correctAnswerResID = getResources().getIdentifier(correctAnswerButtonID, "id", getPackageName());
        Button correctAnswerButton = findViewById(correctAnswerResID);
        correctAnswerButton.setText(this.countryCorrectName);

        int it = 0;
        List<String> wrongAnswers = this.getAnswers();
        for (int i = 1; i < answersAmount + 1; i++)
        {
            String buttonID = "country" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            Button answerButton = findViewById(resID);

            if (answerButton.getText().equals(""))
            {
                answerButton.setText(wrongAnswers.get(it));
                it++;
            }
        }
    }

    private void resetButtons()
    {
        for (int i = 1; i < this.answersAmount + 1; i++)
        {
            String buttonID = "country" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            Button answerButton = findViewById(resID);

            answerButton.setText("");
            answerButton.setTextColor(Color.parseColor("#000000"));
            answerButton.setEnabled(true);
        }
    }

    private void endQuiz()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        builder.setTitle("Quiz finished")
                .setMessage(
                        "Here is the statistics for this game. Questions: " + this.questionsAmount +
                                ". Attempts: " + this.attemptsCounter +
                                ". Rate: " + (int)((((double)this.questionsAmount / this.attemptsCounter)) * 100) + "%")
                .setCancelable(false)
                .setNegativeButton("OK",
                        (dialog, id) -> {
                            dialog.cancel();
                            finish();
                        });

        Statistics statistics = new Statistics(new Date(), this.questionsAmount, this.attemptsCounter);
        SugarRecord.save(statistics);

        AlertDialog alert = builder.create();
        alert.show();
    }
}
