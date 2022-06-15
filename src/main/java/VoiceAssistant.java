import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class VoiceAssistant {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("src/main/resources/4138.dic");
        configuration.setLanguageModelPath("src/main/resources/4138.lm");
        LiveSpeechRecognizer speechRecognizer = new LiveSpeechRecognizer(configuration);
        speechRecognizer.startRecognition(true);
        SpeechResult result = null;
        while ((result=speechRecognizer.getResult()) != null){
              String voicecommand = result.getHypothesis();
            System.out.println("voice command is " + voicecommand);
            if (voicecommand.equalsIgnoreCase("open chrome")){
                Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","start chrome google.com"});
            } else if (voicecommand.equalsIgnoreCase("close chrome")) {
                Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","taskkill /F /IM chrome.exe /T"});
            }
        }
    }
}
