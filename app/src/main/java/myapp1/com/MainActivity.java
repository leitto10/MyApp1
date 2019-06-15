package myapp1.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /* Toast Method*/
    public void toastMsg(String msg){
        // creating messages for ech button
        Toast d = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        d.show();
    }

    /* Method that call buttons messages*/
    public void displayToastMsgD(View view){
        toastMsg("Everything goes well so far.");
    }

    /* Called when the User taps the send button*/
    public void sendMessage(View view){
        // Do something in response to the button
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
        signIn();
    }

    public void displayMovies(View view) {
        Intent intent = new Intent(this, DisplayMoviesActivity.class);
        startActivity(intent);
    }

    public void displayCameras(View view){
        Intent intent = new Intent(this, DisplayCamerasActivity.class);
        startActivity(intent);

    }

    public void displayMaps(View view) {
        Intent intent = new Intent(this, DisplayMapsActivity.class);
        startActivity(intent);
    }

    private void signIn() {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword("hken920@gmail.com","apricot")
                .addOnCompleteListener(this, new
                        OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                Log.d("FIREBASE", "signIn:onComplete:" +
                                        task.isSuccessful());
                                if (task.isSuccessful()) {
                                    // update profile
                                    FirebaseUser user =
                                            FirebaseAuth.getInstance().getCurrentUser();
                                    UserProfileChangeRequest profileUpdates = new
                                            UserProfileChangeRequest.Builder()
                                            .setDisplayName("value")
                                            .build();
                                    user.updateProfile(profileUpdates)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull
                                                                               Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Log.d("FIREBASE", "User profile updated.");
                                                        // Go to FirebaseActivity
                                                        startActivity(new
                                                                Intent(MainActivity.this, TeamActivity.class));
                                                    }
                                                }
                                            });
                                } else {
                                    Log.d("FIREBASE", "sign-in failed");
                                    Toast.makeText(MainActivity.this, "Sign In Failed",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
    }





}
