import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by SuryaRajasekaran on 11/12/17.
 */
public class UI {

    ArrayList<String> mainCategories;
    ArrayList<String> selectedMainCategories;
    ArrayList<String> selectedSubCategories;
    ArrayList<String> selectedAttributes;
    JPanel mainCategoriesJP;
    JPanel subCategoriesJP;
    JPanel attributesJP;

    public UI() {
        this.mainCategories = getMainCategories();
        this.mainCategoriesJP = new JPanel();
        this.subCategoriesJP = new JPanel();
        this.attributesJP = new JPanel();
        this.selectedMainCategories = new ArrayList<String>();
        this.selectedSubCategories = new ArrayList<String>();
        this.selectedAttributes = new ArrayList<String>();
    }

    public Connection getDBConnection(){
        DBConnector dbConnector = new DBConnector("jdbc:oracle:thin:hr/hr@localhost:1521:orcl", "hr","hr");
        Connection connection = dbConnector.getConnection();
        return connection;
    }

    public ArrayList<String> getMainCategories(){
        DBReaderBusinessMainCategories dbReaderBusinessMainCategories = new DBReaderBusinessMainCategories(this.getDBConnection());
        ArrayList<String> mainCategories = dbReaderBusinessMainCategories.getMainCategories();
        return mainCategories;
    }

    public ArrayList<String> getSubCategories(){
        return null;
    }

    public void createAndShowGUI() {
        // create and set up the window.
        JFrame frame = new JFrame("Yelp Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500,200));

        // add panel for display
        JPanel display = new JPanel();
        display.setLayout(new BoxLayout(display, BoxLayout.X_AXIS));

        // add panel for main categories
        display.add(new JScrollPane(mainCategoriesJP));

        // add panel for sub categories
        display.add(new JScrollPane(subCategoriesJP));

        // add panel for attributes categories
        display.add(new JScrollPane(attributesJP));

        // load data
        loadData();

        frame.add(display);
        // show the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void loadData(){
        this.mainCategoriesJP.validate();
        this.mainCategoriesJP.repaint();
        this.mainCategoriesJP.setLayout(new BoxLayout(this.mainCategoriesJP, BoxLayout.Y_AXIS));
        JLabel mainCategoriesJLabel = new JLabel("Main Categories");
        this.mainCategoriesJP.add(mainCategoriesJLabel);
        /*

        this.attributesJP.setLayout(new BoxLayout(this.attributesJP, BoxLayout.Y_AXIS));
        JLabel attributesJLabel = new JLabel("Attributes");
        this.attributesJP.add(attributesJLabel);*/

        for(int i = 0; i < this.mainCategories.size(); i++) {
            JCheckBox jCheckBox = new JCheckBox(this.mainCategories.get(i));
            jCheckBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (jCheckBox.isSelected()){
                        System.out.println("selected "+jCheckBox.getText());
                        selectedMainCategories.add(jCheckBox.getText());
                        loadSubCategories();
                    } else {
                        System.out.println("unselected "+jCheckBox.getText());
                        selectedMainCategories.remove(jCheckBox.getText());
                        loadSubCategories();
                    }
                }
            });
            this.mainCategoriesJP.add(jCheckBox);
        }
    }

    public void loadSubCategories(){
        this.subCategoriesJP.removeAll();
        this.subCategoriesJP.setLayout(new BoxLayout(this.subCategoriesJP, BoxLayout.Y_AXIS));
        JLabel subCategoriesJLabel = new JLabel("Sub Categories");
        this.subCategoriesJP.add(subCategoriesJLabel);
        for(int i = 0; i < this.selectedMainCategories.size(); i++) {
            JCheckBox jCheckBox = new JCheckBox(this.selectedMainCategories.get(i));
            jCheckBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (jCheckBox.isSelected()){
                        System.out.println("selected "+jCheckBox.getText());
                        //selectedMainCategories.add(jCheckBox.getText());
                        //loadSubCategories();
                    } else {
                        System.out.println("unselected "+jCheckBox.getText());
                        //selectedMainCategories.remove(jCheckBox.getText());
                        //loadSubCategories();
                    }
                }
            });
            this.subCategoriesJP.add(jCheckBox);
        }
        this.subCategoriesJP.validate();
        this.subCategoriesJP.repaint();
    }

    public void loadAttributes(){
        this.attributesJP.validate();
        this.attributesJP.repaint();
    }
}
