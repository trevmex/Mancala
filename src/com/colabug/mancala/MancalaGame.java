package com.colabug.mancala;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MancalaGame extends Activity
{
    // Logging & helpful
    private final String TAG = MancalaGame.class.getSimpleName();

    // Player data
    private Player player1;
    private Player player2;

    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        // Initialize
        super.onCreate( savedInstanceState  );
        setContentView( R.layout.game_board );

        // Create players
        Log.d( TAG, "Creating players." );
        player1 = new Player( getIntent().getStringExtra( "player1" ),
                              PlayerType.PLAYER1 );
        player2 = new Player( getIntent().getStringExtra( "player2" ),
                              PlayerType.PLAYER2 );

        // Greet players
        TextView welcomeMessage = (TextView) findViewById( R.id.welcome_message );
        String message = getResources().getString( R.string.GAME_WELCOME_TEXT );
        message += " " + player1.getName() + " & " + player2.getName() + "!";
        welcomeMessage.setText(message);
    }

    public static Intent createIntent (Context context)
    {
        return new Intent( context, MancalaGame.class );
    }
}
