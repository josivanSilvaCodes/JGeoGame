import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("sound_hit.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("sound_gameover.wav"));
	public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("music_1.wav"));
}
