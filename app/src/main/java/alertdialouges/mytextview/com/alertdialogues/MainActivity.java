package alertdialouges.mytextview.com.alertdialogues;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button showDialogue;
    private AlertDialog.Builder dialogue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogue = (Button) findViewById(R.id.button);

        showDialogue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //show our AlertDialogue
                dialogue = new AlertDialog.Builder(MainActivity.this);

                //set Title
                dialogue.setTitle(getResources().getString(R.string.dialogue_title));

                //set Message
                dialogue.setMessage(getResources().getString(R.string.dialogue_Message));

                //set Cancelable. Means if you click outside of the dialog then it will not cancel if you pass false below.
                dialogue.setCancelable(true);

                //set Icon
                dialogue.setIcon(android.R.drawable.sym_action_call);

                //set Positive button
                dialogue.setPositiveButton(getResources().getString(R.string.positive_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                MainActivity.this.finish();
                            }
                        });

                //set Negative Button
                dialogue.setNegativeButton(getResources().getString(R.string.negative_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });



                //create dialog

                AlertDialog alertD = dialogue.create();

                //show dialog
                alertD.show();
            }
        });
    }
}
