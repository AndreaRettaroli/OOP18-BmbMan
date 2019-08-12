package it.unibo.bmbman.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import it.unibo.bmbman.model.utilities.ScoreHandler;
import it.unibo.bmbman.model.utilities.ScoreTable;
import it.unibo.bmbman.view.utilities.GameFont;
/**
 * 
 * Class used to display Leaderboard.
 *
 */
public class LeaderboardView extends JTable {
    private final transient MainMenuView mainMenuView;
    private static final long serialVersionUID = 1L;
    private final JFrame frame;
    private JPanel northP;
    private JPanel southP;
    private final transient GUIFactory gf;
    private static final Float SIZE = 20f;
    private static final int ROW_HEIGHT = 40;
    private static final int BORDER_THICKNESS = 5;
    private static final int HEIGHT_DISTANCE = 230;
    private static final int WIDTH_DISTANCE = 100;
    /**
     * Create LeaderboardView.
     * @param mainMenuView the actual {@link MainMenuView}
     */
    public LeaderboardView(final MainMenuView mainMenuView) {
        super();
        this.mainMenuView = mainMenuView;
        this.gf = new MyGUIFactory(); 
        this.frame = this.gf.createFrame();
        this.loadLeaderboardView();
    }

    private void loadLeaderboardView() {
        final GameFont font = new GameFont();
        this.northP = new JPanel();
        this.southP = new JPanel();
        this.frame.add(northP, BorderLayout.NORTH);
        this.frame.add(southP, BorderLayout.CENTER);
        this.southP.setBackground(Color.BLACK);
        this.northP.setBackground(Color.BLACK);
        final JLabel label = gf.createLabel("LEADERBOARD");
        this.northP.add(label);
        final TableModel tm = new ScoreTable(ScoreHandler.getData());
        final JTable t = new JTable(tm);
        southP.add(t);
        t.getTableHeader().setFont(font.getFont());
        t.getTableHeader().setBackground(Color.BLACK);
        t.getTableHeader().setForeground(Color.white);
        t.getTableHeader().setReorderingAllowed(false);
        t.getTableHeader().setResizingAllowed(false);
        GameFont.setFontSize(SIZE);
        t.setFont(font.getFont());
        t.setForeground(Color.white);
        t.setRowHeight(ROW_HEIGHT);
        t.setBackground(Color.BLACK);
        final JScrollPane scrollPane = new JScrollPane(t);
        southP.add(scrollPane);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.white, BORDER_THICKNESS, true));
        t.setPreferredScrollableViewportSize(new Dimension(frame.getWidth() - WIDTH_DISTANCE, frame.getHeight() - HEIGHT_DISTANCE));
        t.setFillsViewportHeight(true);
        this.frame.setVisible(true);
        final JButton b = gf.createReturnButton(this.frame);
        b.addActionListener(e -> {
             this.frame.setVisible(false);
             this.mainMenuView.getFrame().setVisible(true);
        });
    }
    /**
     * 
     * @return frame
     */
     public JFrame getFrame() {
            return this.frame;
     }
}
