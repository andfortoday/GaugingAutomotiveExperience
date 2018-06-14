package com.zippitybippity.kevinski.gaugingautomotiveexperience;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    int totalScore = 0;
    boolean quizSubmitted = false;
    static final String TOTAL_SCORE="totalScore";
    static final String QUIZ_SUBMITTED="quizSubmitted";

//q02 vars
    CheckBox chkSequential;
    CheckBox chkWhoCares;
    CheckBox chkStar;
    CheckBox chkInAir;
    CheckBox chkOnGround;
    CheckBox chkPartOnGround;
    EditText Q01_OilTemp;
    static final String CHK_SEQUENTIAL = "chkSequential";
    static final String CHK_WHO_CARES = "chkWhoCares";
    static final String CHK_STAR = "chkStar";
    static final String CHK_IN_AIR = "chkInAir";
    static final String CHK_ON_GROUND = "ChkOnGround";
    static final String CHK_PART_ON_GROUND = "chkPartOnGround";
    static final String Q01_OIL_TEMP = "Q01_OilTemp";

    //q03 vars
    CheckBox chkReuse;
    CheckBox chkHandTight;
    CheckBox chkTorque;
    CheckBox chkNew;
    CheckBox chkTightsTight;
    CheckBox chkRatatat;
    static final String CHK_REUSE = "chkReuse";
    static final String CHK_HAND_TIGHT = "chkHandTight";
    static final String CHK_TORQUE = "chkTorque";
    static final String CHK_NEW = "chkNew";
    static final String CHK_TIGHTS_TIGHT = "chkTightsTight";
    static final String CHK_RATATAT = "chkRatatat";

//q04 vars
    RadioButton rRR;
    RadioButton rRL;
    RadioButton rLL;
    RadioButton rLR;
    static final String R_RR ="rRR";
    static final String R_RL ="rRL";
    static final String R_LL ="rLL";
    static final String R_LR ="rLR";

    Button btnResetAll;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      hide keyboard on start because first input is edit text
//      https://stackoverflow.com/questions/18977187/how-to-hide-soft-keyboard-when-activity-starts/25786660#25786660
        getResIDs();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(TOTAL_SCORE,totalScore);
        savedInstanceState.putBoolean(QUIZ_SUBMITTED, quizSubmitted);
        boolean isItChecked = chkSequential.isChecked();
        savedInstanceState.putBoolean(CHK_SEQUENTIAL,chkSequential.isChecked());
        savedInstanceState.putBoolean(CHK_WHO_CARES,chkWhoCares.isChecked());
        savedInstanceState.putBoolean(CHK_STAR, chkStar.isChecked());
        savedInstanceState.putBoolean(CHK_IN_AIR, chkInAir.isChecked());
        savedInstanceState.putBoolean(CHK_ON_GROUND, chkOnGround.isChecked());
        savedInstanceState.putBoolean(CHK_PART_ON_GROUND, chkPartOnGround.isChecked());
        savedInstanceState.putString(Q01_OIL_TEMP, Q01_OilTemp.getText().toString());
        savedInstanceState.putBoolean(CHK_REUSE, chkReuse.isChecked());
        savedInstanceState.putBoolean(CHK_HAND_TIGHT, chkHandTight.isChecked());
        savedInstanceState.putBoolean(CHK_TORQUE, chkTorque.isChecked());
        savedInstanceState.putBoolean(CHK_NEW, chkNew.isChecked());
        savedInstanceState.putBoolean(CHK_TIGHTS_TIGHT, chkTightsTight.isChecked());
        savedInstanceState.putBoolean(CHK_RATATAT, chkRatatat.isChecked());
        savedInstanceState.putBoolean(R_RR, rRR.isChecked());
        savedInstanceState.putBoolean(R_RL, rRL.isChecked());
        savedInstanceState.putBoolean(R_LL, rLL.isChecked());
        savedInstanceState.putBoolean(R_LR, rLR.isChecked());
        //    static final String BTN_RESET_ALL ="btnResetAll"; no need - doesn't change state

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        
        totalScore = savedInstanceState.getInt(TOTAL_SCORE);
        quizSubmitted = savedInstanceState.getBoolean(QUIZ_SUBMITTED);
        chkSequential.setChecked(savedInstanceState.getBoolean(CHK_SEQUENTIAL));
        chkWhoCares.setChecked(savedInstanceState.getBoolean(CHK_WHO_CARES));
        chkStar.setChecked(savedInstanceState.getBoolean(CHK_STAR));
        chkInAir.setChecked(savedInstanceState.getBoolean(CHK_IN_AIR));
        chkOnGround.setChecked(savedInstanceState.getBoolean(CHK_ON_GROUND));
        chkPartOnGround.setChecked(savedInstanceState.getBoolean(CHK_PART_ON_GROUND));
        Q01_OilTemp.setText(savedInstanceState.getString(Q01_OIL_TEMP));
        chkReuse.setChecked(savedInstanceState.getBoolean(CHK_REUSE));
        chkReuse.setChecked(savedInstanceState.getBoolean(CHK_HAND_TIGHT));
        chkTorque.setChecked(savedInstanceState.getBoolean(CHK_TORQUE));
        chkNew.setChecked(savedInstanceState.getBoolean(CHK_NEW));
        chkTightsTight.setChecked(savedInstanceState.getBoolean(CHK_TIGHTS_TIGHT));
        chkRatatat.setChecked(savedInstanceState.getBoolean(CHK_RATATAT));
        rRR.setChecked(savedInstanceState.getBoolean(R_RR));
        rRL.setChecked(savedInstanceState.getBoolean(R_RL));
        rLL.setChecked(savedInstanceState.getBoolean(R_LL));
        rLR.setChecked(savedInstanceState.getBoolean(R_LR));
//        //    static final String BTN_RESET_ALL ="btnResetAll"; no need - doesn't change state

    }

//
//          try to make public variables that can pass the id instead of having to instantiate them in all the methods???????
//

//
// this is just a straight up copy paste so i can align the radio buttons like i want them. time is of the essence.
// https://stackoverflow.com/a/28562194/9619212

    private RadioButton checkedRadioButton;

    // OnClick listener for Radio Buttons
    public void onClickRadio(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (checkedRadioButton != null) {
            checkedRadioButton.setChecked(false);
        }
        radioButton.setChecked(true);
        checkedRadioButton = radioButton;
    }
    // Get the Active radio button ID
//    private int getCheckedRadioButtonId() {
//        if (checkedRadioButton != null) {
//            return checkedRadioButton.getId();
//        }
//        return 0;
//    }
// end straight up copy paste

    private void getResIDs() {
//        chkSequential = (CheckBox) findViewById(R.id.q02_CB1Sequential);
//        chkWhoCares = (CheckBox) findViewById(R.id.q02_CB2WhoCares);
//        chkStar = (CheckBox) findViewById(R.id.q02_CB3StarPattern);
//        chkInAir = (CheckBox) findViewById(R.id.q02_CB4InAir);
//        chkOnGround = (CheckBox) findViewById(R.id.q02_CB5OnGround);
//        chkPartOnGround = (CheckBox) findViewById(R.id.q02_CB6PartOnGround);
//        Q01_OilTemp = (EditText) findViewById(R.id.q01_ETAnswer);
//
//        chkReuse = (CheckBox) findViewById(R.id.q03_CB1Re_use);
//        chkHandTight = (CheckBox) findViewById(R.id.q03_CB2HandTight);
//        chkTorque = (CheckBox) findViewById(R.id.q03_CB3Torque);
//        chkNew = (CheckBox) findViewById(R.id.q03_CB4New);
//        chkTightsTight = (CheckBox) findViewById(R.id.q03_CB5TightsTight);
//        chkRatatat = (CheckBox) findViewById(R.id.q03_CB6Ratatat);
//
//        rRR = (RadioButton) findViewById(R.id.q04_RB1RR);
//        rRL = (RadioButton) findViewById(R.id.q04_RB2RL);
//        rLL = (RadioButton) findViewById(R.id.q04_RB3LL);
//        rLR = (RadioButton) findViewById(R.id.q04_RB4LR);
//
//        btnResetAll = (Button) findViewById(R.id.btnResetAll);
// it says all those ^^^^ are redundant....so
        chkSequential = findViewById(R.id.q02_CB1Sequential);
        chkWhoCares = findViewById(R.id.q02_CB2WhoCares);
        chkStar = findViewById(R.id.q02_CB3StarPattern);
        chkInAir = findViewById(R.id.q02_CB4InAir);
        chkOnGround = findViewById(R.id.q02_CB5OnGround);
        chkPartOnGround = findViewById(R.id.q02_CB6PartOnGround);
        Q01_OilTemp = (EditText) findViewById(R.id.q01_ETAnswer);

        chkReuse = findViewById(R.id.q03_CB1Re_use);
        chkHandTight = findViewById(R.id.q03_CB2HandTight);
        chkTorque = findViewById(R.id.q03_CB3Torque);
        chkNew = findViewById(R.id.q03_CB4New);
        chkTightsTight = findViewById(R.id.q03_CB5TightsTight);
        chkRatatat = findViewById(R.id.q03_CB6Ratatat);

        rRR = findViewById(R.id.q04_RB1RR);
        rRL = findViewById(R.id.q04_RB2RL);
        rLL = findViewById(R.id.q04_RB3LL);
        rLR = findViewById(R.id.q04_RB4LR);

        btnResetAll = findViewById(R.id.btnResetAll);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    private void q01_AnalyzeText(String theText) {
//        Log.i("MainActivity.java", theText);
        if (theText.equals(getText(R.string.q01_jCold))) {
            totalScore += 0;
        } else if (theText.equals(getText(R.string.q01_jWarm))) {
            totalScore += 0;
        } else if (theText.equals(getText(R.string.q01_jHot))) {
            totalScore += 1;
        }
    }

    private int q02_HowManyChecked() {
        int howManyChecked = 0;
        if (chkSequential.isChecked()) {
            howManyChecked += 1;
        }
        if (chkWhoCares.isChecked()) {
            howManyChecked += 1;
        }
        if (chkStar.isChecked()) {
            howManyChecked += 1;
        }
        if (chkInAir.isChecked()) {
            howManyChecked += 1;
        }
        if (chkOnGround.isChecked()) {
            howManyChecked += 1;
        }
        if (chkPartOnGround.isChecked()) {
            howManyChecked += 1;
        }
        return howManyChecked;
    }

    private void q02_WheelPatternCheckChecks() {
//        CheckBox chkSequential = (CheckBox) findViewById(R.id.q02_CB1Sequential);
//        CheckBox chkWhoCares = (CheckBox) findViewById(R.id.q02_CB2WhoCares);
//        CheckBox chkStar = (CheckBox) findViewById(R.id.q02_CB3StarPattern);
//        CheckBox chkInAir = (CheckBox) findViewById(R.id.q02_CB4InAir);
//        CheckBox chkOnGround = (CheckBox) findViewById(R.id.q02_CB5OnGround);
//        CheckBox chkPartOnGround = (CheckBox) findViewById(R.id.q02_CB6PartOnGround);

        if (!chkSequential.isChecked() && !chkWhoCares.isChecked() && chkStar.isChecked() && !chkInAir.isChecked() && !chkOnGround.isChecked() && chkPartOnGround.isChecked()) {
            totalScore += 1;
        } else {
            totalScore += 0;
        }
    }

    private void q02_Reset() {
        chkSequential.setChecked(false);
        chkWhoCares.setChecked(false);
        chkStar.setChecked(false);
        chkInAir.setChecked(false);
        chkOnGround.setChecked(false);
        chkPartOnGround.setChecked(false);
    }

    private int q03_HowManyChecked() {
        int howManyChecked = 0;
        if (chkReuse.isChecked()) {
            howManyChecked += 1;
        }
        if (chkHandTight.isChecked()) {
            howManyChecked += 1;
        }
        if (chkTorque.isChecked()) {
            howManyChecked += 1;
        }
        if (chkNew.isChecked()) {
            howManyChecked += 1;
        }
        if (chkTightsTight.isChecked()) {
            howManyChecked += 1;
        }
        if (chkRatatat.isChecked()) {
            howManyChecked += 1;
        }
        return howManyChecked;
    }

    private void q03_CrushWasherCheckChecks() {
//        CheckBox chkReuse = (CheckBox) findViewById(R.id.q03_CB1Re_use);
//        CheckBox chkHandTight = (CheckBox) findViewById(R.id.q03_CB2HandTight);
//        CheckBox chkTorque = (CheckBox) findViewById(R.id.q03_CB3Torque);
//        CheckBox chkNew = (CheckBox) findViewById(R.id.q03_CB4New);
//        CheckBox chkTightsTight = (CheckBox) findViewById(R.id.q03_CB5TightsTight);
//        CheckBox chkRatatat = (CheckBox) findViewById(R.id.q03_CB6Ratatat);

        if (!chkReuse.isChecked() && !chkHandTight.isChecked() && chkTorque.isChecked() && chkNew.isChecked() && !chkTightsTight.isChecked() && !chkRatatat.isChecked()) {
            totalScore += 1;
        } else {
            totalScore += 0;
        }
    }

    private void q03_Reset() {
        chkReuse.setChecked(false);
        chkHandTight.setChecked(false);
        chkTorque.setChecked(false);
        chkNew.setChecked(false);
        chkTightsTight.setChecked(false);
        chkRatatat.setChecked(false);
    }

    private void q04_DriftingRadioCheck() {

        if (!rRR.isChecked() && !rRL.isChecked() && !rLL.isChecked() && rLR.isChecked()) {
            totalScore += 1;
        } else {
            totalScore += 0;
        }
    }

    private void q04_Reset() {
        rRR.setChecked(false);
        rRL.setChecked(false);
        rLL.setChecked(false);
        rLR.setChecked(false);
    }

    public void submitAnswers(View view) {
        if (quizSubmitted == false) {
            int howMany = 0;
//            getResIDs();
//  begin q01
            String theText;
            theText = Q01_OilTemp.getText().toString().toLowerCase(); //equalsignorecase??
//        displayRealQuick.setText(theText);
            if (theText.equals(getText(R.string.q01_jCold)) || theText.equals(getText(R.string.q01_jWarm)) || theText.equals(getText(R.string.q01_jHot))) {
                q01_AnalyzeText(theText); // need to do error checking for incorrect input: ie fdsafasd instead of cold warm or hot
            } else {
                // some sort of error message, call to focus?
                resetAll(btnResetAll);
                Toast.makeText(this, R.string.q01_IncorrectToast, Toast.LENGTH_LONG).show();
                // Q01_OilTemp.setActivated(true);
                // Q01_OilTemp.setSelection(0, theText.length());
                // trying to pop keyboard back up:
                // https://stackoverflow.com/questions/2403632/android-show-soft-keyboard-automatically-when-focus-is-on-an-edittext/11155404#11155404?newreg=d9753f9fea294e1495f814e4f4b7cedf
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                return;
            }
//  end q01

// begin q02
            howMany = q02_HowManyChecked();
            if (howMany > 1 && howMany < 3) {
                q02_WheelPatternCheckChecks();
            } else {
                Toast.makeText(this, R.string.q02_IncorrectToast, Toast.LENGTH_LONG).show();
//            resetAll(btnResetAll);
                totalScore = 0;
                q02_Reset();
                return;
            }

// end q02

// begin q03
            howMany = q03_HowManyChecked();
            if (howMany > 1 && howMany < 3) {
                q03_CrushWasherCheckChecks();
            } else {
                Toast.makeText(this, R.string.q03_IncorrectToast, Toast.LENGTH_LONG).show();
                //resetAll(btnResetAll);
                totalScore = 0;
                q03_Reset();
                return;
            }

// end q03

// begin q04
            if (rRR.isChecked() || rRL.isChecked() || rLL.isChecked() || rLR.isChecked()) {
                q04_DriftingRadioCheck();
            } else {
                Toast.makeText(this, R.string.q04_IncorrectToast, Toast.LENGTH_LONG).show();
                //resetAll(btnResetAll);
                totalScore = 0;
                q04_Reset();
                return;
            }

// end q04

            Toast.makeText(this, getString(R.string.totalScore, totalScore), Toast.LENGTH_LONG).show();
            quizSubmitted = true;
            switchThoseViews();
        }
        /*
         * code for getting all resID's and just refer to them easier later....
         * attempt at changing the views out with the explanations for the answers
         * after changing each to explanation view, remove submit button and center reset button?
         *
         *
         */
//        Log.i(this.getLocalClassName(), Integer.toString(totalScore));

    }

    private void switchThoseViews() {
        /* http://abhiandroid.com/ui/viewswitcher */

        // get The references of Button and ViewSwitcher
//        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        ViewSwitcher simpleViewSwitcherq01 = (ViewSwitcher) findViewById(R.id.viewSwitchq01); // get the reference of ViewSwitcher q01
        ViewSwitcher simpleViewSwitcherq02 = (ViewSwitcher) findViewById(R.id.viewSwitchq02); // get the reference of ViewSwitcher q02
        ViewSwitcher simpleViewSwitcherq03 = (ViewSwitcher) findViewById(R.id.viewSwitchq03); // get the reference of ViewSwitcher q03
        ViewSwitcher simpleViewSwitcherq04 = (ViewSwitcher) findViewById(R.id.viewSwitchq04); // get the reference of ViewSwitcher q04

// Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

// set the animation type to ViewSwitcher
        simpleViewSwitcherq01.setInAnimation(in);
        simpleViewSwitcherq01.setOutAnimation(out);
        simpleViewSwitcherq01.showNext();

        simpleViewSwitcherq02.setInAnimation(in);
        simpleViewSwitcherq02.setOutAnimation(out);
        simpleViewSwitcherq02.showNext();

        simpleViewSwitcherq03.setInAnimation(in);
        simpleViewSwitcherq03.setOutAnimation(out);
        simpleViewSwitcherq03.showNext();

        simpleViewSwitcherq04.setInAnimation(in);
        simpleViewSwitcherq04.setOutAnimation(out);
        simpleViewSwitcherq04.showNext();

        //btnSubmit.setEnabled(false);
    }

    public void resetAll(View view) {
//        getResIDs();
        totalScore = 0;
//q01
        Q01_OilTemp.setText("");
//q02
        q02_Reset();
//        chkSequential.setChecked(false);
//        chkWhoCares.setChecked(false);
//        chkStar.setChecked(false);
//        chkInAir.setChecked(false);
//        chkOnGround.setChecked(false);
//        chkPartOnGround.setChecked(false);
//q03
        q03_Reset();
//        chkReuse.setChecked(false);
//        chkHandTight.setChecked(false);
//        chkTorque.setChecked(false);
//        chkNew.setChecked(false);
//        chkTightsTight.setChecked(false);
//        chkRatatat.setChecked(false);

//q04
        q04_Reset();
//        rRR.setChecked(false);
//        rRL.setChecked(false);
//        rLL.setChecked(false);
//        rLR.setChecked(false);
        if (quizSubmitted) {
            switchThoseViews();
        }
        quizSubmitted=false;
    }
}