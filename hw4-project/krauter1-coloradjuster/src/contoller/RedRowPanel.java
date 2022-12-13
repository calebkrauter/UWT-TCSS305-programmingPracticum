package contoller;

import static java.lang.Integer.parseInt;
import static model.PropertyChangeEnabledMutableColor.PROPERTY_RED;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ColorModel;
import model.PropertyChangeEnabledMutableColor;

/**
 * Represents a Panel with components used to change and display the Red value for the 
 * backing Color model.
 *
 * @author Charles Bryan
 * @author Caleb Krauter
 * @version Autumn 2019
 */
public class RedRowPanel extends JPanel implements PropertyChangeListener {

    /**  
     * A generated serial version UID for object Serialization. 
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
    private static final long serialVersionUID = 2284116355218892348L;
    
    /** The size of the increase/decrease buttons. */
    private static final Dimension BUTTON_SIZE = new Dimension(26, 26);
    
    /** The size of the text label. */
    private static final Dimension LABEL_SIZE = new Dimension(45, 26);
    
    /** The number of columns in width of the TextField. */
    private static final int TEXT_FIELD_COLUMNS = 3;
    
    /** The amount of padding for the change panel. */
    private static final int HORIZONTAL_PADDING = 30;
    
    /** The backing model for the system. */
    private final PropertyChangeEnabledMutableColor myColor;

    /** The CheckBox that enables/disables editing of the TextField. */
    private final JCheckBox myEnableEditButton;
    
    /** The TextField that allows the user to type input for the coler value. */
    private final JTextField myValueField;
    
    /** The Button that when clicked increases the color value. */
    private final JButton myIncreaseButton;
    
    /** The Button that when clicked decreases the color value. */
    private final JButton myDecreaseButton;
    
    /** The Slider that when adjusted, changes the color value. */
    private final JSlider myValueSlider;
    
    /** The panel that visually displays ONLY the red value for the color. */
    private final JPanel myColorDisplayPanel;
    
    /**
     * Creates a Panel with components used to change and display the Red value for the 
     * backing Color model. 
     * @param theColor the backing model for the system
     */
    public RedRowPanel(final PropertyChangeEnabledMutableColor theColor) {
        super();
        myColor = theColor;
        myEnableEditButton = new JCheckBox("Enable edit");
        myValueField = new JTextField();
        myIncreaseButton = new JButton();
        myDecreaseButton = new JButton();
        myValueSlider = new JSlider();
        myColorDisplayPanel = new JPanel();
        layoutComponents();
        addListeners();
    }
    
    /**
     * Setup and add the GUI componets for this panel. 
     */
    private void layoutComponents() {
        myColorDisplayPanel.setPreferredSize(BUTTON_SIZE);
        myColorDisplayPanel.setBackground(new Color(myColor.getRed(), 0, 0));
        final JLabel rowLabel = new JLabel("Red: ");
        rowLabel.setPreferredSize(LABEL_SIZE);
        myValueField.setText(String.valueOf(myColor.getRed()));
        myValueField.setEditable(false);
        myValueField.setColumns(TEXT_FIELD_COLUMNS);
        myValueField.setHorizontalAlignment(JTextField.RIGHT);

        final JPanel rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0,
                                                             HORIZONTAL_PADDING,
                                                             0,
                                                             HORIZONTAL_PADDING));
        rightPanel.setBackground(rightPanel.getBackground().darker());
        myIncreaseButton.setIcon(new ImageIcon("./images/ic_increase_value.png"));
        myIncreaseButton.setPreferredSize(BUTTON_SIZE);
        myValueSlider.setMaximum(ColorModel.MAX_VALUE);
        myValueSlider.setMinimum(ColorModel.MIN_VALUE);
        myValueSlider.setValue(myColor.getRed());
        myValueSlider.setBackground(rightPanel.getBackground());
        myDecreaseButton.setIcon(new ImageIcon("./images/ic_decrease_value.png"));
        myDecreaseButton.setPreferredSize(BUTTON_SIZE);
        rightPanel.add(myDecreaseButton);
        rightPanel.add(myValueSlider);
        rightPanel.add(myIncreaseButton);

        add(myColorDisplayPanel);
        add(rowLabel);
        add(myValueField);
        add(myEnableEditButton);
        add(rightPanel);
    }


    /**
     * addListeners uses listeners to handle
     * events from user interaction with the gui.
     */
    private void addListeners() {
        //DO not remove the following statement.
        myColor.addPropertyChangeListener(PROPERTY_RED, this);

        final ActionListener newAction = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (theEvent.getSource().equals(myDecreaseButton)
                        && myColor.getRed() > ColorModel.MIN_VALUE) {
                    myColor.adjustRed(-1);
                    setEnableButtons();
                }
                if (theEvent.getSource().equals(myIncreaseButton)
                        && myColor.getRed() < ColorModel.MAX_VALUE) {
                    myColor.adjustRed(1);
                    setEnableButtons();

                }
            }
        };
        myValueField.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                tryingValue();
            }
        });
        myValueField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent theEvent) {
                tryingValue();
            }
        });

        final ChangeListener newChange = new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                if (theEvent.getSource().equals(myValueSlider)
                        && myValueSlider.getValueIsAdjusting()) {
                    myColor.setRed(myValueSlider.getValue());
                }
                setEnableButtons();
            }
        };

        myDecreaseButton.addActionListener(newAction);
        myIncreaseButton.addActionListener(newAction);
        myValueSlider.addChangeListener(newChange);
        myEnableEditButton.addChangeListener(theEvent -> {
            if (myEnableEditButton.isSelected()) {
                myValueField.setEditable(true);
            } else {
                myValueField.setEditable(false);

            }
        });

    }

    /**
     * Private helper method sets the boolean value for any
     * button.
     */
    private void setEnableButtons() {
        if (myColor.getRed() > ColorModel.MIN_VALUE) {
            myDecreaseButton.setEnabled(true);
        } else {
            myDecreaseButton.setEnabled(false);
        }
        if (myColor.getRed() < ColorModel.MAX_VALUE) {
            myIncreaseButton.setEnabled(true);
        } else {
            myIncreaseButton.setEnabled(false);
        }
    }

    /**
     * Private heper method tries different input values for the text field
     * and sets the value or text field accordingly.
     */
    private void tryingValue() {
        try {
            final int value = Integer.parseInt(myValueField.getText());
            if (value >= ColorModel.MIN_VALUE && value <= ColorModel.MAX_VALUE) {
                myColor.setRed(value);
            } else {
                myValueField.setText(String.valueOf(myColor.getRed()));
            }
        } catch (final NumberFormatException exception) {
            myValueField.setText(String.valueOf(myColor.getRed()));
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_RED.equals(theEvent.getPropertyName())) {
            myValueField.setText(theEvent.getNewValue().toString());
            myValueSlider.setValue((Integer) theEvent.getNewValue());
            myColorDisplayPanel.
                    setBackground(new Color((Integer) theEvent.getNewValue(), 0, 0));
        }
    }
}
