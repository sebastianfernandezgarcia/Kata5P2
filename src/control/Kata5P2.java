
package control;

import view.HistogramDisplay;
import model.Mail;
import view.MailHistogramBuilder;
import view.MailHistogramReader;
import java.util.List;
import model.Histogram;


public class Kata5P2 {
    
        
    public static List<Mail> input() {
        String nameFile = new String("email.txt");
        view.MailListReaderBD listReader = new view.MailListReaderBD();
        List<Mail> mailList = listReader.read();
        return mailList;
    }
            
    public static Histogram<String> process(List<Mail> mailList){
            Histogram<String> histogram = MailHistogramBuilder.built(mailList);
            return histogram;
        }
        
  public static void output(Histogram<String> histogram) {
        HistogramDisplay histogramDisplay = new HistogramDisplay("HistogramDisplay", histogram);
        histogramDisplay.execute();
  }
      
  
  public static void execute() {
      List<Mail> mailList = input();
      Histogram<String> histogram = process(mailList);
      output(histogram);
  }
        
    public static void main(String[] args) {
        Kata5P2 kata5p2 = new Kata5P2();
        kata5p2.execute();    
    }
    
}

