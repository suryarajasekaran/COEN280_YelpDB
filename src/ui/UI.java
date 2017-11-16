package ui;

import db.DBReader;
import helper.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by SuryaRajasekaran on 11/12/17.
 */
public class UI {

    ArrayList<String> mainCategories;
    ArrayList<String> subCategories;
    ArrayList<String> attributes;
    String searchFor;

    ArrayList<String> selectedMainCategories;
    ArrayList<String> selectedSubCategories;
    ArrayList<String> selectedAttributes;
    JPanel mainCategoriesJP;
    JPanel subCategoriesJP;
    JPanel attributesJP;
    JPanel outputJP;

    public UI() {
        this.mainCategories = getMainCategories();
        this.subCategories = null;
        this.searchFor = "AND";
        this.mainCategoriesJP = new JPanel();
        this.subCategoriesJP = new JPanel();
        this.attributesJP = new JPanel();
        this.selectedMainCategories = new ArrayList<String>();
        this.selectedSubCategories = new ArrayList<String>();
        this.selectedAttributes = new ArrayList<String>();
    }

    public ArrayList<String> getMainCategories(){
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<String> mainCategories = dbReader.getMainCategories();
        return mainCategories;
    }

    public ArrayList<String> getSubCategories(){
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<String> subCategories = dbReader.getSubCategories(this.selectedMainCategories, this.searchFor);
        return subCategories;
    }

    public ArrayList<String> getAttributes() {
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<String> attributes = dbReader.getAttributes(this.selectedMainCategories, this.selectedSubCategories, this.searchFor);
        return attributes;
    }

    public void createAndShowGUI() {
        // create and set up the window.
        JFrame frame = new JFrame("Yelp Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500,1000));

        // add main panel
        //JPanel main = new JPanel();
        //main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        // add panel for display
        JPanel display = new JPanel();
        display.setLayout(new BoxLayout(display, BoxLayout.X_AXIS));

        // add panel for main categories
        display.add(new JScrollPane(mainCategoriesJP));

        // add panel for sub categories
        display.add(new JScrollPane(subCategoriesJP));

        // add panel for attributes categories
        display.add(new JScrollPane(attributesJP));

        // add panel for attributes categories
        display.add(new JScrollPane(outputJP));

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
        this.subCategories = this.getSubCategories();
        if (this.subCategories != null){
            for(int i = 0; i < this.subCategories.size(); i++) {
                JCheckBox jCheckBox = new JCheckBox(this.subCategories.get(i));
                jCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (jCheckBox.isSelected()){
                            System.out.println("selected "+jCheckBox.getText());
                            selectedSubCategories.add(jCheckBox.getText());
                            loadAttributes();
                        } else {
                            System.out.println("unselected "+jCheckBox.getText());
                            selectedSubCategories.remove(jCheckBox.getText());
                            loadAttributes();
                        }
                    }
                });
                this.subCategoriesJP.add(jCheckBox);
            }
            this.subCategoriesJP.validate();
            this.subCategoriesJP.repaint();
            }
    }

    public void loadAttributes(){
        this.attributesJP.removeAll();
        this.attributesJP.setLayout(new BoxLayout(this.attributesJP, BoxLayout.Y_AXIS));
        JLabel attributesJLabel = new JLabel("Attributes");
        this.attributesJP.add(attributesJLabel);
        this.attributes = this.getAttributes();
        if (this.attributes != null){
            for(int i = 0; i < this.attributes.size(); i++) {
                JCheckBox jCheckBox = new JCheckBox(this.attributes.get(i));
                jCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (jCheckBox.isSelected()){
                            System.out.println("selected "+jCheckBox.getText());
                            selectedAttributes.add(jCheckBox.getText());
                            //loadAttributes();
                        } else {
                            System.out.println("unselected "+jCheckBox.getText());
                            selectedAttributes.remove(jCheckBox.getText());
                            //loadAttributes();
                        }
                    }
                });
                this.attributesJP.add(jCheckBox);
            }
            this.attributesJP.validate();
            this.attributesJP.repaint();
        }
    }
}
