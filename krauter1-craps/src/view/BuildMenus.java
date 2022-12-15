package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_ESCAPE;

public class BuildMenus {
    public BuildMenus(JMenuItem startItem, JMenuItem resetItem, JMenuItem exitItem, JMenuItem optionsItem, JMenuItem aboutItem, JMenuItem rulesItem) {
        optionsItem.setToolTipText("press 'Alt/Option + O'");
        optionsItem.setAccelerator(KeyStroke.getKeyStroke(VK_O, ActionEvent.ALT_MASK));
        aboutItem.setToolTipText("press 'Alt/Option + A'");
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(VK_A, ActionEvent.ALT_MASK));
        rulesItem.setToolTipText("press 'Alt/Option + R'");
        rulesItem.setAccelerator(KeyStroke.getKeyStroke(VK_R, ActionEvent.ALT_MASK));
        startItem.setToolTipText("press 'Alt/Option + SPACE'");
        startItem.setAccelerator(KeyStroke.getKeyStroke(VK_SPACE, ActionEvent.ALT_MASK));
        resetItem.setToolTipText("press 'Alt/Option + S'");
        resetItem.setAccelerator(KeyStroke.getKeyStroke(VK_S, ActionEvent.ALT_MASK));
        exitItem.setToolTipText("press 'Alt/Option + ESC'");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(VK_ESCAPE, ActionEvent.ALT_MASK));
    }
}
