package candc.lib;

import com.sun.speech.freetts.*;

public class Speak {
    private static Voice voice;
    public static void toSpeech(String text) {
        System.out.println(text);

        VoiceManager vm = VoiceManager.getInstance();
        Voice voice = vm.getVoice("kevin16");
        voice.allocate();

        voice.speak(text);

    }
}
