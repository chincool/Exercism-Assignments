import java.util.HashMap;
import java.util.Map;

class RnaTranscription {

    String transcribe(String dnaStrand) {
        if(dnaStrand.equals(""))
            return "";
        HashMap<Character,Character> hmap = new HashMap<Character,Character>();
        hmap.put('G','C');
        hmap.put('C','G');
        hmap.put('T','A');
        hmap.put('A','U');
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < dnaStrand.length(); ++i)
        {
            res.append(hmap.get(dnaStrand.charAt(i)));
        }
        return res.toString();
    }

}
