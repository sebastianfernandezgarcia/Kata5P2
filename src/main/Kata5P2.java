
package main;

import view.HistogramDisplay;
import model.Mail;
import view.MailHistogramBuilder;
import view.MailHistogramReader;
import java.util.List;
import model.Histogram;


public class Kata5P2 {
        
    public static List<Mail> input() {
        String nameFile = new String("email.txt");
        List<Mail> mailList = MailHistogramReader.read(nameFile);
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
        Kata5P2 kata4 = new Kata5P2();
        kata4.execute();    
    }
    
}

