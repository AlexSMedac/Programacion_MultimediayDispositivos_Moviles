package T7.t1_sonidos;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private TextView tvCurrentTime, tvTotalTime;
    private Handler handler = new Handler();

    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reproductor de música
        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnPause = findViewById(R.id.btnPause);
        TextView tvSongTitle = findViewById(R.id.tvSongTitle);
        tvCurrentTime = findViewById(R.id.tvCurrentTime);
        tvTotalTime = findViewById(R.id.tvTotalTime);
        seekBar = findViewById(R.id.seekBar);

        mediaPlayer = MediaPlayer.create(this, R.raw.cancion);
        tvSongTitle.setText("Mi Canción");

        seekBar.setMax(mediaPlayer.getDuration());
        tvTotalTime.setText(formatTime(mediaPlayer.getDuration()));

        btnPlay.setOnClickListener(v -> {
            mediaPlayer.start();
            updateSeekBar();
        });

        btnPause.setOnClickListener(v -> mediaPlayer.pause());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                    tvCurrentTime.setText(formatTime(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // --- Configurar SoundPool ---
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(4)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(4, android.media.AudioManager.STREAM_MUSIC, 0);
        }

        // Cargar sonidos cortos desde res/raw
        sound1 = soundPool.load(this, R.raw.sonido1, 1);
        sound2 = soundPool.load(this, R.raw.sonido2, 1);
        sound3 = soundPool.load(this, R.raw.sonido3, 1);
        sound4 = soundPool.load(this, R.raw.sonido4, 1);

        // Botones de sonidos
        Button btnSound1 = findViewById(R.id.btnSound1);
        Button btnSound2 = findViewById(R.id.btnSound2);
        Button btnSound3 = findViewById(R.id.btnSound3);
        Button btnSound4 = findViewById(R.id.btnSound4);

        btnSound1.setOnClickListener(v -> soundPool.play(sound1, 1, 1, 0, 0, 1));
        btnSound2.setOnClickListener(v -> soundPool.play(sound2, 1, 1, 0, 0, 1));
        btnSound3.setOnClickListener(v -> soundPool.play(sound3, 1, 1, 0, 0, 1));
        btnSound4.setOnClickListener(v -> soundPool.play(sound4, 1, 1, 0, 0, 1));
    }

    private void updateSeekBar(){
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        tvCurrentTime.setText(formatTime(mediaPlayer.getCurrentPosition()));

        if(mediaPlayer.isPlaying()){
            handler.postDelayed(this::updateSeekBar, 1000);
        }
    }

    private String formatTime(int milliseconds){
        int minutes = milliseconds / 1000 / 60;
        int seconds = (milliseconds / 1000) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if(soundPool != null){
            soundPool.release();
            soundPool = null;
        }
    }
}
