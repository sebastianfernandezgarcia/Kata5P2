
package view;

import model.Histogram;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;
    
    
    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(this.createPanel());
        this.pack();
    }

       private JPanel createPanel() {
           ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
           return chartPanel;
           
       }
    
    private JFreeChart createChart(DefaultCategoryDataset createDataSet) {
        JFreeChart chart = ChartFactory.createBarChart( "Histogram",
                                                        "emails domain",
                                                        "number",
                                                        createDataSet,
                                                        PlotOrientation.VERTICAL,
                                                        false,
                                                        rootPaneCheckingEnabled,
                                                        rootPaneCheckingEnabled);
        return chart;
    }
    
     private DefaultCategoryDataset createDataSet(){
         DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
         
         for (String key : this.histogram.KeySet()) {
             dataSet.addValue(this.histogram.get(key), "", key);
         }

         
         return dataSet;
     }  
    public void execute() {
        this.setVisible(true);
    }

    
}
