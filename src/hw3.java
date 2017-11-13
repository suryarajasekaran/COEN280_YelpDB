/**
 * Created by SuryaRajasekaran on 11/12/17.
 */
public class hw3 {

    public static void main(String[] args) {

        // start the GUI
        UI ui = new UI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ui.createAndShowGUI();
            }
        });
    }
}
