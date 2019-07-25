package it.unibo.bmbman.view;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.bmbman.controller.MainMenuController;
import it.unibo.bmbman.controller.MainMenuControllerImpl;
import it.unibo.bmbman.controller.MainMenuOption;
/**
 * define the start menu of the game.
 *
 */
public class MainMenuView extends AbstractFrame {
    private static final long serialVersionUID = -1620326564341277553L;
    private Map<JButton, MainMenuOption> jbMap = new HashMap<>();
    //per risolvere il bug dovrei aggiungere transiente nella dichiarazione
    //ma non capendo il perchè per ora non l'ho messo
    private MainMenuController mainMenuController = new MainMenuControllerImpl();
    /*DA SISTEMARE DA QUI IN POI MA NON CAMBIARE LA STRUTTURA!!*/
    private JPanel p = new JPanel();
    /**
     * paolo devi scrivere la javadoc.
     */
    public MainMenuView() {
        super();
        super.getContentPane().add(p);
    }
    /**
     * .
     */
    public void loadMainMenuView() {
        p.setLayout(new FlowLayout());
        for (int i = 0; i < 4; i++) {
            JButton b = new JButton(MainMenuOption.values()[i].toString());
            b.addActionListener(e -> {
                JButton jb = (JButton) e.getSource();
                mainMenuController.setOptionSelected(jbMap.get(jb));
                this.setVisible(false);
            });
            p.add(b);
            jbMap.put(b, MainMenuOption.values()[i]);
        }

        this.getContentPane().add(p);
        this.setVisible(true);
    }
}
