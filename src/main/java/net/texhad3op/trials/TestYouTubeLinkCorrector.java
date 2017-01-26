package net.texhad3op.trials;

/**
 * Created by jurij on 1/20/17.
 */
public class TestYouTubeLinkCorrector {
    public static void main(String[] args) {
        //    kkkkkkkkk
        //    https://www.youtube.com/watch?v=QsATZV8PAho
        //    https://youtu.be/CwB0F9DiQPU
        //    https://www.youtube.com/embed/QsATZV8PAho


        String url = "https://kkkkkkkkkkkkkk";
        //System.out.println(YouTubeLinkCorrector.correctYouTubeLink(url));
        System.out.println(YouTubeLinkCorrector.correctLink(url));
    }
}
