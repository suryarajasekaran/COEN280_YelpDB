package ui;

import db.DBReader;
import helper.Helper;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    String selectedSearchFor;
    Boolean isSelectedLocation;
    String selectedLocation;
    Boolean isSelectedDay;
    String selectedDay;
    Boolean isSelectedFrom;
    String selectedFrom;
    Boolean isSelectedTo;
    String selectedTo;
    ArrayList<String> selectedMainCategories;
    ArrayList<String> selectedSubCategories;
    ArrayList<String> selectedAttributes;

    JPanel mainCategoriesJP;
    JPanel subCategoriesJP;
    JPanel attributesJP;
    JPanel outputJP;
    JComboBox locationCB;
    JComboBox dayCB;
    JComboBox fromCB;
    JComboBox toCB;
    String[] searchForOptions;
    JComboBox searchForCB;
    JButton searchB;

    public UI() {
        this.mainCategories = getMainCategories();
        this.subCategories = null;
        this.selectedSearchFor = "OR";
        this.searchForOptions = new String[] {"OR", "AND"};

        this.mainCategoriesJP = new JPanel();
        this.subCategoriesJP = new JPanel();
        this.attributesJP = new JPanel();
        this.outputJP = new JPanel();
        this.locationCB = new JComboBox();
        this.dayCB = new JComboBox();
        this.fromCB = new JComboBox();
        this.toCB = new JComboBox();
        this.searchForCB = new JComboBox();
        this.searchB = new JButton();

        this.isSelectedLocation = Boolean.FALSE;
        this.isSelectedDay = Boolean.FALSE;
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
        ArrayList<String> subCategories = dbReader.getSubCategories(this.selectedMainCategories, this.selectedSearchFor);
        return subCategories;
    }

    public ArrayList<String> getAttributes() {
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<String> attributes = dbReader.getAttributes(this.selectedMainCategories, this.selectedSubCategories, this.selectedSearchFor);
        return attributes;
    }

    public ArrayList<String> getLocation() {
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<String> location = dbReader.getLocation(this.selectedMainCategories, this.selectedSubCategories, this.selectedAttributes, this.selectedSearchFor);
        return location;
    }

    public ArrayList<String> getDay() {
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<String> day = dbReader.getDay(this.selectedMainCategories, this.selectedSubCategories, this.selectedAttributes, this.selectedLocation, this.selectedSearchFor);
        return day;
    }

    public ArrayList<String> getFrom() {
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<String> from = dbReader.getFrom(this.selectedMainCategories, this.selectedSubCategories, this.selectedAttributes, this.selectedLocation, this.selectedDay, this.selectedSearchFor);
        return from;
    }

    public ArrayList<String> getTo() {
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<String> to = dbReader.getTo(this.selectedMainCategories, this.selectedSubCategories, this.selectedAttributes, this.selectedLocation, this.selectedDay, this.selectedFrom, this.selectedSearchFor);
        return to;
    }

    public String[][] getSearch() {
        DBReader dbReader = new DBReader(Helper.getDBConnection());
        ArrayList<ArrayList<String>> search = dbReader.getSearch(this.selectedMainCategories, this.selectedSubCategories, this.selectedAttributes, this.selectedLocation, this.selectedDay, this.selectedFrom, this.selectedTo, this.selectedSearchFor);
        String[][] array = new String[search.size()][];
        for (int i = 0; i < search.size(); i++) {
            ArrayList<String> row = search.get(i);
            array[i] = row.toArray(new String[row.size()]);
        }
        return array;
    }

    public void createAndShowGUI() {
        // create and set up the window.
        JFrame frame = new JFrame("Yelp Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500,1000));

        // add main panel
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

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

        // add panel for controls
        JPanel controls = new JPanel();
        controls.setLayout(new BoxLayout(controls, BoxLayout.X_AXIS));

        // add combobox for controls
        locationCB = new JComboBox(this.getLocation().toArray());
        locationCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedLocation = locationCB.getSelectedItem().toString();
                // load days
            }
        });
        controls.add(locationCB);

        dayCB = new JComboBox(this.getDay().toArray());
        dayCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDay = dayCB.getSelectedItem().toString();
            }
        });
        controls.add(dayCB);

        fromCB = new JComboBox(this.getFrom().toArray());
        fromCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFrom = fromCB.getSelectedItem().toString();
            }
        });
        controls.add(fromCB);

        toCB = new JComboBox(this.getTo().toArray());
        toCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTo = toCB.getSelectedItem().toString();
            }
        });
        controls.add(toCB);

        searchForCB = new JComboBox<>(this.searchForOptions);
        searchForCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSearchFor = searchForCB.getSelectedItem().toString();
                loadSubCategories();
                loadLocation();
                loadDay();
                loadFrom();
                loadTo();
            }
        });
        controls.add(searchForCB);

        // add button for search
        searchB.setText("search");
        searchB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSearch();
            }
        });
        controls.add(searchB);

        // add display into main
        main.add(display);
        main.add(controls);

        frame.add(main);
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
                        loadLocation();
                        loadDay();
                        loadFrom();
                        loadTo();
                    } else {
                        System.out.println("unselected "+jCheckBox.getText());
                        selectedMainCategories.remove(jCheckBox.getText());
                        loadSubCategories();
                        loadLocation();
                        loadDay();
                        loadFrom();
                        loadTo();
                    }
                }
            });
            this.mainCategoriesJP.add(jCheckBox);
        }
    }

    public void loadSubCategories(){
        this.attributesJP.removeAll();
        this.attributesJP.validate();
        this.attributesJP.repaint();

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
                            loadLocation();
                            loadDay();
                            loadFrom();
                            loadTo();
                        } else {
                            System.out.println("unselected "+jCheckBox.getText());
                            selectedSubCategories.remove(jCheckBox.getText());
                            loadAttributes();
                            loadLocation();
                            loadDay();
                            loadFrom();
                            loadTo();
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
        if (this.selectedSubCategories.size() !=0) {
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
                                loadLocation();
                                loadDay();
                                loadFrom();
                                loadTo();
                                //loadAttributes();
                            } else {
                                System.out.println("unselected "+jCheckBox.getText());
                                selectedAttributes.remove(jCheckBox.getText());
                                loadLocation();
                                loadDay();
                                loadFrom();
                                loadTo();
                                //loadAttributes();
                            }
                        }
                    });
                    this.attributesJP.add(jCheckBox);
                }
            }
        }
        this.attributesJP.validate();
        this.attributesJP.repaint();
    }

    public void loadLocation() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(this.getLocation().toArray());
        this.locationCB.setModel(model);
    }

    public void loadDay() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(this.getDay().toArray());
        this.dayCB.setModel(model);
    }

    public void loadFrom() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(this.getFrom().toArray());
        this.fromCB.setModel(model);
    }

    public void loadTo() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(this.getTo().toArray());
        this.toCB.setModel(model);
    }

    public void loadSearch() {
        String[][] arrays = this.getSearch();
        JLabel tableJLabel = new JLabel("Search Results");
        String[] columns = new String[] {
                "BId", "Name", "Address", "City", "State", "Stars", "ReviewCount", "CheckinCount"
        };
        JTable table = new JTable(arrays, columns);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                popupReviews(table.getValueAt(table.getSelectedRow(), 0).toString());
                System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
        });
        this.outputJP.removeAll();
        this.outputJP.setLayout(new BoxLayout(this.outputJP, BoxLayout.Y_AXIS));
        this.outputJP.add(tableJLabel);
        this.outputJP.add(new JScrollPane(table));
        this.outputJP.validate();
        this.outputJP.repaint();
    }

    public void popupReviews(String BId) {
        //headers for the table
        String[] columns = new String[] {
                "Date", "Stars", "Text", "UserId", "UserName"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
        };
        //create table with data
        JTable table = new JTable(data, columns);

        //create the pop-up
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frameReviews = new JFrame("Reviews");
                frameReviews.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameReviews.setPreferredSize(new Dimension(1500,1000));
                frameReviews.add(new JScrollPane(table));
                // show the window.
                frameReviews.pack();
                frameReviews.setVisible(true);
                frameReviews.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

    }
}
